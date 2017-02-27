var app = angular.module("readerhome",[]);
app.controller("find",function($scope, $http){
	// 从后台获取
	$scope.pagenum = Math.round(Math.random()*1000+50);
	$http.get("test/json.txt").success(function(response){
		$scope.page = response.data;
	});
	
	$scope.$watch("findtext",function(scope){
		if(scope != undefined){
			/*控制台技巧：
			 %c后面的字符可以用log方法的第二个参数改变颜色如"color:red"
			 控制台中出现网址会自动出现链接
			 * */
			console.log(scope,"color:red");
		}
	});
	
	
});