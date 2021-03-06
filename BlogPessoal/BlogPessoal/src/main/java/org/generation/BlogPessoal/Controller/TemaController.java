package org.generation.BlogPessoal.Controller;

import java.util.List;

import org.generation.BlogPessoal.Repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController<Tema> {

	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<org.generation.BlogPessoal.Model.Tema>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id){
		return extracted(id);
	}

	private ResponseEntity<Tema> extracted(long id) {
		ResponseEntity<Tema> orElse = (ResponseEntity<Tema>) repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		return orElse;
	}
 
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<org.generation.BlogPessoal.Model.Tema>> getByName(@PathVariable String nome ){
		return ResponseEntity.ok(repository.FindAllByDescricaoContainingIgnoreCase(nome));
	}
	

	@PostMapping
	public <S> ResponseEntity<Tema> post (@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema){
		return ResponseEntity.ok().body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}

