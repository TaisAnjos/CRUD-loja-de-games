package org.generation.loja_de_games.security;

import java.util.Optional;

import org.generation.loja_de_games.model.Usuario;
import org.generation.loja_de_games.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private  UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Usuario> usuario = userRepository.findByUsuario(userName);
		
		usuario.orElseThrow(()-> new UsernameNotFoundException(userName + "Usuario não encontrado"));
		
		//ATRIBUI O RESULTADO ENCONTRADO PARA ALIMENTAR O USERDETAILS
		return usuario.map(UserDetailsImpl::new).get();
	}
}
