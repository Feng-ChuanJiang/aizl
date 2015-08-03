package org.lemonPig.os.core.support;

import java.util.List;

import org.lemonPig.os.assist.mybaties.bean.PageList;
import org.lemonPig.os.assist.mybaties.bean.Paginator;

@Deprecated
public class Page<T> {
	private List<T> datas;
	private Paginator paginator;
	public Page(PageList<T> pageList){
		this.datas=pageList;
		this.paginator=pageList.getPaginator();
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public Paginator getPaginator() {
		return paginator;
	}
	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
}
