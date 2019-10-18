package com.louis.kitty.admin.model;


import java.util.LinkedList;
import java.util.List;

public class FollowOne {

	private String objid;

	private LinkedList<FollowTwo> remarks;

	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	public LinkedList<FollowTwo> getRemarks() {
		return remarks;
	}

	public void setRemarks(LinkedList<FollowTwo> remarks) {
		this.remarks = remarks;
	}
}
