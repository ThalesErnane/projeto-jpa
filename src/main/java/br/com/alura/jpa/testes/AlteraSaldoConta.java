package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoThales = em.find(Conta.class, 1L);
		
		// iniciando uma transação 
		em.getTransaction().begin();
		
		contaDoThales.setSaldo(20.0);
		
		System.out.println("Titular da Conta: " + contaDoThales.getTitular());
		
		em.getTransaction().commit();
		
		emf.close();
		em.close();
		
	}

}
