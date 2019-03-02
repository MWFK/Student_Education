package main2;

import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.annotations.common.util.impl.Log;

import entities.Course;
import entities.User;
import entities.UserType;
import services.ServiceRemote;

public class Main {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		
		String jndiName="ServeurB-ear/ServeurB-ejb/Service!services.ServiceRemote";
		Context context = new InitialContext();
		ServiceRemote proxy = (ServiceRemote) context.lookup(jndiName);
	
		//lajout de cours et enseignant va se faire d'une maniere simultane
		//cours va recevoir enseignant
		
		Course C = new Course();
		C.setName("math");
		
		User  U = new User();
		U.setUserType(UserType.teacher);
		U.setName("Salma");
		U.setPassword("mk");
		U.setLogin("mk");
		
		proxy.ajouterCoursEtEnseignant(C,U);
		System.out.println("Succes ajout enseignant cours\n");

	}

}
