package com.subin.p1.board;

import java.util.List;

public interface BoardDAO {
	
	//1. List
	public List<BoardDTO> getList(BoardDTO boardDTO) throws Exception;
	
	//2. SelectOne
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//3. Insert
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//4. Update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//5. Delete
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
}
