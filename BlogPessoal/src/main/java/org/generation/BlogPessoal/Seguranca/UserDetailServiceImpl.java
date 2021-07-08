package org.generation.BlogPessoal.Seguranca;

import java.util.Optional;

import org.generation.BlogPessoal.Model.Usuario;
import org.generation.BlogPessoal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private @Autowired UsuarioRepository repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = repositorio.findByUsuario(username);
		
		if (usuario.isPresent()) {
			return new UserDetailImplements(usuario.get());
		} else {
			throw new UsernameNotFoundException(username + " not found.");
		}
	}

}