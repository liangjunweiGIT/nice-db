package com.ls.demo.base.pojo.dao;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询参数类公用继承类，提供了分页、排序等功能的支持
 *
 */
public abstract class QueryCond implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1388895211616362595L;
	/**                         		if(ms.getStatementType() == type){
			return true ;
		}else{
			return false ;
		}

	 * 排序字符串
	 */
	public String orderByColumn;
	/** 起始下标 */
	private Integer startIndex = -1;
	/** 截止下标 */
	private Integer endIndex = 0;
	

	private Map<String, String> convertMap;
	/**
	 * 默认排序条件
	 */
	private String defaultOrder;

	/**
	 * 转换键值对
	 * 
	 * @return
	 */
	public Map<String, String> getConvertMap() {
		return convertMap;
	}

	public void setConvertMap(Map<String, String> convertMap) {
		this.convertMap = convertMap;
	}

	public String getOrderByColumn() {
		return orderByColumn;
	}

	public void setOrderByColumn(String orderByColumn) {
		this.orderByColumn = orderByColumn;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public String getDefaultOrder() {
		return defaultOrder;
	}

	public void setDefaultOrder(String defaultOrder) {
		this.defaultOrder = defaultOrder;
	}

}
