package com.sonata.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sonata.product.impl.EmployeeImpl;
import com.sonata.product.model.Employee;
import com.sonata.product.model.SuccessMessage;
import com.sonata.product.model.TimeSheet;
import com.sonata.product.model.Users;
import com.sonata.product.model.user;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeImpl empService;
	
	@GetMapping(value="/emp")
	public List<Employee> getEmp(){
		return empService.getAllEmployee();
	}
	@GetMapping(value="/user")
	public List<Users> getuser(){
		return empService.getAlluser();
	}
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public SuccessMessage addUser(@RequestBody user userdata) {
		return empService.getUser(userdata);
		}
	@RequestMapping(method=RequestMethod.POST, value="/userinsert")
	public String insertUser(@RequestBody user userdata) {
		return empService.insertUser(userdata);
		}
	@RequestMapping(method=RequestMethod.POST, value="/insert")
	public SuccessMessage insertTimeSheet(@RequestBody TimeSheet timeSheet) {
		return empService.insertTimeSheet(timeSheet);
		}
	@RequestMapping(method=RequestMethod.POST, value="/update")
	public SuccessMessage updateTimeSheet(@RequestBody TimeSheet timeSheet) {
		return empService.updateTimeSheet(timeSheet);
		}
	
	@GetMapping(value="/timesheet")
	public List<TimeSheet> geTime(){
		return empService.getAllTimeSheet();
	}
	
	
	@GetMapping( value = "/timesheets/{id}")
		public List<TimeSheet> geTimesheets(@PathVariable("id") int id) throws SQLException{
			return empService. getTimeSheetById(id);
		}
	
	
	
	
	
}