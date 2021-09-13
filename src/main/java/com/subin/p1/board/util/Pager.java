package com.subin.p1.board.util;

public class Pager {
	
	private String kind;
	private String search; // 검색
	
	//////////////////////////////////////////////
	
	
	
	private Long startRow; // 시작번호
	private Long lastRow;  // 끝번호
	
	private Long pn; 
	// page number 한 페이지에 출력할 글의 갯수
	private Long perPage; 
	// 한 페이지에 출력할 pn의 갯수
	private Long perBlock;
	
	private Long startNum;
	private Long lastNum;
	
	private Long totalPage;
	
	public void makeNum(Long totalCount) {
		//1. totalCount 구하기
		
		//2. totalPage 구하기
		totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage += 1;
		}
		
		System.out.println(totalPage);
		//3. totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock += 1;
		}
		
		//4. pn으로 curBlock 구하기
		if(totalPage < this.getPn()) {
			this.setPn(totalPage);
		}
		
		Long curBlock = this.getPn()/this.getPerBlock();
		if(this.getPn()%this.getPerBlock() !=0) {
			curBlock += 1;
		}
		
		//5. curBlock으로 시작번호와 마지막번호 구하기
		System.out.println("1 :" + curBlock);
		System.out.println("2 :" + totalBlock);
		
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();

		//6. curBlock이 마지막 block 일때 lastNum 변경
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
	}
	
	//------------- RowNum 계산 ----------------------
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.getPerPage()+1;
		this.lastRow = this.getPn()*this.getPerPage();
	}
	
	//-------------- Setter, Getter-------------------
	
	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	// Parameter 처리
	public Long getPn() {
		if(this.pn==null || this.pn<=0) {
			this.pn = 1L;
		}
		return pn;
	}

	public void setPn(Long pn) {
		this.pn = pn;
	}
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getPerBlock() {
		this.perBlock = 5L;
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	

	public Long getTotalPage() {
		return totalPage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
}
