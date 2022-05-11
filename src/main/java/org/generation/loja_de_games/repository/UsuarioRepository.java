package org.generation.loja_de_games.repository;

import java.util.Optional;

import org.generation.loja_de_games.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	public Optional<Usuario> findByUsuario(String usuario);
}
