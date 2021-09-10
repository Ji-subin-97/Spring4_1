package com.subin.p1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		
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
