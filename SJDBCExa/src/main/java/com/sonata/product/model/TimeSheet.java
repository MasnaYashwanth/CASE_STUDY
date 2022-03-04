package com.sonata.product.model;

import java.sql.Date;

public class TimeSheet {
	private int id;
	private int empid;
	private Date date;
	private String activity;
	private String description;
	private int hrs;
	private String status;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TimeSheet [id=" + id + ", empid=" + empid + ", date=" + date + ", activity="
				+ activity + ", description=" + description + ", hrs=" + hrs + ", status=" + status + "]";
	}

}
