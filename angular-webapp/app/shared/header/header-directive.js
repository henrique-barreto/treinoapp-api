(function() {

	angular.module('app')
	.directive('headerPublico', function() {
		return {
			restrict: 'E',
			templateUrl: 'app/shared/header/header-publico.html'
		};

	});

	angular.module('app')
	.directive('headerRestrito', function() {
		return {
			restrict: 'E',
			templateUrl: 'app/shared/header/header-restrito.html'
		};

	});

})();