package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Role;

public class testRole {
	public static IDao<Role> lookUpRoleRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Role>) context.lookup("ejb:/Serveur/RoleService!dao.IDao");

	}

	public static void main(String[] args) {
		
		try {
			IDao<Role> dao = lookUpRoleRemote();
			dao.create(new Role("aaaa"));
			dao.create(new Role("bbbb"));
			//dao.delete(dao.findById(1));
			
			for(Role r : dao.findAll())
				System.out.println(r);
		} catch (NamingException r) {
			// TODO Auto-generated catch block
			r.printStackTrace();
		}
		
	}

}
