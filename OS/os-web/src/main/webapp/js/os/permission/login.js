$.validator.setDefaults({
	submitHandler : function() {
		var user = new OSystem.Permission.User();
		user.login();
	}
});
$(document).ready(function() {
	//模版自带
	runAllForms();
	//以下为开发代码
	var loginValidator=new OSystem.Permission.LoginValidator();
	loginValidator.registValidate();
});
OSystem.Permission = OSystem.Permission || {};
OSystem.Permission.loginForm = $("#login-form");
OSystem.Permission.LoginValidator = OSystem.Class({
	// 构造函数
	initialize : function() {
	},
	registValidate : function() {
		// Validation
		OSystem.Permission.loginForm.validate({
			// Rules for form validation
			rules : {
				email : {
					required : true,
					minlength : 3,
					maxlength : 20
				},
				password : {
					required : true,
					minlength : 3,
					maxlength : 20
				}
			},

			// Messages for form validation
			messages : {
				username : {
					required : '请输入用户名',
					minlength : jQuery.format("用户名不能小于{0}个字符"),
					maxlength : jQuery.format("用户名不能大于{0}个字符")
				},
				password : {
					required : '请输入密码',
					minlength : jQuery.format("密码不能小于{0}个字符"),
					maxlength : jQuery.format("用户名不能大于{0}个字符")
				}
			},

			// Do not change code below
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});
	}
});
OSystem.Permission.User = OSystem.Class({
	// 构造函数
	initialize : function() {
	},
	// 用户登录
	login : function() {

		var pageManager = new OSystem.Manager.PageManager();
		$.ajax({
			"type" : "POST",
			"url" : pageManager.getContextPath() + "/user/login",
			"dataType" : "json",
			"data" : OSystem.Permission.loginForm.serialize(),
			"success" : function(resp) {
				// {"code":null,"success":false,"data":null,"messages":["验证码错误"]}
				if(resp.success){
					pageManager.redirectPage(resp.data.successUrl);
				}
			}
		});
	}
});
