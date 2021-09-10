package com.subin.p1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.subin.p1.board.qna.QnaDAO;
import com.subin.p1.board.qna.QnaDTO;
import com.subin.p1.member.MemberDAO;
import com.subin.p1.member.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MyJuntiTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void test() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		for(int i=0;i<200;i++) {
			qnaDTO.setTitle("답글 " + i);
			qnaDTO.setContents("내용 " + i);
			qnaDTO.setWriter("관리자");
			
			int result = qnaDAO.setInsert(qnaDTO);
			
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("Finish=====================================");
	}
	
	
	@Test
	public void test2() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("t1");
		memberDTO.setPw("t1");
		
		memberDTO = memberDAO.getIDCheck(memberDTO);
		
		assertNotNull(memberDTO);
		
	}
	
}
