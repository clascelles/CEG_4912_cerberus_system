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
	<title><fmt:message key="overview.title"/></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Cerberus Application Overview">
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
	<link rel="shortcut icon" href="/webappserver/resources/img/favicon.png">
		
</head>

<body>
	
	<!-- topbar starts -->
	<%@include file="../main/topbar.jsp" %>
	<!-- topbar ends -->

	<div class="container-fluid">
		<div class="row-fluid">

			<!-- left menu starts -->
			<%@include file="../main/leftbar.jsp"%>
			<!-- left menu ends -->

			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

			<div id="content" class="span10">
				<!-- content starts -->


				<div>
					<ul class="breadcrumb">
						<li><a href="#">Dashboard</a></li>
					</ul>
				</div>

				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-film"></i> Outlets
							</h2>
						</div>
						<div class="box-content">
							Put Content Here!
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
					class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
			<p class="pull-left">&copy; Cerberus Technoligies 2013 </p>
			<p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a>	</p>
		</footer>

	</div>
	<!--/.fluid-container-->

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
