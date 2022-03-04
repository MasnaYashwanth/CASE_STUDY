package com.sonata.product.impl;

import com.sonata.product.interfaces.EmployeeIntf;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sonata.product.dbconnection.DbConnection;
import com.sonata.product.model.Employee;
import com.sonata.product.model.SuccessMessage;
import com.sonata.product.model.TimeSheet;
import com.sonata.product.model.Users;
import com.sonata.product.model.user;

@Service
public class EmployeeImpl implements EmployeeIntf {
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> emp = new ArrayList<>();
		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection().prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int empid = rs.getInt(1);
				String empname = rs.getString(2);
				String hcc = rs.getString(3);
				String emailid = rs.getString(4);
				Date doj = rs.getDate(5);

				Employee e1 = new Employee();
				e1.setEmpid(empid);
				e1.setEmpname(empname);
				e1.setHcc(hcc);
				e1.setEmailid(emailid);
				e1.setDoj(doj);

				emp.add(e1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<TimeSheet> getAllTimeSheet() {
		List<TimeSheet> time = new ArrayList<>();
		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection().prepareStatement("select * from  timesheet");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int empid = rs.getInt(2);
				Date date = rs.getDate(3);
				String activity = rs.getString(4);
				String description = rs.getString(5);
				int hrs = rs.getInt(6);
				String status = rs.getString(7);

				TimeSheet s1 = new TimeSheet();
				s1.setId(id);
				s1.setEmpid(empid);
				s1.setDate(date);
				s1.setActivity(activity);
				s1.setDescription(description);
				s1.setHrs(hrs);
				s1.setStatus(status);

				time.add(s1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public List<TimeSheet> getTimeSheetById(int empId) {
		List<TimeSheet> time = new ArrayList<>();
		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection().prepareStatement("select * from  timesheet where empid = ?");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int empid = rs.getInt(2);
				Date date = rs.getDate(3);
				String activity = rs.getString(4);
				String description = rs.getString(5);
				int hrs = rs.getInt(6);
				String status = rs.getString(7);

				TimeSheet s1 = new TimeSheet();
				s1.setId(id);
				s1.setEmpid(empid);
				s1.setDate(date);
				s1.setActivity(activity);
				s1.setDescription(description);
				s1.setHrs(hrs);
				s1.setStatus(status);

				time.add(s1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public List<Users> getAlluser() {
		List<Users> user = new ArrayList<>();
		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection().prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users u1 = new Users();
				String Role = rs.getString(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				u1.setRole(Role);
				u1.setUsername(username);
				u1.setPassword(password);
				user.add(u1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public SuccessMessage getUser(user obj) {
		String successMessage = "You are sucessfully logged in";
		String errorMessage = "User not found";
		SuccessMessage message = new SuccessMessage();

		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection()
					.prepareStatement("select * from users where  Role = ? && username = ? && password = ? ");
			ps.setString(1, obj.Role);
			ps.setString(2, obj.username);
			ps.setString(3, obj.password);
			ResultSet rs = ps.executeQuery();
			user u1 = new user();

			if (rs.next()) {
				u1.empid = rs.getInt(1);
				u1.Role = rs.getString(2);
				u1.username = rs.getString(3);
				u1.password = rs.getString(4);
				message.user = u1;

				message.setMessage(successMessage);

			} else {
				message.setMessage(errorMessage);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public SuccessMessage insertTimeSheet(TimeSheet obj) {

		String successMessage = "Insert Successful";
		String errorMessage = "Something went wrong";
		SuccessMessage message = new SuccessMessage();

		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection().prepareStatement(
					"insert into timesheet (empId,date,activity,description,hrs,status) values ( ?,?,?,?,?,?)");
			ps.setInt(1, obj.getEmpid());
			ps.setDate(2, (java.sql.Date) obj.getDate());
			ps.setString(3, obj.getActivity());
			ps.setString(4, obj.getDescription());
			ps.setInt(5, obj.getHrs());
			ps.setString(6, obj.getStatus());
			int rows = ps.executeUpdate();

			if (rows > 0) {
				message.setMessage(successMessage);

			} else {
				message.setMessage(errorMessage);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public String insertUser(user obj) {
		boolean isscuccess = false;
		String successMessage = " Insert Successful";
		String errorMessage = "Something went wrong";

		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection()
					.prepareStatement("insert into users (Role,username,password) values (?,?,?)");
			ps.setString(1, obj.Role);
			ps.setString(2, obj.username);
			ps.setString(3, obj.password);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				isscuccess = true;

			} else {
				isscuccess = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isscuccess ? successMessage : errorMessage;
	}

	@Override
	public SuccessMessage updateTimeSheet(TimeSheet obj) {
		String successMessage = " Update Successful";
		String errorMessage = "Something went wrong";
		SuccessMessage message = new SuccessMessage();

		try {
			DbConnection db = new DbConnection();
			PreparedStatement ps = db.getConnection().prepareStatement("update timesheet set status = ? where id = ?");
			ps.setString(1, obj.getStatus());
			ps.setInt(2, obj.getId());
			int rows = ps.executeUpdate();

			if (rows > 0) {
				message.setMessage(successMessage);

			} else {
				message.setMessage(errorMessage);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

}