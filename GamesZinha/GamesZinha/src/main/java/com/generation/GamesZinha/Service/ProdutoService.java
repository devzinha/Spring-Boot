package com.generation.GamesZinha.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.generation.GamesZinha.Model.Produto;

@Service
public class ProdutoService {
	
	public Optional<Object> criarProduto(@Valid Produto novoProduto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Optional<Object> atualizarProduto(@Valid Long atualizarProduto, @Valid Produto produtoParaAtualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> deletarProduto(Long produtoDeletar, @Valid Produto produtoParaDeletar) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> findByDescricao(String descricao) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object save(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}



}
