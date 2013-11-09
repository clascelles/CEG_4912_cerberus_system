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
						<li><a href="#">Schedule</a></li>
					</ul>
				</div>

				<div class="row-fluid">
					<div class="box span6">
						<div class="box-header well">
							<h2>
								<i class="icon-time"></i> Add Event
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">							
							<form id="addEvent" class="form-horizontal" method="post">
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
														  <option value="${outlet.id}">${outlet.id}</option>
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
													<option value="0">A</option>
													<option value="1">B</option>
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
													  <option value="${mode.id}">${mode.name}</option>
										  		</c:forEach>
									  		</select>								  		
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="recurrenceId">Event recurrence</label>
										<div class="controls">
											<select data-placeholder="Select Event Recurrence" name="recurrenceId" data-rel="chosen" id="recurrenceId">
												<option value=""></option>
												<c:forEach items="${recurrences}" var="recurrence">
												  <option value="${recurrence.id}">${recurrence.name}</option>
												</c:forEach>
									  		</select>									  		
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="addEvent">Add</button>
									</div>
						  		</fieldset>
						  	</form>
							<div class="clearfix"></div>
						</div>
					</div>
					
					<div class="box span6">
						<div class="box-header well">
							<h2>
								<i class="icon-list-alt"></i> Existing Events
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">							
							<form id="listEvents" class="form-horizontal" method="post">
						  		<fieldset>									
									<div class="control-group">
										<label class="control-label" for="outletId">Outlet</label>
										<div class="controls">
											<select data-placeholder="Select Outlet" name="outletId" data-rel="chosen" id="viewOutletId">
												<option value=""></option>											
												<c:forEach items="${rooms}" var="room">		  			
													<optgroup label="${room.key.name}">
														<c:forEach items="${room.value}" var="outlet">
														  <option value="${outlet.id}" <c:if test="${outletId == outlet.id}">selected</c:if>>${outlet.id}</option>
														</c:forEach>
													</optgroup>
										  		</c:forEach>
									  		</select>									  		
										</div>
									</div>
									<div id="viewSocketId">
										<div class="control-group">
											<label class="control-label" for="socketPosition">Socket</label>
											<div class="controls">
												<select data-placeholder="Your Socket" name="socketPosition" data-rel="chosen">
													<option value="0" <c:if test="${socketPosition == 0}">selected</c:if>>A</option>
													<option value="1" <c:if test="${socketPosition == 1}">selected</c:if>>B</option>
										  		</select>								  		
											</div>
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="viewExistingSchedules" id="viewExistingSchedules">View Events</button>
									</div>
						  		</fieldset>
						  	</form>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<c:if test="${scheduledEvents != null}">
					<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-search"></i> Socket ${socket.id} Events
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">							
							<form id="listEvents" class="form-horizontal" method="post">
						  		<table class="table table-striped table-bordered bootstrap-datatable datatable">
								  <thead>
									  <tr>
										  <th>Event Timestamp</th>
										  <th>Operation Mode</th>
										  <th>Recurrence</th>
										  <th>Scheduler</th>
										  <th>Action</th>
									  </tr>
								  </thead>   
								  <tbody>
								  	<c:forEach items="${scheduledEvents}" var="item">
								  		<tr>
								  			<td><span>${item.time}</span><%-- <div class="input-prepend"><span class="add-on"><i class="icon-calendar"></i></span><input type="text" name="time" id="time${item.id}" readonly value="${item.time}"/></div> --%></td>
								  			<td><span>${item.mode.description}</span>
								  			<td><span>${item.recurrence.name}</span>
								  			<td><span>${item.user.fullName}</span>
									  			<%-- <select data-placeholder="Select Operation Mode" name="modeId" data-rel="chosen">
													<option value=""></option>											
													<c:forEach items="${modes}" var="mode">	
														  <option value="${mode.id}" <c:if test="${mode.id == item.modeId}">selected</c:if>>${mode.name}</option>
											  		</c:forEach>
										  		</select> --%>
									  		</td>
								  			<td>
								  				<a class="btn btn-primary" href="/webappserver/schedules/edit?id=${item.id}"><i class="icon-pencil icon-white"></i></a>
												<button type="submit" class="btn btn-danger" name="deleteEvent" id="deleteEvent" formaction="/webappserver/schedules/index?id=${item.id}"><i class="icon-remove icon-white"></i></button>
							  				</td>
								  		</tr>
									</c:forEach>
								  </tbody>
							    </table>		
						  	</form>
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
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		 var outletChanged = function() {
			 var index = $("#outletId").val();
			  if(typeof index === 'undefined' || index == 0) {
			  		$('#socketInput').hide();
		   		}
		    	else {
			  		$('#socketInput').show();
		    	}
	    	};
	    	
    	var viewOutletChanged = function() {
			 var index = $("#viewOutletId").val();
			  if(typeof index === 'undefined' || index == 0) {
			  		$('#viewSocketId').hide();
		   		}
		    	else {
			  		$('#viewSocketId').show();
		    	}
	    	};
			
		  $('#outletId').change(function() {
			  outletChanged();
		  });
		  
		  outletChanged();		
			
		  $('#viewOutletId').change(function() {
			  viewOutletChanged();
		  });
		  
		  viewOutletChanged();	 
		  
		  $("#time").datetimepicker({format: 'mm/dd/yyyy hh:ii'});
		  $('#eventDuration').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' });
		});
	</script>    
	
</body>
</html>
