package com.portal.models;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	
	@Entity
	@Table(name="Severity")
	public class Severity {
	@Id
	@Column(name="severity_id")
	private String sId;
	@Column(name="severity_name")
	private String sType;
	public String getsId() {
	       return sId;
	}
	public void setsId(String sId) {
	       this.sId = sId;
	}
	public String getsType() {
	       return sType;
	}
	public void setsType(String sType) {
	       this.sType = sType;
	}
	@Override
	public String toString() {
	       return "Severity [sId=" + sId + ", sType=" + sType + "]";
	}  
	}

