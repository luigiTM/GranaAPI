package com.lughtech.grana.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	private String nome;
	@ManyToOne
	@JoinColumn(name = "usuario_criacao")
	private Usuario usuarioCriacao;
	private String email;

	@ManyToMany(mappedBy = "pessoas")
	private List<Gasto> gastos = new ArrayList<Gasto>();

	public Pessoa() {
	}

	public Pessoa(String nome, Usuario usuarioCriacao, String email) {
		this.nome = nome;
		this.usuarioCriacao = usuarioCriacao;
		this.email = email;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getusuarioCriacao() {
		return usuarioCriacao;
	}

	public void setusuarioCriacao(Usuario usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarioCriacao == null) ? 0 : usuarioCriacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (usuarioCriacao == null) {
			if (other.usuarioCriacao != null)
				return false;
		} else if (!usuarioCriacao.equals(other.usuarioCriacao))
			return false;
		return true;
	}

}
