package com.sonata.product.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.sonata.product.model.Employee;
import com.sonata.product.model.SuccessMessage;
import com.sonata.product.model.TimeSheet;
import com.sonata.product.model.Users;
import com.sonata.product.model.user;


public interface EmployeeIntf {
	public List<Employee> getAllEmployee();
	public SuccessMessage insertTimeSheet(TimeSheet obj);
	public List<TimeSheet> getAllTimeSheet() ;
	public List<TimeSheet> getTimeSheetById(int empId) throws SQLException;
	public List<Users> getAlluser();
	public SuccessMessage getUser(user obj);
	public String insertUser(user obj);
	public SuccessMessage updateTimeSheet(TimeSheet obj);
	
	
}