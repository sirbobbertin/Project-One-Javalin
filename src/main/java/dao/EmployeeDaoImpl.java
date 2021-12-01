package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimburstPojo;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeePojo updateInfo(EmployeePojo employeeUpdate) throws ApplicationException {
		Statement stmt;
		
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "Update employee_details SET address = '"+employeeUpdate.getAddress()+"',password = '"+employeeUpdate.getPassword()+"' WHERE employee_id = "+employeeUpdate.getId();
			stmt.executeUpdate(query);


			
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited ViewRequests() in dao.");
		return employeeUpdate;
		
	}

	@Override
	public EmployeePojo viewInfo(int employeeId) throws ApplicationException {
		Statement stmt;
		EmployeePojo employeeInfo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from employee_details where employee_id = "+employeeId;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next())
			 employeeInfo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

			
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited ViewRequests() in dao.");
		return employeeInfo;
		
	}

	@Override
	public EmployeePojo validateUser(EmployeePojo employeePojo) throws ApplicationException {
		
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			
			// fixed the code to return the generated book_id
			String query = "select * from employee_details where username = '"+employeePojo.getUserName()+"' and password = '"+employeePojo.getPassword()+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{employeePojo.setId(rs.getInt(1));
			 employeePojo.setAddress(rs.getString(4));
			 employeePojo.setJobType(rs.getInt(5));}
			else {
				String query2 = "select * from manager_details where username = '"+employeePojo.getUserName()+"' and password = '"+employeePojo.getPassword()+"'";
				ResultSet rs1 = stmt.executeQuery(query2);
				if(rs1.next())
				{employeePojo.setId(rs1.getInt(1));
				 employeePojo.setAddress(rs1.getString(4));
				 employeePojo.setJobType(rs1.getInt(5));}
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		//logger.info("Exited addReimburstment() in dao.");
		return employeePojo;
	}

}
