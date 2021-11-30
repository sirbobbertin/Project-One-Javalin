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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimburstPojo> viewPending() throws ApplicationException {
		//logger.info("Entered viewRequests() in dao.");
		
		Statement stmt;
		List<ReimburstPojo> allRequests = new ArrayList<ReimburstPojo>();
		ReimburstPojo reimburstPojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where status = 'pending'";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						rs.getDate(5).toString(), rs.getInt(6));
			}
			allRequests.add(reimburstPojo);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited ViewRequests() in dao.");
		return allRequests;
	}

	@Override
	public List<ReimburstPojo> viewResolved() throws ApplicationException {
		//logger.info("Entered viewResolved() in dao.");
		
		Statement stmt;
		List<ReimburstPojo> allRequests = new ArrayList<ReimburstPojo>();
		ReimburstPojo reimburstPojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where status = 'resolved";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						rs.getDate(5).toString(), rs.getInt(6));
			}
			allRequests.add(reimburstPojo);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited viewResolved() in dao.");
		return allRequests;
	}

	@Override
	public List<ReimburstPojo> viewRequests(int employeeId) throws ApplicationException {
		//logger.info("Entered viewRequests() in dao.");
		
		Statement stmt;
		List<ReimburstPojo> allRequests = new ArrayList<ReimburstPojo>();
		ReimburstPojo reimburstPojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where employee_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				 reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						rs.getDate(5).toString(), rs.getInt(6));
			}
			allRequests.add(reimburstPojo);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited ViewRequests() in dao.");
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
		//logger.info("Exited viewEmployees() in dao.");
		return allEmployee;
	}

}
