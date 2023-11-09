package session;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class FiliereService implements IDao<Filiere>, IDaoLocal<Filiere>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public boolean create(Filiere o) {
		em.persist(o);
		return true;
	}

	@Override
	public boolean update(Filiere o) {
		em.merge(o);
		em.flush();
		return true;
	}

	@Override
	public boolean delete(Filiere o) {
		em.remove(o);
		return true;
	}

	@Override
	public Filiere findById(int id) {
		return em.find(Filiere.class, id);
	}

	@Override
	public List<Filiere> findAll() {
		jakarta.persistence.Query query = em.createQuery("select e from Filiere f");
		return query.getResultList();
	}
}
