package controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;




public class ControladorMateria {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	
	
	
	
	public static List<Materia> findAll () {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		
		List<Materia> resultado = (List<Materia>) q.getResultList();
		em.close();
		return resultado;
	}
	
	
	
}
