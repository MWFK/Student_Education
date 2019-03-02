package webService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import entities.Course;
import entities.User;
import services.Service;
import services.ServiceLocal;

@ManagedBean
@ViewScoped //import javax.faces.bean.ViewScoped;
public class TeacherBean {

	@ManagedProperty(value="#{loginBean}")
	LoginBean loginBean;
	
	private List<Course> lc;
	
	@EJB
	ServiceLocal serviceLocal;
	
	@PostConstruct
	public void init() 
	{
		lc = serviceLocal.listerCours(loginBean.getUser());
	}
	
/*	public List<Course> EnsVoirCours()
	{
		lc=service.listerCours(loginBean.getUser());
		return lc;
	}*/

	public List<Course> getLc() {
		return lc;
	}

	public void setLc(List<Course> lc) {
		this.lc = lc;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
	
}
