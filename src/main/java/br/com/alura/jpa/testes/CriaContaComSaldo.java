package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		 Conta conta = new Conta();
		 conta.setTitular("Marcia");
		 conta.setNumero(123456);
		 conta.setAgencia(654321);
		 conta.setSaldo(100.00);
		 
		 em.getTransaction().begin(); // iniciando a transação 
		 
		 em.persist(conta); // persistindo os dados 
		 
		 em.getTransaction().commit(); // autualizando os dados na tabela

		 em.close(); 
		 
		 
		 // conta após o fechamento do EntityManager passou a ser detached 
		 EntityManager em1 = emf.createEntityManager();
		 
		 
		 System.out.println("Id da conta da Márcia: " + conta.getId());
		 conta.setSaldo(500.00);
		 
		 em1.getTransaction().begin();
		 
		 em1.merge(conta); // conta passou a ser merge, faz um select primeiro depois o update no banco
		 
		 em1.getTransaction().commit();
	}

}
