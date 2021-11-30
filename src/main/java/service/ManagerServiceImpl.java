package service;

import java.util.List;

import dao.ManagerDao;
import dao.ManagerDaoImpl;
import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimburstPojo;

public class ManagerServiceImpl implements ManagerService {

	ManagerDao managerDao;
	
	public ManagerServiceImpl() {
		managerDao = new ManagerDaoImpl();
	}

	@Override
	public String decideReimburst(int reimburstId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimburstPojo> viewPending() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimburstPojo> viewResolved() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimburstPojo> viewRequests(int employeeId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeePojo> viewEmployees() throws ApplicationException {
		List<EmployeePojo> allEmployees = this.managerDao.viewEmployees();
		return allEmployees;
	}

}
