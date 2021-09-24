package com.subin.p1.board.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardFilesDTO;
import com.subin.p1.board.CommentsDTO;
import com.subin.p1.board.util.Pager;

import oracle.net.aso.f;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@PostMapping("updateComment")
	public ModelAndView setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setCommentUpdate(commentsDTO);
		
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@PostMapping("setCommentDelete")
	public ModelAndView setCommentDelete(CommentsDTO commentsDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setCommentDelete(commentsDTO);
		
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	@GetMapping("getCommentList")
	public ModelAndView getCommentList(CommentsDTO commentsDTO, Pager pager) throws Exception{
		commentsDTO.setBoard("N");
		List<CommentsDTO> ar = noticeService.getCommentList(commentsDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		
		return mv;
	}
	
	//setComment
	@PostMapping("comment")
	public ModelAndView setComment(CommentsDTO commentsDTO) throws Exception{
		commentsDTO.setBoard("N");
		int result = noticeService.setComment(commentsDTO);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("dto", boardFilesDTO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	
//	@RequestMapping(value = "list", method = RequestMethod.GET)
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");
		
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		
		return mv;
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = noticeService.getFile(boardDTO);
		//List<CommentsDTO> comments = noticeService.getCommentList();
		//mv.addObject("comments", comments);
		//mv.addObject("files", ar);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		
		return mv;
	}
	
	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		System.out.println(result);
		
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("url", "./list");
		
		mv.setViewName("common/result");
		
		return mv;
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
	public String setInsert(BoardDTO boardDTO, MultipartFile []files) throws Exception{
		
		//original file name 출력
		
		for(int i=0; i<files.length; i++) {
			System.out.println(files[i].getOriginalFilename());
		}
		
		noticeService.setInsert(boardDTO, files);
		//int result = noticeService.setInsert(boardDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public ModelAndView getSelect(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		
		mv.setViewName("board/update");
		
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		
		return mv;
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		
		int result = noticeService.setUpdate(boardDTO);
		System.out.println(result);
		
		return "redirect:./list";
	}
}
