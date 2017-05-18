/**
 * Created by yfyuan on 2016/8/19.
 */
JamesBoard.controller('introductionCtrl', ['$scope', 'Upload', '$timeout', function ($scope, Upload, $timeout) {
    $scope.uploadPic = function(file) {
        file.upload = Upload.upload({
          //url: 'https://angular-file-upload-cors-srv.appspot.com/upload',
          url:'portal/upload.do',
            data: {username: $scope.username, file: file},
        });

        file.upload.then(function (response) {
          $timeout(function () {
            file.result = response.data;
          });
        }, function (response) {
          if (response.status > 0)
            $scope.errorMsg = response.status + ': ' + response.data;
        }, function (evt) {
          // Math.min is to fix IE which reports 200% sometimes
          file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
        });
        }
    }]);