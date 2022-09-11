package Aplicacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dominio.GeneroJogo;
import Dominio.Jogo;
import Dominio.JogoId;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jogos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Jogo jogo = new Jogo();
		jogo.setNome("Super Smash Bros Ultimate");
		jogo.setDataLancamento("07/12/2018");
		jogo.setPreco(new BigDecimal(349));
		em.persist(jogo);
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();
		
		


	}

}
