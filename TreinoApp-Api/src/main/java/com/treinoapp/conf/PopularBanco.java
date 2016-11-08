package com.treinoapp.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.treinoapp.infra.exceptions.MyEntityNotFoundException;
import com.treinoapp.usuario.dto.UsuarioDto;
import com.treinoapp.usuario.model.Aluno;
import com.treinoapp.usuario.model.Professor;
import com.treinoapp.usuario.model.Secretaria;
import com.treinoapp.usuario.service.interfaces.AlunoService;
import com.treinoapp.usuario.service.interfaces.UsuarioService;

@Component
public class PopularBanco {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AlunoService alunoService;

	@EventListener({ ContextStartedEvent.class, ContextRefreshedEvent.class })
	public void popularBanco() {

		try {
			alunoService.buscarPorId(1l);
			logger.info("Banco de dados já populado.....");
		} catch (MyEntityNotFoundException e) {
			logger.info("Populando banco de dados.....");
			cadastrarAlunos();
			cadastrarProfessores();
			cadastrarSecretaria();
		}
	}

	private void cadastrarSecretaria() {
		UsuarioDto a1 = new UsuarioDto();
		a1.setEmail("secretaria1@gmail.com");
		a1.setNome("Secretaria 1");
		a1.setSenha("123123");
		a1.setDataNascimento("04/12/1991");
		a1.setSexo("Masculino");
		a1.setTelefone("(61) 912323232");
		usuarioService.salvar(new Secretaria(a1));

	}

	private void cadastrarProfessores() {

		UsuarioDto a1 = new UsuarioDto();
		a1.setEmail("professor1@gmail.com");
		a1.setNome("Antonio Carlos");
		a1.setDataNascimento("04/10/1989");
		a1.setSexo("Masculino");
		a1.setSenha("123123");
		a1.setTelefone("(61) 912323232");
		usuarioService.salvar(new Professor(a1));

		UsuarioDto a2 = new UsuarioDto();
		a2.setEmail("professor2@gmail.com");
		a2.setNome("Alexandre Marombeiro");
		a2.setDataNascimento("04/12/1996");
		a2.setSexo("Masculino");
		a2.setSenha("123123");
		a2.setTelefone("(61) 912323232");
		usuarioService.salvar(new Professor(a2));

	}

	private void cadastrarAlunos() {

		UsuarioDto a1 = new UsuarioDto();
		a1.setEmail("temer@email.com.br");
		a1.setNome("Michel Temer");
		a1.setDataNascimento("04/12/1992");
		a1.setSexo("Masculino");
		a1.setSenha("123123");
		a1.setTelefone("(61) 912323232");
		usuarioService.salvar(new Aluno(a1));

		UsuarioDto a2 = new UsuarioDto();
		a2.setEmail("dilma@gmail.com.br");
		a2.setNome("Dilma Roussef");
		a2.setDataNascimento("04/12/1985");
		a2.setSexo("Masculino");
		a2.setSenha("123123");
		a2.setTelefone("(61) 912323232");
		usuarioService.salvar(new Aluno(a2));

	}
}
