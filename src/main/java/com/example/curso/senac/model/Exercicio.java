package com.example.curso.senac.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@DynamicUpdate
//@Table(name= "EXERCICIO")
public class Exercicio implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private float carga;
	@Column(length = 100)
	private String descricao;
	@Column
	private Integer repeticoes;
	@Column
	private Integer series;
	@ManyToOne
	@JoinColumn(name= "fk_id_sessao")
	@JsonBackReference
	private Sessao sessao;

	public Exercicio() {
		
	}
	
	public Exercicio(Integer id, float carga, String descricao, Integer repeticoes, Integer series, Sessao sessao) {
		super();
		this.id = id;
		this.sessao = sessao;
		this.descricao = descricao;
		this.carga = carga;
		this.repeticoes = repeticoes;
		this.series = series;
	}


	




	public Integer getId() {
		return id;
	}






	public void setId(Integer id) {
		this.id = id;
	}






	public Sessao getSessao() {
		return sessao;
	}






	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}






	public String getDescricao() {
		return descricao;
	}






	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}






	public float getCarga() {
		return carga;
	}






	public void setCarga(float carga) {
		this.carga = carga;
	}






	public Integer getRepeticoes() {
		return repeticoes;
	}






	public void setRepeticoes(Integer repeticoes) {
		this.repeticoes = repeticoes;
	}






	public Integer getSeries() {
		return series;
	}






	public void setSeries(Integer series) {
		this.series = series;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Exercicio other = (Exercicio) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
