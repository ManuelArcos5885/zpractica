package controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Valoracionmateria;

public class ControladorNota {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	
	
	
	
	public static List<Valoracionmateria> findAll () {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria", Valoracionmateria.class);
		
		List<Valoracionmateria> resultado = (List<Valoracionmateria>) q.getResultList();
		em.close();
		return resultado;
	}
	
	/**
	 * 
	 * actualizar
	 * 
	 */
	public static void merge(Valoracionmateria v) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * elije entre actualizar o insertar
	 */
	
	public static void save(Valoracionmateria e) {
		EntityManager em = entityManagerFactory.createEntityManager();
		if (e.getId() != 0) {
			merge(e);
		}
		else {
			persist(e);
		}
	}
	
	/**
	 * 
	 * 
	 */
	
	/**
	 * insertar
	 */
	public static void persist(Valoracionmateria e) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 */
	public static void remove(Valoracionmateria e) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Valoracionmateria actual = null;
		em.getTransaction().begin();
		if (!em.contains(e)) {
			actual = em.merge(e);
		}
		em.remove(actual);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	
	
	
	
}
