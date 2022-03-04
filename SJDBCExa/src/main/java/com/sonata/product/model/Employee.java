package com.sonata.product.model;

import java.sql.Date;

public class Employee {
	private int empid;
	private String empname;
	private String hcc;
	private String emailid;
	private Date doj;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getHcc() {
		return hcc;
	}
	public void setHcc(String hcc) {
		this.hcc = hcc;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", hcc=" + hcc + ", emailid=" + emailid + ", doj="
				+ doj + "]";
	}
	

}
