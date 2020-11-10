package com.example.curso.senac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.senac.model.Exercicio;
import com.example.curso.senac.model.Sessao;
import com.example.curso.senac.repository.ExercicioRepository;
import com.example.curso.senac.repository.SessaoRepository;

@Service
public class ExercicioService {

	
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	public Exercicio buscar(Integer id) {
	
		Optional <Exercicio> exercicio = exercicioRepository.findById(id);
		return exercicio.orElse(null);
	}
	
}
