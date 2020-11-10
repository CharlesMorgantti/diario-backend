package com.example.curso.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.curso.senac.model.Exercicio;




@Repository
public interface ExercicioRepository extends JpaRepository <Exercicio, Integer> {

}
