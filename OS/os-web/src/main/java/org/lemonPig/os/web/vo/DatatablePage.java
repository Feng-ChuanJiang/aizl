package org.lemonPig.os.web.vo;

import java.util.List;

import org.lemonPig.os.assist.mybaties.bean.PageList;


public class DatatablePage <T>{
	private String sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	private List<T> aaData;
	public DatatablePage(PageList<T> pageList) {
		this.aaData=pageList;
		this.iTotalRecords=pageList.getPaginator().getTotalCount();
		this.iTotalDisplayRecords=pageList.getPaginator().getTotalCount();
	}
	public DatatablePage(PageList<T> pageList,String sEcho) {
		this(pageList);
		this.sEcho=sEcho;
	}
	public String getsEcho() {
		return sEcho;
	}
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	public List<T> getAaData() {
		return aaData;
	}
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	
}
