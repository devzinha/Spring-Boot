package com.generation.GamesZinha.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.GamesZinha.Model.Produto;
import com.generation.GamesZinha.Service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoService services;

	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos() {
		List<Produto> listaProduto = services.findAll();
		if (listaProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaProduto);
		}

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Produto>> buscarId(@PathVariable long id) {
		List<Produto> listaId = services.findById(id);
		if (listaId.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaId);
		}

	}

	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<Produto>> buscarnomeProduto(@PathVariable String nomeProduto) {
		List<Produto> listaNomeProduto = services.findByDescricao(nomeProduto);
		if (listaNomeProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaNomeProduto);
		}
	}

	@PutMapping
	public ResponseEntity<Object> atualizarProduto(
			@Valid @PathVariable(value = "atualizar_produto") Long atualizarProduto,
			@Valid @RequestBody Produto produtoParaAtualizar) {
		return services.atualizarProduto(atualizarProduto, produtoParaAtualizar)
				.map(produtoAtualizado -> ResponseEntity.status(201).body(produtoAtualizado))
				.orElse(ResponseEntity.badRequest().build());
	}

	@DeleteMapping
	public ResponseEntity<Object> deletarProduto(@PathVariable(value = "produto_deletar") Long produtoDeletar,
			@Valid @RequestBody Produto produtoParaDeletar) {
		return services.deletarProduto(produtoDeletar, produtoParaDeletar)
				.map(produtoDeletado -> ResponseEntity.status(201).body(produtoDeletado))
				.orElse(ResponseEntity.badRequest().build());
	}

}