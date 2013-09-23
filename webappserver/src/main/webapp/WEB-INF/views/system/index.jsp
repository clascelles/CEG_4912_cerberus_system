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
	<%@include file="\WEB-INF\views\main/topbar.jsp" %>
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
						<li><a href="#">System</a></li>
					</ul>
				</div>
				
				<c:if test="${isSysAdmin}">					
					<div class="row-fluid">
						<div class="box span12">
							<div class="box-header well">
								<h2>
									<i class="icon-wrench"></i> System Settings
								</h2>
								<div class="box-icon">
									<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								</div>
							</div>
							<div class="box-content">
								System settings here
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					
					<div class="row-fluid">
						<div class="box span12">
							<div class="box-header well">
								<h2>
									<i class="icon-wrench"></i> Manage Users
								</h2>
								<div class="box-icon">
									<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
								</div>
							</div>
							<div class="box-content">
							  	<table class="table table-striped table-bordered bootstrap-datatable datatable">
								  <thead>
									  <tr>
										  <th>Username</th>
										  <th>First Name</th>
										  <th>Last Name</th>
										  <th>Phone Number</th>
										  <th>Address</th>
										  <th>Actions</th>
									  </tr>
								  </thead>   
								  <tbody>
								  	<c:forEach items="${usersList}" var="user">
								  		<tr>
								  			<td>${user.login.username}</td>
								  			<td>${user.information.firstName}</td>
								  			<td>${user.information.lastName}</td>
								  			<td>${user.information.phoneNumber}</td>
								  			<td>${user.information.address}</td>
								  			<td><a class="btn btn-primary" href="/webappserver/system/user/view?id=${user.id}"><i class="icon-zoom-in icon-white"></i>View</a></td>
								  		</tr>
									</c:forEach>
								  </tbody>
							    </table>							
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</c:if>
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
