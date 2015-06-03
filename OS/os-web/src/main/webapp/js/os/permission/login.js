$(document).ready(function(){
	
});
OSystem.Permission.User=OSystem.Class({
	//构造函数
	initialize:function(){},
	//用户登录
	login:function(){
		var loginForm=${"#login-form"};
		$.ajax({
            "type": "POST",    
            "contentType": "application/json;charset=UTF-8",   
            "url": "/user/login",    
            "dataType": "json",   
            "data": loginForm.serialize(),
            "success": function(res) {
            	
            } 
		});
	}
});

