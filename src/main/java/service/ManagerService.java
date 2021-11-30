package service;

import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimburstPojo;

public interface ManagerService {

	String decideReimburst(int reimburstId) throws ApplicationException;
	List<ReimburstPojo> viewPending() throws ApplicationException;
	List<ReimburstPojo> viewResolved() throws ApplicationException;
	List<ReimburstPojo> viewRequests(int employeeId) throws ApplicationException;
	List<EmployeePojo> viewEmployees() throws ApplicationException;
}
