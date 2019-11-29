package com.db1.db1start.cidadesapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome", length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado uf;

	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
	private List<Agencia> agencias;

	public Cidade(String nome, Estado uf) {
		this.nome = nome;
		this.uf = uf;
		this.agencias = new ArrayList<>();
	}

	public Cidade() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getUf() {
		return uf;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}
}
