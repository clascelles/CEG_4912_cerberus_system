<!DOCTYPE html>

<!-- Importing all the Tag Libraries Here -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
	<!--
		Charisma v1.0.0

		Copyright 2012 Muhammad Usman
		Licensed under the Apache License v2.0
		http://www.apache.org/licenses/LICENSE-2.0

		http://usman.it
		http://twitter.com/halalit_usman
	-->
	<meta charset="utf-8">
	<title><fmt:message key="login.title"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Cerberus Login Page">
	<meta name="author" content="David Vezina">

	<!-- The styles -->
	<link id="bs-css" href="/webappserver/resources/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="/webappserver/resources/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="/webappserver/resources/css/charisma-app.css" rel="stylesheet">
	<link href="/webappserver/resources/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='/webappserver/resources/css/fullcalendar.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='/webappserver/resources/css/chosen.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/uniform.default.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/colorbox.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/jquery.noty.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/noty_theme_default.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/elfinder.min.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/elfinder.theme.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/opa-icons.css' rel='stylesheet'>
	<link href='/webappserver/resources/css/uploadify.css' rel='stylesheet'>

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="resources/img/favicon.png">
		
</head>

<body>
		<div class="container-fluid">
		<div class="row-fluid">
		
			<div class="row-fluid">
				<div class="span12 center login-header">
					<h2><fmt:message key="login.title"/></h2>
				</div><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid">
				<div class="well span5 center login-box">
					<div class="alert alert-info">
						<fmt:message key="login.instruction"/>
					</div>
					<form:form class="form-horizontal" modelAttribute="loginBackingObject" action="" method="post">
						<fieldset>
							<div class="input-prepend" title="Username" data-rel="tooltip">
								<span class="add-on"><i class="icon-user"></i></span><form:input autofocus="autofocus" class="input-large span10" name="username" id="username" path="username" type="text"/>
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password" data-rel="tooltip">
								<span class="add-on"><i class="icon-lock"></i></span><form:input class="input-large span10" name="password" id="password" type="password" path="password" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend">
							<label class="remember" for="remember"><form:checkbox id="remember" path="rememberMe" /><fmt:message key="login.checkbox.rememberMe"/></label>
							</div>
							<div class="clearfix"></div>

							<p class="center span5">
							<button type="submit" class="btn btn-primary"><fmt:message key="login.button.login"/></button>
							</p>
						</fieldset>
					</form:form>
				</div><!--/span-->
			</div><!--/row-->
				</div><!--/fluid-row-->
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	 <script src="/webappserver/resources/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="/webappserver/resources/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="/webappserver/resources/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="/webappserver/resources/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="/webappserver/resources/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="/webappserver/resources/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="/webappserver/resources/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="/webappserver/resources/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="/webappserver/resources/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="/webappserver/resources/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="/webappserver/resources/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="/webappserver/resources/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="/webappserver/resources/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="/webappserver/resources/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="/webappserver/resources/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="/webappserver/resources/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='/webappserver/resources/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='/webappserver/resources/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="/webappserver/resources/js/excanvas.js"></script>
	<script src="/webappserver/resources/js/jquery.flot.min.js"></script>
	<script src="/webappserver/resources/js/jquery.flot.pie.min.js"></script>
	<script src="/webappserver/resources/js/jquery.flot.stack.js"></script>
	<script src="/webappserver/resources/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="/webappserver/resources/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="/webappserver/resources/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="/webappserver/resources/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="/webappserver/resources/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="/webappserver/resources/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="/webappserver/resources/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="/webappserver/resources/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="/webappserver/resources/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="/webappserver/resources/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="/webappserver/resources/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="/webappserver/resources/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="/webappserver/resources/js/charisma.js"></script>
	
		
</body>
</html>
