JamesBoard.controller('hiveCtrl', function($rootScope, $scope, $http) {
    $scope.hiveSql = "select * from telenav.student;";

    $http.get("mysql/getAllStudentInfo.do").success(function(response) {
        console.info(response);
        
        $scope.studentInfo = response[0].id+'  '+response[0].name+'  '+response[0].age+'  '+response[0].city+'  '+response[0].birthday;
    }).error(function(data, header, config, status) {
        console.log(status);
    });

    $scope.submit = function() {
        $scope.hiveResult = $scope.studentInfo;
    };
});