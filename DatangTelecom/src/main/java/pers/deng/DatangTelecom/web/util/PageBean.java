package pers.deng.DatangTelecom.web.util;

import java.util.List;

public class PageBean<T> {
	private List<T> data;//���ڱ����ѯ����
	private T data1;
	private int recordCount;//��¼����
	private int pageNo;//ҳ��
	private int pageSize;//ҳ��С
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<T> getData() {
		return data;
	}


	public void setData(List<T> data) {
		this.data = data;
	}


	public T getData1() {
		return data1;
	}


	public void setData1(T data1) {
		this.data1 = data1;
	}


	public int getRecordCount() {
		return recordCount;
	}


	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	//��¼������ÿҳ��С-1/ÿҳ��С�ó�ҳ��
	public int getTotalCount(){
		return (recordCount+pageSize-1)/pageSize;
	}
	
	//��ҳ����ʲô�������1
	public int getHomePage(){
		return 1;
	}
	
	public int getTrailerPage(){
		if(recordCount==0){//û��¼������¾��ǵ�һҳ
			return 1;
		}
		//��������¾������һҳ
		return this.getTotalCount();
	}
	
	//��ȡǰһҳ
		public int getPreviousPage(){
			if(this.pageNo==1){
				return this.pageNo;//��һҳ������ҳ�ˣ����Է��ص�ǰҳ
			}
			return this.pageNo-1;
		}
		
		//��ȡ��һҳ
		public int getNextPage(){
			if(this.pageNo==this.getTotalCount()){//��ǰҳ��������һҳ���޷���ȥ����һҳ��
				return this.pageNo;
			}
			return this.pageNo+1;
		}
	
}
