package com.subin.p1.board.qna;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.subin.p1.board.BoardDAO;
import com.subin.p1.board.BoardDTO;

@Repository
public class QnaDAO implements BoardDAO{

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
