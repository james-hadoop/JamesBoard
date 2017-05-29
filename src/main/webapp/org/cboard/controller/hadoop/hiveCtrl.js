JamesBoard.controller('hiveCtrl', function($rootScope, $scope, $http) {
	$scope.hiveSql = "select * from bi.student;";

	// $http.get("mysql/getAllStudentInfo.do").success(
	// function(response) {
	// // $http.get("hive/getHiveData.do").success(function(response) {
	// console.info(response);
	//
	// $scope.studentInfo = response[0].id + ' ' + response[0].name
	// + ' ' + response[0].age + ' ' + response[0].city + ' '
	// + response[0].birthday;
	// // $scope.studentInfo = response;
	// }).error(function(data, header, config, status) {
	// console.log(status);
	// });

	$http.get("hive/getHiveData.do").success(function(response) {
		console.info(response);

		$scope.studentInfo = response;
	}).error(function(data, header, config, status) {
		console.log(status);
	});

	$scope.submit = function() {
		$scope.hiveResult = $scope.studentInfo;
	};
});