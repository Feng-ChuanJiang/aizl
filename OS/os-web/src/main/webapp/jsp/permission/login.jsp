<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<%
	String path = request.getContextPath();
%>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
<title>智能运维</title>
<meta name="description" content="登录页">
<meta name="author" content="ai.zhanglin">

<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- JQUERY VALIDATE -->
<script src="<%=path%>/js/plugin/jquery-validate/jquery.validate.min.js"></script>
<script data-contextpath="<%=path%>" src="<%=path%>/js/os/os.js"></script>
<script src="<%=path%>/js/os/permission/login.js"></script>
	<!-- MAIN APP JS FILE -->
<script src="<%=path %>/js/app.js"></script>
</head>
<body id="login" class="animated fadeInDown">
	<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
	<header id="header">
		<!--<span id="logo"></span>-->

		<div id="logo-group">
			<span id="logo"> <img src="<%=path%>/img/logo.png"
				alt="SmartAdmin">
			</span>

			<!-- END AJAX-DROPDOWN -->
		</div>

		<span id="login-header-space"> <span class="hidden-mobile">Need
				an account?</span> <a href="<%=path%>/jsp/permission/user/register.jsp"
			class="btn btn-danger">Creat account</a>
		</span>

	</header>

	<div id="main" role="main">

		<!-- MAIN CONTENT -->
		<div id="content" class="container">

			<div class="row">
				<div
					class="col-xs-12 col-sm-12 col-md-7 col-lg-8 hidden-xs hidden-sm">
					<h1 class="txt-color-red login-header-big">SmartAdmin</h1>
					<div class="hero">

						<div class="pull-left login-desc-box-l">
							<h4 class="paragraph-header">智能运维系统，一切尽在掌握！</h4>
							<div class="login-app-icons">
								<a href="javascript:void(0);" class="btn btn-danger btn-sm">Frontend
									Template</a> <a href="javascript:void(0);"
									class="btn btn-danger btn-sm">Find out more</a>
							</div>
						</div>

						<img src="<%=path%>/img/demo/iphoneview.png"
							class="pull-right display-image" alt="" style="width: 210px">

					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<h5 class="about-heading">About SmartAdmin - Are you up to
								date?</h5>
							<p>Sed ut perspiciatis unde omnis iste natus error sit
								voluptatem accusantium doloremque laudantium, totam rem aperiam,
								eaque ipsa.</p>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
							<h5 class="about-heading">Not just your average template!</h5>
							<p>Et harum quidem rerum facilis est et expedita distinctio.
								Nam libero tempore, cum soluta nobis est eligendi voluptatem
								accusantium!</p>
						</div>
					</div>

				</div>
				<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4">
					<div class="well no-padding">
						<form id="login-form" class="smart-form client-form" method="post">
							<header> 登 录 </header>

							<fieldset>

								<section>
									<label class="label">用户名</label> <label class="input">
										<i class="icon-append fa fa-user"></i> <input type="text"
										name="username"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-user txt-color-teal"></i> 请输入用户名\邮箱\电话号码</b>
									</label>
								</section>

								<section>
									<label class="label">密码</label> <label class="input"> <i
										class="icon-append fa fa-lock"></i> <input type="password"
										name="password"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-lock txt-color-teal"></i> 请输入密码</b>
									</label>
									<div class="note">
										<a href="forgotpassword.html">忘记密码?</a>
									</div>
								</section>
								<section>
									<label class="checkbox"> <input type="checkbox"
										name="remember" checked="checked"> <i></i>记住登录
									</label>
								</section>
							</fieldset>
							<fieldset>
								<div class="row">
									<section class="col col-6">
										<label class="input"> <input type="text"
											name="jcaptcha" placeholder="请输入验证码">
										</label>
									</section>
									<section class="col col-6">
										<label class="input"> <img name="jCaptchaImage"
											src="<%=path%>/jcaptcha">
										</label>
									</section>
								</div>
							</fieldset>
							<footer>
								<button id="loginBtn" type="submit" class="btn btn-primary">登
									录</button>
							</footer>
						</form>

					</div>

					<h5 class="text-center">- 快速登录 -</h5>

					<ul class="list-inline text-center">
						<li><a href="javascript:void(0);"
							class="btn btn-primary btn-circle"><i class="fa fa-facebook"></i></a>
						</li>
						<li><a href="javascript:void(0);"
							class="btn btn-info btn-circle"><i class="fa fa-twitter"></i></a>
						</li>
						<li><a href="javascript:void(0);"
							class="btn btn-warning btn-circle"><i class="fa fa-linkedin"></i></a>
						</li>
					</ul>

				</div>
			</div>
		</div>

	</div>

</body>
</html>