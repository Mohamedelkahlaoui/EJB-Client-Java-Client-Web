package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Student;


public class testEtudiant {
	public static IDao<Student> lookUpStudentRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Student>) context.lookup("ejb:/Serveur/EtudiantService!dao.IDao");

	}

	public static void main(String[] args) {
		
		try {
			IDao<Student> dao = lookUpStudentRemote();
			dao.create(new Student("rami", "hamid","0655555555"));
			dao.create(new Student("safi", "imane", "0655445666"));
			//dao.delete(dao.findById(1));
			
			for(Student s : dao.findAll())
				System.out.println(s);
		} catch (NamingException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
		
	}

}
