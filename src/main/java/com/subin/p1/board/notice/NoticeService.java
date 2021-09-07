package com.subin.p1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardService;
import com.subin.p1.board.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;

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
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setInsert(boardDTO);
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
