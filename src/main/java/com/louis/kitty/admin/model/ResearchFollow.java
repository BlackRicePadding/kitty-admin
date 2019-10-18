package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 项目周期表 (ResearchFollow)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-10-08 13:31:00
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class ResearchFollow {

	/** ID */
	private Integer id;
	/** 项目ID */
	private String objid;
	/** 名称 */
	private String name;
	/** 排序 */
	private String sort;
	/** 父类ID */
	private String pid;
	/** 添加时间 */
	private java.util.Date addtime;
	/** 标签 */
	private String falg;
	/** 备注 */
	private String remarks;
	/** 预留一 */
	private String remarksOne;
	/** 内容 */
	private String content;

	private Object child;

	public Object getChild() {
		return child;
	}

	public void setChild(Object child) {
		this.child = child;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public java.util.Date getAddtime() {
		return addtime;
	}

	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}

	public String getFalg() {
		return falg;
	}

	public void setFalg(String falg) {
		this.falg = falg;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksOne() {
		return remarksOne;
	}

	public void setRemarksOne(String remarksOne) {
		this.remarksOne = remarksOne;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}