package com.louis.kitty.admin.model;

/**
 * ---------------------------
 * 随访人员表 (BackResearchPeople)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-10-08 13:31:00
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class BackResearchPeople {

	/** ID */
	private Integer id;
	/** 患者姓名 */
	private String name;
	/** 性别 */
	private String sex;
	/** 系统编号 */
	private String xtNum;
	/** 研究编号 */
	private String yjNum;
	/** 住院编号 */
	private String zyNum;
	/** 门诊编号 */
	private String mzNum;
	/** 随访ID */
	private String flowId;
	/** 随访内容 */
	private String flowContent;
	/** 添加时间 */
	private java.util.Date addtime;
	/** 是否添加 */
	private String falg;
	/** 备注 */
	private String remarks;
	/** 预留一 */
	private String remarksOne;
	/** 项目ID */
	private String researchId;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getXtNum() {
		return xtNum;
	}

	public void setXtNum(String xtNum) {
		this.xtNum = xtNum;
	}

	public String getYjNum() {
		return yjNum;
	}

	public void setYjNum(String yjNum) {
		this.yjNum = yjNum;
	}

	public String getZyNum() {
		return zyNum;
	}

	public void setZyNum(String zyNum) {
		this.zyNum = zyNum;
	}

	public String getMzNum() {
		return mzNum;
	}

	public void setMzNum(String mzNum) {
		this.mzNum = mzNum;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFlowContent() {
		return flowContent;
	}

	public void setFlowContent(String flowContent) {
		this.flowContent = flowContent;
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

	public String getResearchId() {
		return researchId;
	}

	public void setResearchId(String researchId) {
		this.researchId = researchId;
	}

}