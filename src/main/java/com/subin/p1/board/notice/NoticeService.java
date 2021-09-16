package com.subin.p1.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardFilesDTO;
import com.subin.p1.board.BoardService;
import com.subin.p1.board.util.FileManager;
import com.subin.p1.board.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servlet;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardFilesDTO> getFile(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getFile(boardDTO);
	}

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
		
		//List<BoardFilesDTO> ar = noticeDAO.getFile(boardDTO);
		
		
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		//1. 어느 폴더 /resources/upload/notice/
		String realPath = servlet.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		System.out.println("Before Num :" + boardDTO.getNum());
		
		int result  = noticeDAO.setInsert(boardDTO);
		
		System.out.println("After Num :" + boardDTO.getNum());
		
		//max()
		
		for(MultipartFile multipartFile:files) {
			String fileName = fileManager.fileSave(file, multipartFile);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum()); 
			
			result = noticeDAO.setFile(boardFilesDTO);
		}

		
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		//Files Table에서 삭제할 파일명들 조회
		List<BoardFilesDTO> ar = noticeDAO.getFile(boardDTO);
		
		//어느폴더
		String realPath = servlet.getRealPath("/resources/upload/notice/");
		for(BoardFilesDTO bDto:ar) {
			File file = new File(realPath, bDto.getFileName());
			fileManager.fileDelete(file);
		}
		
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

}
