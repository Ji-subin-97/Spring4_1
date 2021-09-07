package com.subin.p1.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subin.p1.board.BoardDAO;
import com.subin.p1.board.BoardDTO;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sql_Sec;
	private final String NAMESPACE = "com.subin.p1.board.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> getList(BoardDTO boardDTO) throws Exception {

		return sql_Sec.selectList(NAMESPACE+"getList");
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
