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
		
		mv.addObject("files", memberFilesDTO);
		mv.setViewName("member/myPage");
		
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		//1. session 삭제
		//session.removeAttribute("member");
		
		//2. session의 시간을 0으로 만들어버림
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
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);   // redirect 해도 일정한 시간동안 계속 살아있음
		}else {
			System.out.println("로그인 실패");
		}

		mv.setViewName("redirect:../");
		
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
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception{
		
		String original = photo.getOriginalFilename();
		System.out.println("Original : " + original);
		
		ModelAndView mv = new ModelAndView();
		// int result = memberService.setJoin(memberDTO);
		int result = memberService.setJoin(memberDTO, photo, session);
		
		String message = "회원가입실패";
		if(result>0) {
			message = "회원가입성공";
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
		System.out.println("id 중복 체크");
		
		mv.addObject("IDCheck", memberDTO);
		
		mv.setViewName("member/idCheck");
		
		return mv;
	}
}
