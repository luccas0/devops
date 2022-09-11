package Aplicacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dominio.Jogo;

public class AtualizandoJogo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jogos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Jogo jogo = em.find(Jogo.class, 1L);
		
		System.out.println("Preço atual" + jogo.getPreco());
		jogo.setPreco(jogo.getPreco().add(new BigDecimal(90)));
		System.out.println("Novo preço:" + jogo.getPreco());
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();

	}

}
