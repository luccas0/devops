package Aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dominio.Jogo;
import Dominio.JogoId;

public class BuscandoJogoPeloCriador {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jogos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		JogoId codigo = new JogoId("Yuji Naka", "SEGA");
		Jogo jogo = em.find(Jogo.class, codigo);
		System.out.println("Criador:" + jogo.getCodigo());
		System.out.println("Empresa:" + jogo.getCodigo());
		System.out.println("Nome:" + jogo.getNome());
		
		em.getTransaction().commit();
		
		System.out.println("pronto!");
		em.close();
		emf.close();

	}

}
