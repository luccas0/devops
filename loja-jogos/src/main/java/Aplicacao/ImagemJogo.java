package Aplicacao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Dominio.GeneroJogo;
import Dominio.Jogo;
import oracle.sql.DATE;

import java.nio.file.Path;
import java.time.LocalDate;

import Dominio.Jogo;

public class ImagemJogo {
	
	public static void main(String[] args) throws IOException {
			
			Path path = FileSystems.getDefault().getPath("imagem/generations.jpg");
			byte[] foto = Files.readAllBytes(path);
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja-jogos");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			Jogo jogo = new Jogo();
			jogo.setNome("Sonic Generations");
			jogo.setGenero(GeneroJogo.AVENTURA);
			jogo.setDataLancamento("01/11/2011");
			jogo.setPreco(new BigDecimal(162));
			jogo.setFoto(foto);
			em.persist(jogo);
			
			em.getTransaction().commit();
			
			em.detach(jogo);
			Jogo jogo2 = em.find(Jogo.class, jogo.getCodigo());
			if (jogo2.getFoto() != null) {
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(jogo2.getFoto()));
				JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
			} else {
				System.out.println("Jogo não possui foto.");
			}
			
			System.out.println("pronto!");
			em.close();
			emf.close();

		}


	}


