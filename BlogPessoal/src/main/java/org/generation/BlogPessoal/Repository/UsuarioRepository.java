package org.generation.BlogPessoal.Repository;

import java.util.Optional;

import org.generation.BlogPessoal.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);
	
	
}
