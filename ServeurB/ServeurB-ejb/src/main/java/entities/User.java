package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String login;
	private String password;
	private Integer age;
	private Date birthDate;
	@Enumerated(EnumType.STRING)
	private UserType userType;

	//1er relation
	@ManyToMany(mappedBy="etudiant")
	private List<Course> courses;

	//2eme relation
	@OneToMany(mappedBy="enseingants",fetch=(FetchType.EAGER)) //eager qst3 if we don't add it the error will be
		//failed to lazily initialize a collection of role: entities.User.cours_Ens, could not initialize proxy - no Session
	private List<Course> cours_Ens; 
	
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Course> getCours_Ens() {
		return cours_Ens;
	}
	public void setCours_Ens(List<Course> cours_Ens) {
		this.cours_Ens = cours_Ens;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public User(String login2, String password2, String name2) {
		// TODO Auto-generated constructor stub
		this.login=login2;
		this.password=password2;
		this.name=name2;
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}   
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
   
}
