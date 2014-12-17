$(document).ready(function() {
	var pm = new OSystem.Manager.PageManager();
	var mainDiv = $("#main");
	pm.loadPage("/jsp/permission/user/user.jsp", mainDiv);
});
