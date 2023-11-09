package session;

import java.util.List;

import dao.IDao;
import dao.IDaoLocal;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class EtudiantService implements IDao<Student>, IDaoLocal<Student>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public boolean create(Student o) {
		em.persist(o);
		return true;
	}

	@Override
	public boolean update(Student o) {
		em.merge(o);
		em.flush();
		return true;
	}

	@Override
	public boolean delete(Student o) {
		em.remove(o);
		return true;
	}

	@Override
	public Student findById(int id) {
		return em.find(Student.class, id);
	}

	@Override
	@PermitAll
	public List<Student> findAll() {
		jakarta.persistence.Query query = em.createQuery("select e from Student st");
		return query.getResultList();
	}

}
