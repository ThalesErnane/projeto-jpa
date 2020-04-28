package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		

		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria"; // ordenando 
		
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		EntityManager em = emf.createEntityManager();
		
		// Query query = em.createQuery(jpql);
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class); // utilizando query mais especifica
		query.setParameter("pCategoria", categoria); // passando paramentros para a query 
	
		
		
		List<Movimentacao> resultList = query.getResultList(); // Lista de Moviemntação 
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descrição" + movimentacao.getDescricao());
			System.out.println("Categorias" + movimentacao.getCategorias());
			System.out.println("Descrição" + movimentacao.getValor());
			System.out.println("Tipo" + movimentacao.getTipoMovimentacao());
		}

	}

}
