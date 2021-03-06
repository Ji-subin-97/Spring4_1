package com.subin.p1.member;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("delete")
	public ModelAndView delete(MemberDTO memberDTO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = memberService.setDelete(memberDTO);
		
		session.invalidate();
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@PostMapping("update")
	public ModelAndView update(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		MemberDTO sessionDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sessionDTO.getId());
		
		int result = memberService.setUpdate(memberDTO);
		
		session.removeAttribute("member");
		session.setAttribute("member", memberDTO);
		
		mv.setViewName("redirect:./myPage");
		
		return mv;
	}
	
	@GetMapping("update")
	public ModelAndView update() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/update");
		
		return mv;
	}
	
	@GetMapping("myPage")
	public ModelAndView mypage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		MemberFilesDTO memberFilesDTO = memberService.getFile(memberDTO);
		
		//mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/myPage");
		
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		//1. session ??????
		//session.removeAttribute("member");
		
		//2. session??? ????????? 0?????? ???????????????
		session.invalidate();
		
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		
		return mv;
	}
	
	
	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception{

		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {
			System.out.println("????????? ??????");
			session.setAttribute("member", memberDTO);   // redirect ?????? ????????? ???????????? ?????? ????????????
		}else {
			System.out.println("????????? ??????");
		}

		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	@GetMapping("idCheckAjax")
	public ModelAndView getIdCheckAjax(MemberDTO memberDTO) throws Exception{
		// ??????????????? id ??????
		System.out.println(memberDTO.getId());
		memberDTO = memberService.getIDCheck(memberDTO);
		//1 ?????? ?????? ??????
		//0 ?????? ?????? ??????
		int result = 0;
		if(memberDTO==null) {
			result = 1;
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@GetMapping("check")
	public ModelAndView check() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/check");
		
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView join() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo) throws Exception{
		
		String original = photo.getOriginalFilename();
		System.out.println("Original : " + original);
		
		ModelAndView mv = new ModelAndView();
		// int result = memberService.setJoin(memberDTO);
		int result = memberService.setJoin(memberDTO, photo);
		
		String message = "??????????????????";
		if(result>0) {
			message = "??????????????????";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "../");
		mv.setViewName("common/result");
		
		return mv;
	}
	
	@GetMapping("idCheck")
	public ModelAndView getIDCheck(MemberDTO memberDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.getIDCheck(memberDTO);
		System.out.println("id ?????? ??????");
		
		mv.addObject("IDCheck", memberDTO);
		
		mv.setViewName("member/idCheck");
		
		return mv;
	}
}
