package services;

import java.util.List;

import javax.ejb.Local;

import entities.Course;
import entities.User;

@Local
public interface ServiceLocal {

	
	void ajouterUser(User user);
	void  ajouterCoursEtEnseignant(Course  course,  User  teacher);
	List<Course> listerCours(User techer);
	User getEmployeByEmailAndPassword(String login, String password);
}
