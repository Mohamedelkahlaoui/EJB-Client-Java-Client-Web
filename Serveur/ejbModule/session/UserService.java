package session;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.User;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserService implements IDao<User>, IDaoLocal<User>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public boolean create(User o) {
		em.persist(o);
		return true;
	}

	@Override
	public boolean update(User o) {
		em.merge(o);
		em.flush();
		return true;
	}

	@Override
	public boolean delete(User o) {
		em.remove(o);
		return true;
	}

	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	@PermitAll
	public List<User> findAll() {
		jakarta.persistence.Query query = em.createQuery("select e from User u");
		return query.getResultList();
	}

}
