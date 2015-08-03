<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<%
	String path = request.getContextPath();
%>
<meta charset="utf-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
<title><decorator:body /></title>
<meta name="description" content="智能运维">
<meta name="author" content="ai.zhanglin">

<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=path%>/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=path%>/css/font-awesome.min.css">

<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=path%>/css/smartadmin-production.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=path%>/css/smartadmin-skins.css">

<!-- SmartAdmin RTL Support is under construction
			<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=path%>/css/demo.css">

<!-- FAVICONS -->
<link rel="shortcut icon" href="<%=path%>/img/favicon/favicon.ico"
	type="image/x-icon">
<link rel="icon" href="<%=path%>/img/favicon/favicon.ico"
	type="image/x-icon">

<!-- GOOGLE FONT -->
<link rel="stylesheet" href="<%=path%>/css/googlefonts.css">
<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
<script src="<%=path%>/js/libs/jquery-2.0.2.min.js"></script>

<script src="<%=path%>/js/libs/jquery-ui-1.10.3.min.js"></script>

<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="<%=path%>/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

<!-- BOOTSTRAP JS -->
<script src="<%=path%>/js/bootstrap/bootstrap.min.js"></script>

<decorator:head />
</head>
<body>
	<decorator:body />
	<!--================================================== -->
	<!-- 全局工具包 -->
	<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
	<script src="<%=path%>/js/plugin/pace/pace.min.js"></script>


	<!-- CUSTOM NOTIFICATION -->
	<script src="<%=path%>/js/notification/SmartNotification.min.js"></script>

	<!-- JARVIS WIDGETS -->
	<script src="<%=path%>/js/smartwidgets/jarvis.widget.min.js"></script>

	<!-- EASY PIE CHARTS -->
	<script
		src="<%=path%>/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

	<!-- SPARKLINES -->
	<script src="<%=path%>/js/plugin/sparkline/jquery.sparkline.min.js"></script>

	<!-- JQUERY VALIDATE -->
	<script
		src="<%=path%>/js/plugin/jquery-validate/jquery.validate.min.js"></script>

	<!-- JQUERY MASKED INPUT -->
	<script
		src="<%=path%>/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

	<!-- JQUERY SELECT2 INPUT -->
	<script src="<%=path%>/js/plugin/select2/select2.min.js"></script>

	<!-- JQUERY UI + Bootstrap Slider -->
	<script src="<%=path%>/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

	<!-- browser msie issue fix -->
	<script src="<%=path%>/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

	<!-- FastClick: For mobile devices -->
	<script src="<%=path%>/js/plugin/fastclick/fastclick.js"></script>
	<!-- 全局工具包 -->
	<script data-contextpath="<%=path%>" src="<%=path%>/js/os/os.js"></script>

	<script src="<%=path%>/js/os/permission/login.js"></script>
	<!--[if IE 7]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

	<!-- MAIN APP JS FILE -->
	<script src="<%=path%>/js/app.js"></script>

	<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
	<script src="<%=path%>/js/plugin/flot/jquery.flot.cust.js"></script>
	<script src="<%=path%>/js/plugin/flot/jquery.flot.resize.js"></script>
	<script src="<%=path%>/js/plugin/flot/jquery.flot.tooltip.js"></script>

	<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
	<script src="<%=path%>/js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="<%=path%>/js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script>

	<!-- Full Calendar -->
	<script src="<%=path%>/js/plugin/fullcalendar/jquery.fullcalendar.min.js"></script>
</body>
</html>