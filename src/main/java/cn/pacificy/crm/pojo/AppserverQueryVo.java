package cn.pacificy.crm.pojo;

public class AppserverQueryVo {

	//用于接收页面上的所有的查询信息
	private String appserverName;

	
	//分页条件  每页多少条
	private int size=10;
	
	
	//当前页  
	private int page =1;
	
	
	// 起始行
	private int start ;
	
	
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getAppserverName() {
		return appserverName;
	}

	public void setAppserverName(String appserverName) {
		this.appserverName = appserverName;
	}


	
	
}
