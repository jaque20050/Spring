package com.LojaGames.Loja.Games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@NotBlank(message = "O campo não pode ser vazio")
	@Size(min = 3, max = 100, message = "O nome deve conter no minimo 3 caractere e no maximo 100")
	private String nome;

	@NotBlank(message = "O campo não pode ser vazio")
	@Size(min = 3, max = 6, message = "A senha deve conter no minimo 3 caractere e no maximo 6")
	private String senha;
	
	@Email
	private String userEmail;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}