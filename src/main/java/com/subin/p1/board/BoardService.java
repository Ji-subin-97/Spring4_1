package com.subin.p1.board;

import java.util.List;

import com.subin.p1.board.util.Pager;

public interface BoardService {

	//List
	public abstract List<BoardDTO>  getList(Pager pager)throws Exception;

	//상세
	public abstract BoardDTO getSelect(BoardDTO boardDTO)throws Exception;

	//글쓰기
	public int setInsert(BoardDTO boardDTO)throws Exception;

	//글삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;

	//글수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;

}
