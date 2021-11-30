package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;
import pojo.ReimburstPojo;

public class ReimburstDaoImpl implements ReimburstDao {

	@Override
	public ReimburstPojo addReimburst(ReimburstPojo reimburstPojo) throws ApplicationException {
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			
			// fixed the code to return the generated book_id
			String query = "insert into reimburstment_details(status,amount,date_created, employee_id) values('PENDING', "+ 
					reimburstPojo.getAmount()+",'"+reimburstPojo.getDate()
					+"',"+reimburstPojo.getEmployeeId()+") returning reimburstment_id";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			reimburstPojo.setId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		
		//logger.info("Exited addReimburstment() in dao.");
		return reimburstPojo;
		
	}


	@Override
	public List<ReimburstPojo> getUserReimburstments(int userId) throws ApplicationException {
		
		List<ReimburstPojo> userReimburstments = new ArrayList<ReimburstPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where employee_id = "+userId;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimburstPojo reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						" ",rs.getInt(6));

				userReimburstments.add(reimburstPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited getAllReimburstments() in dao.");
		return userReimburstments;
	}


	@Override
	public List<ReimburstPojo> getAllReimburstments() throws ApplicationException {
		List<ReimburstPojo> allReimburstments = new ArrayList<ReimburstPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimburstPojo reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						" ",rs.getInt(6));

				allReimburstments.add(reimburstPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited getAllReimburstments() in dao.");
		return allReimburstments;
	}

	@Override
	public ReimburstPojo getAReimburst(int reimburstId) throws ApplicationException {

		return null;
	}

	@Override
	public void exitApplication() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ReimburstPojo> getUserResolvedReimburstments(int userId) throws ApplicationException {
		List<ReimburstPojo> userReimburstments = new ArrayList<ReimburstPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where employee_id = "+userId+" and status = 'RESOLVED'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimburstPojo reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						" ",rs.getInt(6));

				userReimburstments.add(reimburstPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited getAllReimburstments() in dao.");
		return userReimburstments;
	}


	@Override
	public List<ReimburstPojo> getUserPendingReimburstments(int userId) throws ApplicationException {
		List<ReimburstPojo> userReimburstments = new ArrayList<ReimburstPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where employee_id = "+userId+" and status = 'PENDING'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimburstPojo reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						" ",rs.getInt(6));

				userReimburstments.add(reimburstPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited getAllReimburstments() in dao.");
		return userReimburstments;
	}


	@Override
	public List<ReimburstPojo> getResolvedReimburstments() throws ApplicationException {
		List<ReimburstPojo> allReimburstments = new ArrayList<ReimburstPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where status = 'RESOLVED'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimburstPojo reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						" ",rs.getInt(6));

				allReimburstments.add(reimburstPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited getAllReimburstments() in dao.");
		return allReimburstments;
	}


	@Override
	public List<ReimburstPojo> getPendingReimburstments() throws ApplicationException {
		List<ReimburstPojo> allReimburstments = new ArrayList<ReimburstPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from reimburstment_details where status ='PENDING'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimburstPojo reimburstPojo = new ReimburstPojo(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4).toString(),
						" ",rs.getInt(6));

				allReimburstments.add(reimburstPojo);

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		//logger.info("Exited getAllReimburstments() in dao.");
		return allReimburstments;
	}

}
