package org.generation.BlogPessoal.Controller;

import java.util.Optional;

import org.generation.BlogPessoal.Model.UserLogin;
import org.generation.BlogPessoal.Model.Usuario;
import org.generation.BlogPessoal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/id/{id_Usuario}")
	public ResponseEntity<UserLogin> pegarUsuarioPorId(@PathVariable(value = "id_Usuario") Long idUsuario){
		return repository.findById(idUsuario)
				.map(usuarioExistente -> ResponseEntity.status(200).body(usuarioExistente))
				.orElse(ResponseEntity.status(204).build());
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
	}

}
