package org.generation.loja_de_games.repository;

import java.util.List;

import org.generation.loja_de_games.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{
	public List <Produto> findAllByDesenvolvedoraContainingIgnoreCase (String desenvolvedora);
	
	public List <Produto> findAllByNomeContainingIgnoreCase (String nome);
	
	public List <Produto> findAllByPreco (Double preco);
}
