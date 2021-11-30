package service;

//import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ApplicationException;
import pojo.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Override
	public EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException {
		return this.employeeDao.updateInfo(employeePojo);
	}

	@Override
	public EmployeePojo viewInfo(int employeeId) throws ApplicationException {		
		return this.employeeDao.viewInfo(employeeId);
	}

	@Override
	public EmployeePojo validateUser(EmployeePojo employeePojo) throws ApplicationException {
		return this.employeeDao.validateUser(employeePojo);
	}

}
