package com.my.entity;

public class Page {
	private int currentPage;
	private int totalPage;
	private int totalNumber;
	private int pageNumber;
	/**
	 * ���ݿ���limit�Ĳ������ӵڼ�����ʼȡ
	 */
	private int dbIndex;
	/**
	 * ���ݿ���limit�Ĳ�����һ��ȡ������
	 */
	private int dbNumber;
	
	/**
	 * ���㲢��ò�������
	 */
	public void count() {
		/**
		 * ������ҳ��
		 */
		if(totalNumber > pageNumber) {
			if(totalNumber%pageNumber != 0)
				totalPage = totalNumber/pageNumber + 1;
			else
				totalPage = totalNumber/pageNumber;

		}else {
			totalPage = 1;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}
		
		if(totalPage < currentPage) {
			currentPage = totalPage;
		}
		
		
		/**
		 * ������ʼ����
		 */
		this.dbIndex = (this.currentPage - 1)*this.pageNumber;
		this.dbNumber = this.pageNumber;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public int getDbNumber() {
		return dbNumber;
	}
	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
	
	
}
