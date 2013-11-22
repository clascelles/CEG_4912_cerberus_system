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
		
	<script type="text/javascript">
	
		//GRAPH 1
		var graphValues = '<c:out value="${currentList}"/>';
		var graphValuesArray = graphValues.split(",");
		
		var minX = '<c:out value="${usageOptions.minimumXAxisValue}"/>';
		var maxX = '<c:out value="${usageOptions.maximumXAxisValue}"/>';
		var minY = '<c:out value="${usageOptions.minimumYAxisValue}"/>';
		var maxY = '<c:out value="${usageOptions.maximumYAxisValue}"/>';
		
		var xLabel = '<c:out value="${usageOptions.xaxisLabel}"/>';
		
		var dataValues = [];
		var offset = parseInt(minX);
		for(var i=0; i<graphValuesArray.length; i++){
			dataValues.push([i+offset, graphValuesArray[i]]);
		}
		
		//GRAPH 2
		var graphValues2 = '<c:out value="${currentList2}"/>';
		var graphValuesArray2 = graphValues2.split(",");
		
		var minX2 = '<c:out value="${usageOptions2.minimumXAxisValue}"/>';
		var maxX2 = '<c:out value="${usageOptions2.maximumXAxisValue}"/>';
		var minY2 = '<c:out value="${usageOptions2.minimumYAxisValue}"/>';
		var maxY2 = '<c:out value="${usageOptions2.maximumYAxisValue}"/>';
		
		var xLabel2 = '<c:out value="${usageOptions2.xaxisLabel}"/>';
		
		var dataValues2 = [];
		var offset2 = parseInt(minX2);
		for(var i=0; i<graphValuesArray2.length; i++){
			dataValues2.push([i+offset2, graphValuesArray2[i]]);
		}

	</script>
		
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
						<li><a href="#">Dashboard</a></li>
					</ul>
				</div>

				<div class="row-fluid">
					<a data-rel="tooltip" title="2 sockets allocated today" class="well span3 top-block" href="#">
						<span><i class="icon32 icon-blue icon-home"></i></span>
						<div>My Sockets</div>
						<div>25</div>
						<span class="notification green">2</span>
					</a>
					
					<a data-rel="tooltip" class="well span3 top-block" href="#">
						<i class="icon32 icon-color icon-lightbulb"></i>
						<div>Present Usage</div>
						<div>15 kWh</div>
						<!-- <span class="notification green">2</span> -->
					</a>
					
					<a data-rel="tooltip" class="well span3 top-block" href="#">
						<span class="icon32 icon-blue icon-cart"></span>
						<div>Cost / Savings</div>
						<div>$20.46 / $5.09</div>
						<span class="notification yellow">$0.46 / $0.09</span>
					</a>
					
					<a data-rel="tooltip" title="1 new tip today" class="well span3 top-block" href="#">
						<i class="icon32 icon-green icon-info"></i>
						<div>Savings Tip</div>
						<div>Run dishwasher at night</div>
						<span class="notification green">1</span>
					</a>
				</div>
					
				 <div class="row-fluid">				
					<div class="box span6 xl ">
						<div class="box-header well">
							<h2>
								<i class="icon-signal"></i> Today's Consumption
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
							<div id="usageGraph" class="center" style="height: 300px"></div>
							<div class="clearfix"></div>
						</div>
					</div>
					
					<div class="box span6 xl ">
						<div class="box-header well">
							<h2>
								<i class="icon-signal"></i> This Month's Consumption
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
							<div id="usageGraph2" class="center" style="height: 300px"></div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
					 <div class="row-fluid">			
					<div class="box span6 xl">
						<div class="box-header well">
							<h2>
								<i class="icon-info-sign"></i> Information Logs
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
							<table>
								<c:choose>
									<c:when test="${events.size() == 0}">
										No information available.
									</c:when>
									<c:otherwise>
										<c:forEach items="${events}" var="event">
										<tr>
											<td>
												<!-- Should not use hard-coded numbers here! -->
												<c:if test="${event.level == 1}">
													<span class="label label-info">Info</span>
												</c:if>
												<c:if test="${event.level == 2}">
													<span class="label label-info">Info</span>
												</c:if>
												<c:if test="${event.level == 3}">
													<span class="label label-warning">Warn</span>
												</c:if>
												<c:if test="${event.level == 4}">
													<span class="label label-important">Error</span>
												</c:if>
												<c:if test="${event.level == 5}">
													<span class="label label-info">Debug</span>
												</c:if>
											</td>
											<td>
												<span style="padding:2px">${event.timestamp}</span>
											</td>
											<td>
												<span style="padding:2px">- ${event.message}</span>
											</td>
										</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
							<div class="clearfix"></div>
						</div>
					</div>
				
				
							
					<div class="box span6 xl">
						<div class="box-header well">
							<h2>
								<i class="icon-info-sign"></i> Latest Tips
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
						<div class="box-content">
							<table>
								<c:choose>
									<c:when test="${tips.size() == 0}">
										No information available.
									</c:when>
									<c:otherwise>
										<c:forEach items="${tips}" var="tip">
										<tr>
											<td>
												<!-- Should not use hard-coded numbers here! -->
												<c:if test="${tip.level == 1}">
													<span class="label label-warning"> New </span>
												</c:if>
												<c:if test="${tip.level == 2}">
													<span class="label label-info">Recent</span>
												</c:if>
												<c:if test="${tip.level == 3}">
													<span class="label label-info">Old</span>
												</c:if>
											</td>
											<td>
												<span style="padding:2px">${tip.timestamp}</span>
											</td>
											<td>
												<span style="padding:2px">- ${tip.message}</span>
											</td>
										</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
					<div class="row-fluid">			
					<div class="box span12 xl">
						<div class="box-header well">
							<h2>
								<i class="icon-time"></i> Schedules
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
										  <th>Socket</th>
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
								  			<td><span>${item.outletId} - <c:choose><c:when test="${item.socketPosition == 0}">A</c:when><c:otherwise>B</c:otherwise></c:choose></span>
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
			</div>
		</div>


		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">Ã</button>
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
