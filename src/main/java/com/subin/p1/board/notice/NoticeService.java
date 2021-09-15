package com.subin.p1.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardService;
import com.subin.p1.board.util.FileManager;
import com.subin.p1.board.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servlet;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);

		pager.makeNum(totalCount);
		pager.makeRow();
		
		System.out.println(pager.getStartNum());
		System.out.println(pager.getLastNum());
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		//1. 어느 폴더 /resources/upload/notice/
		String realPath = servlet.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		for(MultipartFile multipartFile:files) {
			String fileName = fileManager.fileSave(file, multipartFile);
			System.out.println(fileName);
		}

		
		
		return 0 ; //noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

}
