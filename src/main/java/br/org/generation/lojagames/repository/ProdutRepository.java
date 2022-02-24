package br.org.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.gengames.model.Produt;

public interface ProdutRepository extends JpaRepository<Produt, Long>{
	
	 	
		public List<Produt> findAllByNomeContainingIgnoreCase(String nome);

		
		/* V2 --- INCREMENTO APÓS LIVE CODE
		 
		 
	 *  Método Personalizado - Buscar todos os Produtos cujo o preço seja maior 
	 *  do que um valor digitado ordenado pelo preço em ordem crescente
	 *  
	 *  MySQL: select * from tb_produtos where preco > preco order by preco;
	 
	 
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	
	/**
	 *  Método Personalizado - Buscar todos os Produtos cujo o preço seja menor 
	 *  do que um valor digitado ordenado pelo preço em ordem decrescente
	 *  
	 *  MySQL: select * from tb_produtos where preco < preco order by preco desc;
	 
	 
	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);/*
	*/
}
