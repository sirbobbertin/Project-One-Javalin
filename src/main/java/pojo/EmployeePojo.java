package pojo;

public class EmployeePojo {

	private int id;
	private String username;
	private String password;
	private String address;
	private int jobType;
	
	
	
	
	EmployeePojo()
	{
		id=0;
		username =" ";
		password =" ";
		address = " ";
		jobType = 1;
		
	}
	public int getJobType() {
		return jobType;
	}

	public void setJobType(int jobType) {
		this.jobType = jobType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public EmployeePojo(int id, String username, String password, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.address = address;
	}
}
