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
	<%@include file="\WEB-INF\views\main\styles.jsp" %>

	<!-- The fav icon -->
	<link rel="shortcut icon" href="/webappserver/resources/img/favicon.png">
		
</head>

<body>
	
	<!-- topbar starts -->
	<%@include file="\WEB-INF\views\main\topbar.jsp" %>
	<!-- topbar ends -->

	<div class="container-fluid">
		<div class="row-fluid">

			<!-- left menu starts -->
			<%@include file="\WEB-INF\views\main/leftbar.jsp"%>
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
						<li><a href="/webappserver/outlets/index">Outlets</a></li>
						<li><span>></span></li>
						<li><a href="#">View Outlet</a></li>
					</ul>
				</div>

				<!-- view outlets -->
				
				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-list-alt"></i>
								View Outlet ${outlet.id}
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
						  	
						  	<div class="span4">
						  		<span><b>Operation Mode</b>&nbsp; &nbsp; &nbsp;${outlet.modeName}</span>
							</div>
						  	
						  	<c:forEach items="${sockets}" var="socket">
								<div class="row-fluid">
									<div class="box span12">
										<div class="box-header well">
											<h2>
												<i class="icon-film"></i> Socket ${socket.position}
											</h2>
											<div class="box-icon">
												<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
											</div>
										</div>
										<div class="box-content">	
											<div class="span6">
												<div class="row-fluid">
													<div class="span4"><b>Consumer</b></div>
													<div class="span4">${socket.connectedUsername}</div>
												</div>
												
												<div class="row-fluid">
													<div class="span4"><b>Operation Mode</b></div>
													<div class="span4">${socket.statusName} - ${socket.operationModeName}</div>
												</div>
												
												<div class="row-fluid">
													<div class="span4"><b>Power Usage</b></div>
													<div class="span4">TODO: power usage</div>
												</div>
												
												<div class="row-fluid">
													<div class="span4"><b>Time Connected</b></div>
													<div class="span4">TODO: time connected</div>
												</div>
												
												<div class="row-fluid">
													<div class="span4"><b>Connected Utility</b></div>
													<div class="span4">TODO: connected utility</div>
												</div>
												
												<div class="row-fluid">
													<div class="span4"><b>Serial Number</b></div>
													<div class="span4">${socket.serialNumber}</div>
												</div>
											</div>
											
											<div class="span6">
												[graph goes here]
											</div>	
										  	
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
							</c:forEach>
						  	
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
			<p class="pull-left">&copy; Cerberus Technologies 2013 </p>
			<p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a>	</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<%@include file="\WEB-INF\views\main\javascript.jsp" %>
	
</body>
</html>
