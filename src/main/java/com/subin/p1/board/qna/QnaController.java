package com.subin.p1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardFilesDTO;
import com.subin.p1.board.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
	
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = qnaService.getFile(boardDTO);
		
		mv.setViewName("board/select");
		mv.addObject("files", ar);
		mv.addObject("dto", boardDTO);
		
		return mv;
	}
	
	@GetMapping("delete")
	public String setDelete(BoardDTO boardDTO) throws Exception{
		
		int result = qnaService.setDelete(boardDTO);
		System.out.println(result);
		
		return "redirect:./list";
	}
	
	/*
	 * @GetMapping("insert") public ModelAndView setInsert() { ModelAndView mv = new
	 * ModelAndView(); mv.setViewName("board/insert");
	 * 
	 * return mv; }
	 */
	
	@GetMapping("insert")
	public String setInsert() {
		return "board/insert";
	}

	
	@PostMapping("insert")
	public String setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception{
		
		int result = qnaService.setInsert(boardDTO, files);
		System.out.println(result);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public ModelAndView getSelect(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		mv.setViewName("board/update");
		
		boardDTO = qnaService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		
		return mv;
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		
		int result = qnaService.setUpdate(boardDTO);
		System.out.println(result);
		
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public ModelAndView setReply() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/reply");
		return mv;
	}
	
	@PostMapping("reply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(qnaDTO);
		
		mv.setViewName("redirect:./list");
		
		return mv;
	}

}
