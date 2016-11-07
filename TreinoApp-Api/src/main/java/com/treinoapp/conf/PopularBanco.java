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
import com.treinoapp.usuario.model.Sexo;
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
		}
	}

	private void cadastrarProfessores() {

		UsuarioDto a1 = new UsuarioDto();
		a1.setEmail("professor1@gmail.com");
		a1.setSenha("123456");
		a1.setNome("Antonio Calors");
		a1.setIdade(35);
		a1.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Professor(a1));

		UsuarioDto a2 = new UsuarioDto();
		a2.setEmail("professor2@gmail.com");
		a2.setSenha("123");
		a2.setNome("Alexandre Marombeiro");
		a2.setIdade(24);
		a2.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Professor(a2));

		UsuarioDto a3 = new UsuarioDto();
		a3.setEmail("professor3@gmail.com");
		a3.setSenha("123");
		a3.setNome("Jay Cutler da silva");
		a3.setIdade(21);
		a3.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Professor(a3));

		UsuarioDto a4 = new UsuarioDto();
		a4.setEmail("professor4@gmail.com");
		a4.setSenha("123456");
		a4.setNome("Jay Cutler da silva");
		a4.setIdade(21);
		a4.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Professor(a4));

	}

	private void cadastrarAlunos() {

		UsuarioDto a1 = new UsuarioDto();
		a1.setEmail("temer@email.com.br");
		a1.setSenha("123456");
		a1.setNome("Michel Temer");
		a1.setIdade(78);
		a1.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Aluno(a1));

		UsuarioDto a2 = new UsuarioDto();
		a2.setEmail("dilma@gmail.com.br");
		a2.setSenha("123456");
		a2.setNome("Dilma Roussef");
		a2.setIdade(56);
		a2.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Aluno(a2));

		UsuarioDto a3 = new UsuarioDto();
		a3.setEmail("aecioneves@gmail.com.br");
		a3.setSenha("123456");
		a3.setNome("Aécio Neves PSDB");
		a3.setIdade(45);
		a3.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Aluno(a3));

		UsuarioDto a4 = new UsuarioDto();
		a4.setEmail("marinasilva@gmail.com.br");
		a4.setSenha("123456");
		a4.setNome("Marina Silva PV");
		a4.setIdade(74);
		a4.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Aluno(a4));

		UsuarioDto a5 = new UsuarioDto();
		a5.setEmail("aluno@gmail.com");
		a5.setSenha("123456");
		a5.setNome("Henrique Goncalves Barreto");
		a5.setIdade(24);
		a5.setSexo(Sexo.MASCULINO);
		usuarioService.salvar(new Aluno(a5));

	}
}
