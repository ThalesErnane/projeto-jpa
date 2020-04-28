package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

	public static void main(String[] args) {
	Conta conta = new Conta();
	conta.setId(1L);
	
	Cliente cliente = new Cliente();
	cliente.setNome("Suzzi");
	cliente.setEndereco("Rua Condor, 145");
	cliente.setProfissao("Professora");
	cliente.setConta(conta);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	

	em.persist(cliente);
	
	em.getTransaction().commit();
	em.close();

	}

}
