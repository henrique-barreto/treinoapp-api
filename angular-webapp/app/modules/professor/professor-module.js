(function() {

	angular.module('app.professor', ['ui.router'])
	.config(['$stateProvider', function($stateProvider) {

		$stateProvider
		.state('professor', {
			abstract: true,
			templateUrl: '/app/shared/view-template/seguro.html'
		})
		.state('professor.home', {
			url: '/professor',
			templateUrl : "app/modules/professor/views/home.html"
		})
		.state('professor.buscar', {
			url: '/professor/buscar-aluno',
			templateUrl : "app/modules/professor/views/buscar-aluno.html"
		});

	}])

})();