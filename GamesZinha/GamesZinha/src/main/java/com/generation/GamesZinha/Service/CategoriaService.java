package com.generation.GamesZinha.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.generation.GamesZinha.Model.Categoria;

@Service
public class CategoriaService {

	public Optional<Object> criarCategoria(@Valid Categoria novaCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> atualizarCategoria(@Valid Long atualizarCategoria,
			@Valid Categoria categoriaParaAtualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> deletarCategoria(Long categoriaDeletar, @Valid Categoria categoriaParaDeletar) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categoria> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Categoria> findByTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
