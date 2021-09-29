package com.subin.p1.error;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ServerErrorController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView getException() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlgetException() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		
		return mv;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNullPointerException() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/serverError");
		
		return mv;
	}
}
