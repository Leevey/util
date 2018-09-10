package com.jingsky.util.api;

import java.io.Serializable;

/**
 * 分页传递给API的参数
 */
public class PageInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 页码
	 */
	private Integer pageNo = 1;
	/**
	 * 每页记录数
	 */
	private Integer pageSize = 10;
	/**
	 * 总页码
	 */
	private Integer totalNo;
	/**
	 * 总记录数
	 */
	private Integer totalSize;

	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		if(pageNo == null || pageNo < 1){
			this.pageNo = 1;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		if(pageSize == null || pageSize < 1){
			this.pageSize = 10;
		}
	}

	public Integer getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(Integer totalSize) {
		this.totalNo = totalNo;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
		if(totalSize != null && this.pageSize != null){
			if(totalSize % pageSize == 0){
				this.totalNo = totalSize / pageSize;
			}else{
				this.totalNo = totalSize / pageSize + 1;
			}
		}
	}
}