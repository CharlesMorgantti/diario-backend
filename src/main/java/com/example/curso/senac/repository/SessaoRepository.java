package com.example.curso.senac.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.curso.senac.model.Exercicio;
import com.example.curso.senac.model.Sessao;



@Repository
public interface SessaoRepository extends JpaRepository <Sessao, Integer> {

	

}
