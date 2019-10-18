package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 科研类型表 (ResearchTypes)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-10-08 13:31:00
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class ResearchTypes {

	/** ID */
	private Integer id;
	/** 类型名称 */
	private String name;
	/** 添加时间 */
	private java.util.Date addtime;
	/** 标签 */
	private String falg;
	/** 编码 */
	private String encoded;
	/** 备注 */
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEncoded() {
		return encoded;
	}

	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}