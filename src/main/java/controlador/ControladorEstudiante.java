package controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;




public class ControladorEstudiante {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");
	
	
	
	
	public static List<Estudiante> findAll () {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
		
		List<Estudiante> resultado = (List<Estudiante>) q.getResultList();
		em.close();
		return resultado;
	}
	
	
	
}
