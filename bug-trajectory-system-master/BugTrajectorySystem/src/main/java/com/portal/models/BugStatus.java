package com.portal.models;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	
	@Entity
	@Table(name="bug_status")
	public class BugStatus {
	       
	       @Id
	       @Column(name="status_id")
	       private String statusId;
	       @Column(name="status_name")
	       private String statusName;
	       public String getStatusId() {
	              return statusId;
	       }
	       public void setStatusId(String statusId) {
	              this.statusId = statusId;
	       }
	       public String getStatusName() {
	              return statusName;
	       }
	       public void setStatusName(String statusName) {
	              this.statusName = statusName;
	       }
	       @Override
	       public String toString() {
	              return "BugStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	       }
	       
	}

