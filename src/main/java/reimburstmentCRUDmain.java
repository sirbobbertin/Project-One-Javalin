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
		
		
		

		//get all reimburstments
		server.get("api/reimburstments" , (ctx) -> {
			ctx.json(reimburstService.getAllReimburstments());
				});
		//get all resolved
		server.get("api/reimburstments/resolved" , (ctx) -> {
			ctx.json(reimburstService.getResolvedReimburstments());
				});
		//get all pending
		server.get("api/reimburstments/pending" , (ctx) -> {
			ctx.json(reimburstService.getPendingReimburstments());
				});
		//get Resolved Reimburstments
		server.get("api/reimburstments/resolved/{eid}" , (ctx) -> {
			ctx.json(reimburstService.getUserResolvedReimburstments(Integer.parseInt(ctx.pathParam("eid"))));
				});
		//get Pending Reimburstments
		server.get("api/reimburstments/pending/{eid}" , (ctx) -> {
			ctx.json(reimburstService.getUserPendingReimburstments(Integer.parseInt(ctx.pathParam("eid"))));
				});
		//get User Reimburstments
		server.get("api/reimburstments/{eid}" , (ctx) -> {
			ctx.json(reimburstService.getUserReimburstments(Integer.parseInt(ctx.pathParam("eid"))));
				});
		//get a Reimburstment
		server.get("api/reimburstments/single/{rid}" , (ctx) -> {
			ctx.json(reimburstService.getAReimburst(Integer.parseInt(ctx.pathParam("rid"))));
				});
		//update Reimburstment
		server.put("api/reimburstments/update/{rid}", (ctx) -> {
			ReimburstPojo returnReimburstPojo = reimburstService.updateReimburst(ctx.bodyAsClass(ReimburstPojo.class));
			ctx.json(returnReimburstPojo);
			});
		
		
		// to add reimburstments
		server.post("api/reimburstments", (ctx) -> {
			ReimburstPojo returnReimburstPojo = reimburstService.addReimburst(ctx.bodyAsClass(ReimburstPojo.class));
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
		
		//validate User
		server.post("api/employees", (ctx) -> {
			EmployeePojo returnEmployeePojo = employeeService.validateUser(ctx.bodyAsClass(EmployeePojo.class));
			ctx.json(returnEmployeePojo);
		});
		


}
}

