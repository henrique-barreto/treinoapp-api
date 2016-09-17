(function() {

	angular.module('app', ['ui.router', 'app.professor', 'app.authentication'])
	.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

		$urlRouterProvider.otherwise('/');

		$stateProvider
		.state('publico', {
			abstract: true,
			templateUrl: '/app/shared/view-template/publico.html'
		})
		.state('publico.inicial', {
			url: '/',
			templateUrl: '/app/shared/pagina-inicial/index.html'
		})
		.state('publico.login', {
			url: '/login',
			templateUrl: '/app/modules/authentication/login.html'
		});


	}]);


})();


