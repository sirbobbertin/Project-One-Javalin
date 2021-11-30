package dao;

	import java.util.List;

	import exception.ApplicationException;
	import pojo.ReimburstPojo;
	import pojo.EmployeePojo;
//	import pojo.ManagerPojo;
	
public interface ManagerDao {
	
	String decideReimburst(int reimburstId) throws ApplicationException;
	List<ReimburstPojo> viewPending() throws ApplicationException;
	List<ReimburstPojo> viewResolved() throws ApplicationException;
	List<ReimburstPojo> viewRequests(int employeeId) throws ApplicationException;
	List<EmployeePojo> viewEmployees() throws ApplicationException;

}
