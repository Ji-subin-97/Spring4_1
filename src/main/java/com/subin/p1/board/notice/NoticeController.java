package com.subin.p1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.subin.p1.board.BoardDTO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "NOTICE";
	}
	
	@GetMapping("list")
	public ModelAndView getList(BoardDTO boardDTO) throws Exception{
		
		List<BoardDTO> ar = noticeService.getList(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		mv.addObject("list", ar);
		
		return mv;
	}
}
