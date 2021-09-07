package com.subin.p1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardService;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(BoardDTO boardDTO) throws Exception {

		return noticeDAO.getList(boardDTO);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {

		return null;
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {

		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {

		return 0;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
	
		return 0;
	}
	
	
}
