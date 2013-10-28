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
	<meta name="description" content="Cerberus Application Security Page">
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
						<li><a href="#">RFID Tags</a></li>
					</ul>
				</div>

				<!-- view rfid tags -->
				
				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-tags"></i> View RFID Tags
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
						  	<table class="table table-striped table-bordered bootstrap-datatable datatable">
							  <thead>
								  <tr>
									  <th>ID</th>
									  <th>Room</th>
									  <th>Operation Mode</th>
									  <th>Serial Number</th>
									  <th>Action</th>
								  </tr>
							  </thead>   
							  <tbody>
							  	<c:forEach items="${userOutlets}" var="item">
							  		<tr>
							  			<td>${item.id}</td>
							  			<td>${item.roomName}</td>
							  			<td>${item.modeName}</td>
							  			<td>${item.serialNumber}</td>
							  			<td><a class="btn btn-primary" href="/webappserver/outlets/view?id=${item.id}"><i class="icon-zoom-in icon-white"></i>View</a></td>
							  		</tr>
								</c:forEach>
							  </tbody>
						    </table>							
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
				<!-- add rfid tags -->
				
				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-tag"></i> Add an RFID Tag
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
						  	<form id="addOutlet" class="form-horizontal" method="post">
						  		<fieldset>
									<div class="control-group">
										<label class="control-label">Serial Number</label>
										<div class="controls">
											<input class="input-xlarge" name="serialNumber" type="text">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Room</label>
										<div class="controls">
										  	<select name="roomId" data-rel="chosen">
										  		<c:forEach items="${rooms}" var="room">
													<option value="${room.typeId}">${room.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="add">Add</button>
										<button type="reset" class="btn" name="reset">Clear</button>
									</div>
						  		</fieldset>
						  	</form>						  								
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
	
	<script>
		$('reset').click(function() { document.getElementById('serialNumber').value = ''; });
	</script>
	
</body>
</html>
