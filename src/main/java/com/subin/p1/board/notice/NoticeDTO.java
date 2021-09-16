package com.subin.p1.board.notice;

import java.util.List;

import com.subin.p1.board.BoardDTO;
import com.subin.p1.board.BoardFilesDTO;

public class NoticeDTO extends BoardDTO {
	// is a
	// has a
	
	private List<BoardFilesDTO> files;

	public List<BoardFilesDTO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFilesDTO> files) {
		this.files = files;
	}
	
	
	
}
