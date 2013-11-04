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
						<li><a href="/webappserver/security/index">Security</a></li>
						<li><span></span></li>
						<li><a href="#">View RFID Tag</a></li>
					</ul>
				</div>

				<!-- view rfid tag -->
				
				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-list-alt"></i>
								View RFID Tag ${rfidTag.id}
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">						  	
						  	<form id="modifyRfidTag" class="form-horizontal" method="post">						  		
						  		<fieldset>
									<div class="row-fluid">
										<div class="span2">
									  		<span><b>Tag Number</b></span>
										</div>
										<div class="span2">
									  		<span>${rfidTag.number}</span>
										</div>
									</div>
									
									<div class="row-fluid" style="padding-bottom:5px">
										<div class="span2">
									  		<span><b>Tag Description</b></span>
										</div>
										<div class="span2">
									  		<input type="text" name="description" value="${rfidTag.description}">
										</div>
									</div>
									
									<div class="row-fluid" style="padding-bottom:5px">
										<div class="span2">
									  		<span><b>Tag Permission</b></span>
										</div>
										<div class="span2">
							  				<select name="permission" data-rel="chosen" <c:if test="${!isSysAdmin}">disabled</c:if>>
										  		<option value="${denied}" <c:if test="${rfidTag.permission == denied}">selected</c:if> >${denied}</option>
										  		<option value="${allowed}" <c:if test="${rfidTag.permission == allowed}">selected</c:if> >${allowed}</option>
											</select>	
										</div>							
									</div>			
						  			<div class="clearfix"></div>						
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="update">Update</button>
									</div>
								</fieldset>
						  	</form>
						</div>
					</div>
				</div>				  
						  	
				<div class="clearfix"></div>
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
