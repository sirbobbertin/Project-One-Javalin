package service;

//import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;

public interface EmployeeService {

	EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException;
	EmployeePojo viewInfo(int employeeId) throws ApplicationException;
	EmployeePojo validateUser(EmployeePojo employeePojo) throws ApplicationException;
}
