package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		String jdbcSQL = "select * from movimentacao where conta_id = 1";
		
		// String jpql = "select m from Movimentacao m where m.conta.id = 2"; // Utilizando JPQL 
		String jpql = "select m from Movimentacao m where m.conta = :pConta"; // Utilizando JPQL query Orientado a Obj
		
		String jpqlOrderBy = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc"; // ordenando 
		
		Conta conta = new Conta();
		conta.setId(2L);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		// Query query = em.createQuery(jpql);
		TypedQuery<Movimentacao> query = em.createQuery(jpqlOrderBy, Movimentacao.class); // utilizando query mais especifica
		query.setParameter("pConta", conta); // passando paramentros para a query 
	
		
		
		List<Movimentacao> resultList = query.getResultList(); // Lista de Moviemntação 
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição" + movimentacao.getDescricao());
			System.out.println("Tipo" + movimentacao.getTipoMovimentacao());
		}
		
		
		
		
	}

}
