(function() {

	angular.module('app')
	.directive('menuLateral', function() {
		return {
			restrict: 'E',
			templateUrl: 'app/shared/menu/menu-lateral.html'
		};

	});

})();