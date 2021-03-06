package com.subin.p1.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.subin.p1.board.BoardDAO;
import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardFilesDTO;
import com.subin.p1.board.CommentsDTO;
import com.subin.p1.board.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.subin.p1.board.notice.NoticeDAO.";

	@Override
	public Long getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setFile(BoardFilesDTO boardFilesDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setFile", boardFilesDTO);
	}

	@Override
	public List<BoardFilesDTO> getFile(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getFile", boardDTO);
	}
	
	public int setComment(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setComment", commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCommentList", map);
	}
	
	public Long getTotalComment(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotalComment", commentsDTO);
	}
	
	public int setCommentDelete(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setCommentDelete", commentsDTO);
	}
	
	public int setCommentUpdate(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setCommentUpdate", commentsDTO);
	}
	
	public int setFileDelete(BoardFilesDTO boardFilesDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setFileDelete", boardFilesDTO);
	}

}
