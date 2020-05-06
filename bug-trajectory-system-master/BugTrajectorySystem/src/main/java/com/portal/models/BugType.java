package com.portal.models;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	
	@Entity
	@Table(name="bug_type")
	public class BugType {
	       @Id
	       @Column(name="bugtype_id")
	       private String bId;
	       @Column(name="bug_type")
	       private String bType;
	       
	       public String getbId() {
	              return bId;
	       }
	       public void setbId(String bId) {
	              this.bId = bId;
	       }
	       public String getbType() {
	              return bType;
	       }
	       public void setbType(String bType) {
	              this.bType = bType;
	       }
	       @Override
	       public String toString() {
	              return "BugStatus [bId=" + bId + ", bType=" + bType + "]";
	       }
	}

