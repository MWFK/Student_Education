package webService;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entities.Course;
import entities.User;
import entities.UserType;
import services.Service;

@ManagedBean
@ViewScoped
public class AgentBean {
	private String nomCourse;
	private String login;
	private String name;
	private String password;
	private int age;

	
	
	
	User teacher;
	Course course;
	
	@EJB
	Service service;
	
	public void Ajouter() {
		
		teacher=new User(login,password,name);//les champs de formulaire (et jai un ajouter un constructeur au niveau  de User ejb)
		teacher.setUserType(UserType.teacher);
		if(teacher!=null)
		{
			FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("Teacher has been added"));	
		}
		
		
		course = new Course(nomCourse);
		service.ajouterCoursEtEnseignant(course, teacher);
	}
	
	
	
	
	
	
	
	

	public String getNomCourse() {
		return nomCourse;
	}

	public void setNomCourse(String nomCourse) {
		this.nomCourse = nomCourse;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
	
	
	
}
