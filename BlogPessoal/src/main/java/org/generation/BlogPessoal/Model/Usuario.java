package org.generation.BlogPessoal.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private static Long id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nome;
	
	@NotNull
	@Size(min = 3, max = 12)
	private String usuario;
	
	@NotNull
	@Size(min = 6, max = 12)
	private String senha;

	public static Long getId() {
		return id;
	}

	public void setId(Long id) {
		Usuario.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	} 
	
	
	

}
