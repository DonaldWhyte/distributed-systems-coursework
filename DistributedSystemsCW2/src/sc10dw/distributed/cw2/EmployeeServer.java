package sc10dw.distributed.cw2;

import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.sql.Connection;
import java.util.List;

public class EmployeeServer {
	
	public static void main(String[] args) {
		try {
			EmployeeFactory employeeFactory = new EmployeeFactoryImpl();
			employeeFactory.createEmployee("Whyte");
			employeeFactory.createEmployee("Campbell");
			Registry registry = LocateRegistry.getRegistry();
			registry.rebind("employee_factory", employeeFactory);		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	

}
