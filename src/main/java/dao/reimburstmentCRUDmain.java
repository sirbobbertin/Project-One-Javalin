package dao;
import io.javalin.Javalin;
import pojo.EmployeePojo;
import pojo.ReimburstPojo;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ManagerService;
import service.ManagerServiceImpl;
import service.ReimburstService;
import service.ReimburstServiceImpl;

public class reimburstmentCRUDmain {

	public static void main(String[] args) {
		
		ReimburstService reimburstService = new ReimburstServiceImpl();
		EmployeeService employeeService = new EmployeeServiceImpl();
		ManagerService managerService = new ManagerServiceImpl();
		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4041);
		
		
		//pathParam - http://localhost:4040/api/books/5/Comedy
		//queryParam - http://localhost:4040/api/books/bookId=5&bookGenre=Comedy
		
		//http://localhost:4041/hello
		server.get("hello", (ctx) -> {
			// tell here what to do when the hello endpoint is requested for
			System.out.println("Hello endpoint is requested!!");
			ctx.result("Hello endpoint is requested!!");
		});

		//get all reimburstments
		server.get("api/reimburstments" , (ctx) -> {
			ctx.json(reimburstService.getAllReimburstments());
				});
		
		// to add reimburstments
		server.post("api/reimburstments", (ctx) -> {
			ReimburstPojo returnReimburstPojo = reimburstService.addReimburst(ctx.bodyAsClass(ReimburstPojo.class));
			System.out.println(ctx.json(returnReimburstPojo));
			ctx.json(returnReimburstPojo);
		});
		
		
		server.get("api/employees", (ctx)->{
			ctx.json(managerService.viewEmployees());
		});
		
		server.put("employees/profile/update/{eid}", (ctx) -> {
			EmployeePojo returnEmployeePojo = employeeService.updateInfo(ctx.bodyAsClass(EmployeePojo.class));
			ctx.json(returnEmployeePojo);
		});
		server.get("employees/profile/{eid}", (ctx) -> {
			ctx.json(employeeService.viewInfo(Integer.parseInt(ctx.pathParam("eid"))));
		});
		
		

}
}

