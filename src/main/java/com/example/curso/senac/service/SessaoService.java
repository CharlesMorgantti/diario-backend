package com.example.curso.senac.service;
import com.example.curso.senac.repository.SessaoDao;
import com.example.curso.senac.repository.SessaoRepository;

import exception.CustomException;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.curso.senac.model.Sessao;
import com.example.curso.senac.repository.SessaoRepository;

@Transactional
@Service
public class SessaoService {
	@Autowired
	private SessaoRepository sessaoRepository;
	@Autowired 
	private SessaoDao sessaoDao; 
	@PersistenceContext
	private EntityManager entityManager;
	
	public Sessao buscar(Integer id) {
		Optional <Sessao> sessao = sessaoRepository.findById(id);
		return sessao.orElse(null);
	}
	public Optional<Sessao> buscarPorId(int id) {
		return sessaoRepository.findById(id);
	}

	public List<Sessao> buscarPorData(LocalDate inicial) {
		String jpql= new StringBuilder("select s from Sessao s ").append(
				"where s.dataInicial = ?1 ").toString();
		return sessaoDao.criarQuery(jpql, inicial);
	}
	
	public List<Sessao> buscarPorPeriodo(LocalDate inicial, LocalDate dataFinal) {
		String jpql= new StringBuilder("select s from Sessao s ").append(
				"where s.dataInicial >= ?1 and s.dataInicial <= ?2").toString();
		return sessaoDao.criarQuery(jpql, inicial, dataFinal);
	}
	
	@Modifying
	public void update(Sessao sessao) {
		entityManager.merge(sessao);
		
	}

//	@Override
	@Transactional
	public Sessao salvar(Sessao s) {
		try {
		if( s.getId() == null) {
			return sessaoRepository.save(s);	 
		} else {
			throw new CustomException ( "Registro já existe");
		}
		}catch(CustomException e) {
			throw new CustomException ( "Falha no sistema!", e.getMessage()); 		
			}
	}
//	@Override
	@Transactional
	public Sessao atualizar(Sessao s) {
		Objects.requireNonNull(s.getId());
		try {
		return sessaoRepository.save(s);
		}catch(CustomException e) {
			throw new CustomException ( "Falha no sistema!", e.getMessage()); 		
			}
	}
}
