package com.subin.p1.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/**")
public class NoticeController {
	
	@GetMapping("list")
	public void test() {
		
	}
}
