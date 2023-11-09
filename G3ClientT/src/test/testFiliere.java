package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Filiere;

public class testFiliere {
	public static IDao<Filiere> lookUpFiliereRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Filiere>) context.lookup("ejb:/Serveur/FiliereService!dao.IDao");

	}

	public static void main(String[] args) {
		
		try {
			IDao<Filiere> dao = lookUpFiliereRemote();
			dao.create(new Filiere("10", "maths"));
			dao.create(new Filiere("11", "physique"));
			//dao.delete(dao.findById(1));
			
			for(Filiere f : dao.findAll())
				System.out.println(f);
		} catch (NamingException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
		
	}


}
