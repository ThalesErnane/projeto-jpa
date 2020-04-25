package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		// Transient quando uma class não tem vínculo nenhum com a JPA
		Conta conta = new Conta();
		conta.setTitular("Antonio");
		conta.setAgencia(123);
		conta.setNumero(321);
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
			
		em.getTransaction().begin();
		em.persist(conta); // transforma um obj de transient em manager, faz a sincronização com o Banco 

		// Managed >>>> Removed 
		em.remove(conta);
		
		em.getTransaction().commit();
		
	}

}
