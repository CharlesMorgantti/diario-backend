package com.example.curso.senac.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.curso.senac.service.SessaoService;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Builder
@Data
//@DynamicUpdate


//@Table(name= "SESSAO")
public class Sessao implements Serializable{
	
	@Override
	public String toString() {
		return "Sessao [id=" + id + ", dataInicial=" + dataInicial + ", observacoes=" + observacoes + ", exercicio="
				+ exercicio + "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(iso= ISO.DATE)
	@Column(columnDefinition="DATE")
	private LocalDate dataInicial;
	@DateTimeFormat(iso= ISO.DATE)
	@Column(columnDefinition="DATE")
//	private LocalDate dataFinal;
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}



	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}


	@Column(length = 500)
	private String observacoes;
	@OneToMany(mappedBy= "sessao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List <Exercicio> exercicio = new ArrayList<>();
	
	public Sessao() {
		
	}
	
	public Sessao(Integer id, LocalDate dataInicial, String observacoes) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.observacoes = observacoes;
		
	}
	public Sessao(Integer id, LocalDate dataInicial, 
			List<Exercicio> exercicios,String observacoes) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.exercicio = exercicios;
		this.observacoes = observacoes;
		
	}



	public Integer getId() {
		return id;
	}
	public Integer setId(Integer id) {
		return this.id = id;
	}
	
	
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public List<Exercicio> getExercicio() {
		return exercicio;
	}
	public void setExercicio(List<Exercicio> exercicio) {
		this.exercicio = exercicio;
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
		Sessao other = (Sessao) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public Sessao map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}



	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

/*cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}*/


}
