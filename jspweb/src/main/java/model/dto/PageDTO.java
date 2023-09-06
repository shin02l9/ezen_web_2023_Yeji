package model.dto;

import java.util.ArrayList;

public class PageDTO {
	
	// DB 필드를 사용하지 않음!
	
	// 현재 페이지
	private int page;
	// 페이지당 최대 게시물
	private int listsize;
	// 현재 페이지에서 시작되는 레코드번호
	// private int startrow; 나는 이거 안썼음
	// 전체 게시물 수 
	private int totalsize;
	// 전체 페이지 수 
	private int totalpage;
	// 페이지 버튼 시작번호
	private int startbtn;
	// 페이지 버튼 끝번호
	private int endbtn;
	
	// 게시물 리스트 
	ArrayList<BoardDTO> boardlist;


	public PageDTO() {
		super();
	}

	
	
	
	
	public PageDTO(int page, int listsize, int totalsize, int totalpage, int startbtn, int endbtn,
			ArrayList<BoardDTO> boardlist) {
		super();
		this.page = page;
		this.listsize = listsize;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.startbtn = startbtn;
		this.endbtn = endbtn;
		this.boardlist = boardlist;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListsize() {
		return listsize;
	}

	public void setListsize(int listsize) {
		this.listsize = listsize;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public ArrayList<BoardDTO> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(ArrayList<BoardDTO> boardlist) {
		this.boardlist = boardlist;
	}

	
	public int getStartbtn() {
		return startbtn;
	}

	public void setStartbtn(int startbtn) {
		this.startbtn = startbtn;
	}

	public int getEndbtn() {
		return endbtn;
	}

	public void setEndbtn(int endbtn) {
		this.endbtn = endbtn;
	}

	@Override
	public String toString() {
		return "PageDTO [page=" + page + ", listsize=" + listsize + ", totalsize=" + totalsize + ", totalpage="
				+ totalpage + ", startbtn=" + startbtn + ", endbtn=" + endbtn + ", boardlist=" + boardlist + "]";
	}

	
	
	
	

}
