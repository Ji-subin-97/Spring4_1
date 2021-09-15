package com.subin.p1.member;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private ServletContext servletContext;
	
	public MemberFilesDTO getFile(MemberDTO memberDTO) throws Exception{
		return memberDAO.getFile(memberDTO);
	}
	
	public MemberDTO getIDCheck(MemberDTO memberDTO) throws Exception{
		return memberDAO.getIDCheck(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO, MultipartFile photo) throws Exception{
		
		int result = memberDAO.setJoin(memberDTO);
		
		if(photo != null) {
		//1. 어느 폴더에 저장
		// /resources/upload/member
		//2. application(ServletContext) 객체로 저장할 실제 경로 구하기
		
		//ServletContext sContext = this.session.getServletContext();
		String realPath = this.servletContext.getRealPath("/resources/upload/member/");
		System.out.println("RealPath: " + realPath);
		
		//3. 폴더 확인
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//4. 중복 되지 않는 파일 저장
		//a. 시간-> 밀리세컨즈
		//b. UUID
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + photo.getOriginalFilename();
		System.out.println(fileName);
		
		//폴더와 파일명 정보
		file = new File(file, fileName);
		
		//5. 폴더에 파일 저장
		//1) MultipartFile 의 transferTo 메서드 사용
		//photo.transferTo(file);
		
		//2) Spring 의 API FileCopyUtils의 cop 메서드 사용
		FileCopyUtils.copy(photo.getBytes(), file);
		
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		memberFilesDTO.setId(memberDTO.getId());
		memberFilesDTO.setFileName(fileName);
		memberFilesDTO.setOriName(photo.getOriginalFilename());
		result = memberDAO.setFileInsert(memberFilesDTO);
		}
		
		return result;
	}
	
	public int setUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.setUpdate(memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO) throws Exception{
		//1. 어느폴더
		String realPath = servletContext.getRealPath("/resources/upload/member/");
		
		//2. 어느파일
		MemberFilesDTO memberFilesDTO = memberDAO.getFile(memberDTO);
		
		//3. 파일 삭제
		File file = new File(realPath, memberFilesDTO.getFileName());
		file.delete();
		
		return memberDAO.setDelete(memberDTO);
	}
}
