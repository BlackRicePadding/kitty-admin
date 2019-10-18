package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 人员数据表 (PeopleData)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-10-11 17:50:31
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class PeopleData {

	/** ID */
	private Integer id;
	/** 项目ID */
	private String objid;
	/** 人员ID */
	private String peopleid;
	/** 项目ID */
	private String hobjectid;
	/** 周期ID */
	private String followid;
	/** 内容 */
	private String content;
	/** 添加时间 */
	private java.util.Date addtime;
	/** 标签 */
	private String falg;
	/** 备注 */
	private String remarks;

	public String getFollowid() {
		return followid;
	}

	public void setFollowid(String followid) {
		this.followid = followid;
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

	public String getPeopleid() {
		return peopleid;
	}

	public void setPeopleid(String peopleid) {
		this.peopleid = peopleid;
	}

	public String getHobjectid() {
		return hobjectid;
	}

	public void setHobjectid(String hobjectid) {
		this.hobjectid = hobjectid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

}