package main3;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import entities.User;
import services.ServiceRemote;

public class Main3 {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub

		String jndiName="ServeurB-ear/ServeurB-ejb/Service!services.ServiceRemote";
		Context context = new InitialContext();
		ServiceRemote proxy = (ServiceRemote) context.lookup(jndiName);
		
		User user = new User();
		user.setId(5);
		
		for(Course course : proxy.listerCours(user))
		{
			System.out.println(course.getName());
		}
	}

}
