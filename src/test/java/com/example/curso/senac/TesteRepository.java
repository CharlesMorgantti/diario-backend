package com.example.curso.senac;

import org.junit.*;
import org.junit.runner.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.curso.senac.model.Sessao;
import com.example.curso.senac.repository.SessaoRepository;
import com.example.curso.senac.service.SessaoService;
import com.example.curso.senac.web.controller.HomeController;

import lombok.Builder;

@Builder
@SpringBootTest
@RunWith(SpringRunner.class)
public class TesteRepository {

	
	@Autowired
	SessaoRepository sessaoRepository;
	@Autowired
	SessaoService sessaoService;
	
	@Test
	public void testar() {
		Sessao s= new Sessao();
		s.setId(8);
		s.setObservacoes("testando erro");
		sessaoService.salvar(s);
	} 
	
	
}



