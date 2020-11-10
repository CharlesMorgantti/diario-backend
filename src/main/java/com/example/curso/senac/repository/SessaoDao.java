package com.example.curso.senac.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.curso.senac.model.Sessao;
@Transactional
@Service
public class SessaoDao {
	
	@PersistenceContext
	private 	EntityManager entityManager;
	
	public List<Sessao> criarQuery(String jpql , Object...  params){
		TypedQuery<Sessao> query= entityManager.createQuery(jpql, Sessao.class);
				for(int i=0; i<params.length; i++) {
					query.setParameter(i+1, params[i]);
				}
		return query.getResultList();
	}
}
