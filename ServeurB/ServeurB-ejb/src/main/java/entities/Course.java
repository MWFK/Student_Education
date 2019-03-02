package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	//1er relation
	@ManyToMany
	private List<User> etudiant; 
	
	//2eme relation
	@ManyToOne(cascade={CascadeType.PERSIST})//cascasde qst2  (we put cascade in the master(cuz the role of the cascade is to save the master on its slaves))
	private User enseingants;
	
	public List<User> getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(List<User> etudiant) {
		this.etudiant = etudiant;
	}
	public User getEnseingants() {
		return enseingants;
	}
	public void setEnseingants(User enseingants) {
		this.enseingants = enseingants;
	}

	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}   
	public Course(String name2) {
		// TODO Auto-generated constructor stub
		this.name=name2;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
