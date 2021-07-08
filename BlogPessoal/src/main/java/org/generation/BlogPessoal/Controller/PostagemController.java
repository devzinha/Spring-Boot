package org.generation.BlogPessoal.Controller;

import java.util.List;

import org.generation.BlogPessoal.Model.Postagem;
import org.generation.BlogPessoal.Repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<org.generation.BlogPessoal.Repository.Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<org.generation.BlogPessoal.Repository.Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
				
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<org.generation.BlogPessoal.Repository.Postagem>> GetByTitulo(@PathVariable String postagem){
	   String titulo = null;
	return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	
	}
	
	@PostMapping
	public ResponseEntity<Object> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));	
	    }

	@PutMapping
	public ResponseEntity<Object> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}




