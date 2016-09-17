(function() {


	angular.module('app.professor')
	.controller('BuscaAlunoController', function($http, AlunoService){

		this.nome = '';

		this.alunos = [];

		this.buscarAluno = function() {

			AlunoService.buscarPorNome(this.nome)
			.success(function (data){
				console.log(data);
				alert('Pronto');
			});

		};

	});

})();