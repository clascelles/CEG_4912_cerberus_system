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
						<li><a href="/webappserver/schedules/index">Schedule</a></li>
						<li><span>></span></li>
						<li><a href="#">Edit Event</a></li>
					</ul>
				</div>

				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-wrench"></i> Edit Event
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">							
							<form id="editEvent" class="form-horizontal" method="post">
						  		<fieldset>
									<div class="control-group">
										<label class="control-label" for="time">Event Time:</label>
									    <div class="controls">
									    	<div class="input-prepend">
									    	<span class="add-on"><i class="icon-calendar"></i></span><input type="text" name="time" id="time" readonly value="${scheduledEvent.time}"/>
									    	</div>
										</div>
									
										<%-- <label class="control-label" for="eventDuration">Schedule duration:</label>
									    <div class="controls">
									    	<div class="input-prepend">
									    	<span class="add-on"><i class="icon-calendar"></i></span><input type="text" name="eventDuration" id="eventDuration" value="${scheduledEvent.eventDuration}"/>
									    	</div>
										</div> --%>
								    </div>
									<div class="control-group">
										<label class="control-label" for="outletId">Outlet</label>
										<div class="controls">
											<select data-placeholder="Select Outlet" name="outletId" data-rel="chosen" id="outletId">
												<option value=""></option>											
												<c:forEach items="${rooms}" var="room">		  			
													<optgroup label="${room.key.name}">
														<c:forEach items="${room.value}" var="outlet">
														  <option value="${outlet.id}" <c:if test="${scheduledEvent.outletId == outlet.id}">selected</c:if>>${outlet.id}</option>
														</c:forEach>
													</optgroup>
										  		</c:forEach>
									  		</select>									  		
										</div>
									</div>
									<div id="socketInput">
										<div class="control-group">
											<label class="control-label" for="socketPosition">Socket</label>
											<div class="controls">
												<select data-placeholder="Your Socket" name="socketPosition" data-rel="chosen">
													<option value="0" <c:if test="${scheduledEvent.socketPosition == 0}">selected</c:if>>A</option>
													<option value="1" <c:if test="${scheduledEvent.socketPosition == 1}">selected</c:if>>B</option>
										  		</select>								  		
											</div>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="modeId">Operation Mode</label>
										<div class="controls">
											<select data-placeholder="Select Operation Mode" name="modeId" data-rel="chosen">
												<option value=""></option>											
												<c:forEach items="${modes}" var="mode">	
													  <option value="${mode.id}" <c:if test="${scheduledEvent.modeId == mode.id}">selected</c:if>>${mode.name}</option>
										  		</c:forEach>
									  		</select>								  		
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="editEvent">Edit</button>
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
	
	<script type="text/javascript">
		$(document).ready(function() {		  
		  $("#time").datetimepicker({format: 'mm/dd/yyyy hh:ii'});
		  $('#eventDuration').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' });
		});
	</script>    
	
</body>
</html>
