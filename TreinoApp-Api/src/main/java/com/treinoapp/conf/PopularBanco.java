package com.treinoapp.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.treinoapp.model.Aluno;
import com.treinoapp.model.Professor;
import com.treinoapp.services.interfaces.AlunoService;
import com.treinoapp.services.interfaces.ProfessorService;

@Component
public class PopularBanco {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

	@EventListener({ ContextStartedEvent.class, ContextRefreshedEvent.class })
	public void popularBanco() {

		if (alunoService.buscarPorId(1l) == null) {
			logger.info("Populando banco de dados.....");
			cadastrarAlunos();
			cadastrarProfessores();
		} else {
			logger.info("Banco de dados já populado.....");
		}

	}

	private void cadastrarProfessores() {

		Professor a1 = new Professor();
		a1.setEmail("professor1@email.com.br");
		a1.setSenha("123");
		a1.setNome("Antonio Calors");
		a1.setIdade(35);
		professorService.adicionar(a1);

		Professor a2 = new Professor();
		a2.setEmail("professor2@email.com.br");
		a2.setSenha("123");
		a2.setNome("Alexandre Marombeiro");
		a2.setIdade(24);
		professorService.adicionar(a2);

		Professor a3 = new Professor();
		a3.setEmail("professor3@email.com.br");
		a3.setSenha("123");
		a3.setNome("Jay Cutler da silva");
		a3.setIdade(21);
		professorService.adicionar(a3);
		
		Professor a4 = new Professor();
		a4.setEmail("prof");
		a4.setSenha("prof");
		a4.setNome("Jay Cutler da silva");
		a4.setIdade(21);
		professorService.adicionar(a4);

	}

	private void cadastrarAlunos() {
		Aluno a1 = new Aluno();
		a1.setEmail("temer@email.com.br");
		a1.setSenha("123");
		a1.setNome("Michel Temer");
		a1.setIdade(78);
		alunoService.adicionar(a1);

		Aluno a2 = new Aluno();
		a2.setEmail("dilma@gmail.com.br");
		a2.setSenha("123");
		a2.setNome("Dilma Roussef");
		a2.setIdade(56);
		alunoService.adicionar(a2);

		Aluno a3 = new Aluno();
		a3.setEmail("aecioneves@gmail.com.br");
		a3.setSenha("123");
		a3.setNome("Aécio Neves PSDB");
		a3.setIdade(45);
		alunoService.adicionar(a3);

		Aluno a4 = new Aluno();
		a4.setEmail("marinasilva@gmail.com.br");
		a4.setSenha("123");
		a4.setNome("Marina Silva PV");
		a4.setIdade(74);
		alunoService.adicionar(a4);

		Aluno a5 = new Aluno();
		a5.setEmail("test");
		a5.setSenha("test");
		a5.setNome("Aluno test");
		a5.setIdade(21);
		alunoService.adicionar(a5);

		Aluno a6 = new Aluno();
		a6.setEmail("test1");
		a6.setSenha("test");
		a6.setNome("Henrique Eduardo Alves");
		a6.setIdade(21);
		alunoService.adicionar(a6);

		Aluno a7 = new Aluno();
		a7.setEmail("test2");
		a7.setSenha("test");
		a7.setNome("Fernando Henrique Cardozo");
		a7.setIdade(21);
		alunoService.adicionar(a7);

		Aluno a8 = new Aluno();
		a8.setEmail("test3");
		a8.setSenha("test");
		a8.setNome("Henrique Gonçalves Barreto");
		a8.setIdade(36);
		alunoService.adicionar(a8);

		Aluno a9 = new Aluno();
		a9.setEmail("test4");
		a9.setSenha("test");
		a9.setNome("Henrique Santos Silva");
		a9.setIdade(36);
		alunoService.adicionar(a9);

	}
}
