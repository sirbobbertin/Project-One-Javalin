package pojo;

public class ReimburstPojo {
	
	private int id;
	private String status;
	private float amount;
	private String date;
	private String sumbitDate;
	private int employeeId;
	
	 ReimburstPojo()
	{
		id=0;
		status="PENDING";
		amount=0.00f;
		date = " ";
		sumbitDate = " ";
		employeeId = 1;
		
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSumbitDate() {
		return sumbitDate;
	}

	public void setSumbitDate(String sumbitDate) {
		this.sumbitDate = sumbitDate;
	}

	public ReimburstPojo(int id,String status,float amount,String date, String sumbitDate,int employeeId) {
		super();
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.date = date;
		this.sumbitDate = sumbitDate;
		this.employeeId = employeeId;
	}

}
