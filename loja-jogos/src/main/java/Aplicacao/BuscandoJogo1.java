package Aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dominio.Jogo;

public class BuscandoJogo1 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jogos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Jogo jogo = em.find(Jogo .class, 1L);
		System.out.println("Jogo de código " + jogo.getCodigo() 
		+ "jogo:" + jogo.getNome());
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
		
	}

}
