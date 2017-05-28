JamesBoard.controller('ngEmoticonCtrl', ['$scope', function ($scope) {
    $scope.options = {
        'linkTarget': '_blank',
        'basicVideo': false,
        'code'      : {
            'highlight'  : true,
            'lineNumbers': true
        },
        'gdevAuth': 'AIzaSyAQONTdSSaKwqB1X8i6dHgn9r_PtusDhq0',
        'video'     : {
            'embed'    : true,
            'width'    : 800,
            'ytTheme'  : 'light',
            'details'  : true
        },
        'image'     : {
            'embed': true
        },
        tweetOptions: {
            align: 'center'
        }
    };
    $scope.pdfText='http://localhost:8080/cboard/pdf/1.pdf';
}]);

