package org.generation.FarmaciaDrogazinha.Controller;


import java.util.List;

import javax.validation.Valid;

import org.generation.BlogPessoal.Model.Postagem;
import org.generation.FarmaciaDrogazinha.Model.Categoria;
import org.generation.FarmaciaDrogazinha.Repositorio.CategoriaRepository;
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
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable Long id) {
		return ResponseEntity.status(200).body(repository.findById(id).get());
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> GetByTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(org.generation.FarmaciaDrogazinha.Repository.CategoriaRepository.findAllByTipoContainingIgnoreCase(tipo));
		
	}
	
	@PostMapping
	public ResponseEntity<Object> post(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Object> put(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	}

	




