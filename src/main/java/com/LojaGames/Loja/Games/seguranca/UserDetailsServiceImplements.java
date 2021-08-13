package com.LojaGames.Loja.Games.seguranca;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.LojaGames.Loja.Games.model.Usuario;
import com.LojaGames.Loja.Games.repository.UsuarioRepository;

public class UserDetailsServiceImplements implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		Optional<Usuario>usuario = repositorio.findByUserEmail(username);
		
		if(usuario.isPresent()) {
			return new UserDetailsImplements(usuario.get());
		}else {
			throw new UsernameNotFoundException(username + "not found");
		}
	}
}
