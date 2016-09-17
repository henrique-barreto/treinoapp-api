(function() {

	angular.module('app.authentication', ['ngCookies'])
	.service('AuthService', function($http, $cookies, $location, $rootScope, $state){


		var authService = this;
		var loginUrl = 'http://localhost:8080/treinoapp/login';

		this.login = function (username, password) {

			var data = 'username=' + username + '&password=' + password;

			$http({
				url: loginUrl,
				method: "POST",
				data: data,
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function (data, status, headers, config) {
				alert('ok: ' + status);
				console.log(headers);

				authService.setCredentials(username, password);

				// $location.path('/aluno/home');
				$state.transitionTo('professor.home', {});
			}).error(function (data, status, headers, config) {
				alert('error: ' + status);
			});

		};

		this.setCredentials =  function(username, password) {

			console.log('colocando credentias');
			var authdata = btoa(username + ':' + password);

			$rootScope.globals = {
				currentUser: {
					username: username,
					authdata: authdata
				}
			};

			console.log($rootScope.globals);
			$http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
			$cookies.put('globals', $rootScope.globals);
		};

		this.clearCredentials = function() {
			$rootScope.globals = {};
			$cookieStore.remove('globals');
			$http.defaults.headers.common.Authorization = 'Basic';
		}


	});


})();