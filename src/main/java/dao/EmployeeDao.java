package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;

public interface EmployeeDao {

	EmployeePojo updateInfo(EmployeePojo employeeUpdate) throws ApplicationException;
	EmployeePojo viewInfo(int employeeId) throws ApplicationException;
	EmployeePojo validateUser(EmployeePojo employeePojo) throws ApplicationException;
}
