package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimburstPojo;

public class ManagerDaoImpl implements ManagerDao{

	@Override
	public String decideReimburst(int reimburstId) throws ApplicationException {
		return null;
	}

	@Override
	public List<ReimburstPojo> viewPending() throws ApplicationException {
		
		Statement stmt;
		List<ReimburstPojo> allRequests = new ArrayList<ReimburstPojo>();
		ReimburstPojo reimburstPojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where status = 'pending'";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getDate(5) != null) {
				 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						rs.getDate(5).toString(), rs.getInt(6));
				 } else
					 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
								" ", rs.getInt(6));
			
			allRequests.add(reimburstPojo);}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allRequests;
	}

	@Override
	public List<ReimburstPojo> viewResolved() throws ApplicationException {
		
		Statement stmt;
		List<ReimburstPojo> allRequests = new ArrayList<ReimburstPojo>();
		ReimburstPojo reimburstPojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where status = 'Resolved'";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				if(rs.getDate(5).toString() != null) {
					 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
							rs.getDate(5).toString(), rs.getInt(6));
					 } else
						 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
									" ", rs.getInt(6));
				
				allRequests.add(reimburstPojo);
			}
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allRequests;
	}

	@Override
	public List<ReimburstPojo> viewRequests(int employeeId) throws ApplicationException {
		
		Statement stmt;
		List<ReimburstPojo> allRequests = new ArrayList<ReimburstPojo>();
		ReimburstPojo reimburstPojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where employee_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				if(rs.getDate(5)!= null) {
					 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
							rs.getDate(5).toString(), rs.getInt(6));
					 } else
						 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
									" ", rs.getInt(6));
				allRequests.add(reimburstPojo);
			}
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allRequests;
	}

	@Override
	public List<EmployeePojo> viewEmployees() throws ApplicationException {
		List<EmployeePojo> allEmployee = new ArrayList<EmployeePojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from employee_details";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				EmployeePojo employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

				allEmployee.add(employeePojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allEmployee;
	}

}
