package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 字典表 (HDictionry)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-09-02 18:30:28
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class HDictionry {

	/** ID */
	private Integer id;
	/** 父类ID */
	private String pid;
	/** 内容 */
	private String content;
	/** 名称 */
	private String name;
	/** 标签 */
	private String falg;
	/** 添加时间 */
	private java.util.Date addtime;
	/** 备注 */
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFalg() {
		return falg;
	}

	public void setFalg(String falg) {
		this.falg = falg;
	}

	public java.util.Date getAddtime() {
		return addtime;
	}

	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}