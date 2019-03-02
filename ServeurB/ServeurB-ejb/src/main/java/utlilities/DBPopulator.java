/*package utlilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import serveur.ServiceLocal;
import serveur.Labo;
import serveur.Personne;

//@Singleton
//@Startup
public class DBPopulator {
	
					DbPopulator
	When you need to test database applications it is convenient to test them with different values in the database records.
	This class can be used to populate a MySQL database with random data.
	It can scan the list of tables and fields of a MySQL database and generate SQL INSERT statements that will fill the tables with records with random data.
	The class tries to populate each record field with values that seem appropriate based on the field name.
	Then it can either execute the generated SQL statements or save them to a file.
	
	
	//dependencies injection
	@EJB
	ServiceLocal ServiceLocal;
	
	@PostConstruct
	public void init(){
		
	Personne personne = new Personne("MK", "a", "a");
	ServiceLocal.ajoutPersonne(personne);
	
	Labo l=new Labo("PHD");
	ServiceLocal.ajoutLab(l);

	}

}*/