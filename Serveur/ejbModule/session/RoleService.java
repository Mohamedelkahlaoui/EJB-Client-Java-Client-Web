package session;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class RoleService implements IDao<Role>, IDaoLocal<Role>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public boolean create(Role o) {
		em.persist(o);
		return true;
	}

	@Override
	public boolean update(Role o) {
		em.merge(o);
		em.flush();
		return true;
	}

	@Override
	public boolean delete(Role o) {
		em.remove(o);
		return true;
	}

	@Override
	public Role findById(int id) {
		return em.find(Role.class, id);
	}

	@Override
	@PermitAll
	public List<Role> findAll() {
		jakarta.persistence.Query query = em.createQuery("select e from Role r");
		return query.getResultList();
	}

}
