package services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Course;
import entities.User;

/**
 * Session Bean implementation class Service
 */
@Stateless
@LocalBean
public class Service implements ServiceRemote, ServiceLocal {

    /**
     * Default constructor. 
     */
    public Service() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;
    
    public void ajouterUser(User user)
    {
    	em.persist(user);
    }

    public void  ajouterCoursEtEnseignant(Course  course,  User  teacher)//avec cascade
    {
    	course.setEnseingants(teacher);
    	em.persist(course);
    }
    
    public List<Course> listerCours(User techer) 
    {
    	User U = em.find(User.class,techer.getId());
    	return U.getCours_Ens();//the teacher(user) can access the course list cause, they are linked through enseignant_id (cascade)
    							//and the user has its courses list in the var Cours_ens 
    }
    
    
    
    @Override
    public User getEmployeByEmailAndPassword(String login, String password)
    {
    	TypedQuery<User> query = em.createQuery("Select u from User u where u.login=:login and u.password=:password",User.class);
    	
    	query.setParameter("login",login);
    	query.setParameter("password",password);
    	
    	User u = null;
    	
    	try
    		{
    			u = query.getSingleResult();
    		}
    	catch (NoResultException e)
    		{
    			Logger.getAnonymousLogger().info("Aucun employe avec ce loggin: "+login);
    			System.out.println("Aucun employe trouve avec cette email");
    		}
    	
    	return u;
    }
    
    
    
}
