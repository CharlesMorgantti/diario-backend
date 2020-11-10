package com.example.curso.senac.web.controller;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.curso.senac.model.Exercicio;
import com.example.curso.senac.model.Sessao;
import com.example.curso.senac.repository.ExercicioRepository;
import com.example.curso.senac.repository.SessaoRepository;
import com.example.curso.senac.service.ExercicioService;
import com.example.curso.senac.service.SessaoService;

import exception.CustomException;

@ComponentScan(value="com.example.curso.senac.service" )

@RestController
public class HomeController {
	@Autowired
	private SessaoService sessaoService;

	@Autowired
	private ExercicioService exercicioService;
	@Autowired
	private SessaoRepository sessaoRepository;
	@Autowired
	private ExercicioRepository exercicioRepository;
	@PersistenceContext
	private EntityManager entityManager;
	

	@GetMapping("/")
	public String home() {
		return "index";
	}
	


	@RequestMapping
	public ResponseEntity  sessoes() {
		List<Sessao>sessoes= sessaoRepository.findAll();
		return ResponseEntity.ok(sessoes);
	}
	

	@RequestMapping("/deletar/{id}")
	public String excluir(@PathVariable("id")Integer id, RedirectAttributes red) {
		Sessao session = new Sessao();
		session = sessaoService.buscar(id);
		sessaoRepository.delete(session);
		red.addFlashAttribute("success", "Sessão excluída com sucesso!");
		return "redirect:/sessoes"; 
	}
	
	@GetMapping("/buscar/{dataInicial}")
	public ResponseEntity obterPorData(@PathVariable ("dataInicial")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate inicial) {
		List<Sessao>sessoes = sessaoService.buscarPorData(inicial);
		return ResponseEntity.ok(sessoes);
	}
	

	@PostMapping
	@Transactional
	public ResponseEntity salvar1(@RequestBody Sessao ses) {
		Sessao session = new Sessao();
		session = sessaoService.salvar(ses);
		return ResponseEntity.ok(session);	
	}

	@PostMapping("/atualizar/{id}")
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ResponseEntity atualizar1(@PathVariable("id") Integer id, @RequestBody Sessao ses) {
		return sessaoService.buscarPorId(id).map(sessao -> {
				sessaoService.atualizar(ses);
				return ResponseEntity.ok(ses);

	}).orElseGet(() -> new ResponseEntity(HttpStatus.BAD_REQUEST));
	}

	@GetMapping("/edit/{id}")
	public ResponseEntity obterSessao(@PathVariable("id") Integer id) {
		return sessaoService.buscarPorId(id).map(sessao -> new ResponseEntity(sessao, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));

	}
	
	
}
