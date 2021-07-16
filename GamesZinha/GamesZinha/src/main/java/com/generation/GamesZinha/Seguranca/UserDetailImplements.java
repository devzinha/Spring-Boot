package com.generation.GamesZinha.Seguranca;

import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.GamesZinha.Model.Usuario;

public class UserDetailImplements implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String senha;
	private List<GrantedAuthority> autoridades;

	public UserDetailImplements(Usuario usuario) {
		super();
		this.usuario = usuario.getUsuario();
		this.senha = usuario.getSenha();
	}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return autoridades;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return senha;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return usuario;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

	
}
