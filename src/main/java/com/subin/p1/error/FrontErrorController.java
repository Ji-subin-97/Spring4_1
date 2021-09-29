package com.subin.p1.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {
	
	@RequestMapping("error")
	public ModelAndView error400() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/front400");
		mv.addObject("msg", "관리자에게 문의하세요.");
		
		return mv;
	}
}
