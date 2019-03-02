package services;

import java.util.List;

import javax.ejb.Remote;

import entities.Course;
import entities.User;

@Remote
public interface ServiceRemote {

	
	void ajouterUser(User user);
	void  ajouterCoursEtEnseignant(Course  course,  User  teacher);
	List<Course> listerCours(User techer);
	User getEmployeByEmailAndPassword(String login, String password);
}
