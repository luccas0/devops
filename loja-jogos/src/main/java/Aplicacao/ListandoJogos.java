package Aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dominio.Jogo;

import java.util.List;

public class ListandoJogos {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jogos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
Query query = em.createQuery("select r from Receita R");
		
		List<Jogo> jogos = query.getResultList();
		for (Jogo jogo : jogos) {
			System.out.println(jogo.getCodigo() + " - "
					+ jogo.getNome() + " "
					+ jogo.getGenero() + " "
					+ jogo.getDataLancamento() + " "
					+ "R$"+ jogo.getPreco());
			
			em.getTransaction().commit();
			
			System.out.println("pronto!");
			em.close();
			emf.close();
		}
	
	

	

	}
	
}


