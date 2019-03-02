package webService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.UserType;
import entities.User;
import services.Service;

@ManagedBean
@SessionScoped
public class LoginBean{

	private String login;
	private String password;
	private User user;
	private boolean loggedIn;
	
	@EJB
	Service service;
	
	public String doLogout()
	{	
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().addMessage("form:btl",new FacesMessage("you're logged out "+user.getName()));
		
		return "/pages/logOut";
	}
	
	
	
	public String doLogin()
	{
		String navigateTo = "null";
		
	    user = service.getEmployeByEmailAndPassword(login, password);
		
		if(user!=null)
			{
				if(user.getUserType() == UserType.teacher)
					{
						navigateTo="/pages/espaceTeacher";
						loggedIn=true;
						FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("Howdy "+user.getName()));
					}
				else if(user.getUserType() == UserType.student)
					{
						navigateTo="/pages/espaceStudent";
						loggedIn=true;
						FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("Howdy "+user.getName()));
					}
				else if(user.getUserType() == UserType.agent)
				{
					navigateTo="/pages/espaceAgent";
					loggedIn=true;
					FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("Howdy "+user.getName()));
				}
			}
		
		else
			{
				navigateTo="/pages/error";
				FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage("bad credentials"));
			}
			
		
		return navigateTo;
	}
	
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
		
}
