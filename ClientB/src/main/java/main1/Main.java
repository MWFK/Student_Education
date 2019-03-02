package main1;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import entities.UserType;
import services.ServiceRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub

		String jndiName="ServeurB-ear/ServeurB-ejb/Service!services.ServiceRemote";
		Context context = new InitialContext();
		ServiceRemote proxy = (ServiceRemote) context.lookup(jndiName);
		
		
		User  U = new User();
		U.setUserType(UserType.student);
		U.setName("MK");
		U.setAge(24);
		U.setLogin("mk");
		U.setPassword("mk");
		proxy.ajouterUser(U);
		System.out.println("Succes ajout student\n");
		
		
		
		
		
	}

}
