package com.generation.GamesZinha.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.GamesZinha.Model.Categoria;
import com.generation.GamesZinha.Service.CategoriaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaService services;

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarTodos() {
		List<Categoria> listaCategoria = services.findAll();
		if (listaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaCategoria);
		}

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Categoria>> buscarId(@PathVariable long id) {
		List<Categoria> listaId = services.findById(id);
		if (listaId.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaId);
		}

	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> buscarTipo(@PathVariable String tipo) {
		List<Categoria> listaTipo = services.findByTipo(tipo);
		if (listaTipo.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaTipo);
		}
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@Valid @RequestBody Categoria novaCategoria) {
		Optional<Object> categoriaCadastrada = services.criarCategoria(novaCategoria);

		if (categoriaCadastrada.isEmpty()) {
			return ResponseEntity.status(200).body("Categoria já existente");
		} else {
			return ResponseEntity.status(201).body("Categoria  criada");

		}

	}

	@PutMapping
	public ResponseEntity<Object> atualizarCategoria(
			@Valid @PathVariable(value = "atualizar_categoria") Long atualizarCategoria,
			@Valid @RequestBody Categoria categoriaParaAtualizar) {
		return services.atualizarCategoria(atualizarCategoria, categoriaParaAtualizar)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.badRequest().build());
	}

}