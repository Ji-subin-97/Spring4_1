package com.subin.p1.board.qna;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardService;

@Service
public class QnaService implements BoardService{

	@Override
	public List<BoardDTO> getList() throws Exception {

		return null;
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
