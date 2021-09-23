package com.subin.p1.board;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.subin.p1.MyJuntiTest;
import com.subin.p1.board.notice.NoticeDAO;

public class CommentDAOTest extends MyJuntiTest{

	@Autowired
	NoticeDAO noticeDAO;
	
	@Test
	public void test() throws Exception{
		for(int i=0; i<100; i++) {
			CommentsDTO commentsDTO = new CommentsDTO();
			commentsDTO.setNum(269L);
			commentsDTO.setWriter("t1");
			commentsDTO.setContents("contents" + i);
			commentsDTO.setBoard("N");
			noticeDAO.setComment(commentsDTO);
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("Fin");
	}
}
