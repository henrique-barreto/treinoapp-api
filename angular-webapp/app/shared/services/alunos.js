(function() {

	angular.module('app')
	.service('AlunoService', function ($http) {
		
		var alunosResourceUrl = 'http://localhost:8080/treinoapp/api/v1/usuario'

		return {
			buscarPorNome: function(nome) {
				return $http({method: 'GET', url: alunosResourceUrl + '/busca-nome?nome=' + nome});
			}

		};
	});

})();