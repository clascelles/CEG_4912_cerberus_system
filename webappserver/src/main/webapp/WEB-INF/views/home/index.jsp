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
					<div class="box span12">
						<div class="box-header well">
							<h2>
								Consumption
							</h2>
						</div>
						<div class="box-content">
							Put consumption graph Here!
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
				<div class="row-fluid">				
					<div class="box span12">
						<div class="box-header well">
							<h2>
								Information Logs
							</h2>
						</div>
						<div class="box-content">
							<table>
								<c:forEach items="${events}" var="event">
								<tr>
									<td>
										<!-- Should not use hard-coded numbers here! -->
										<c:if test="${event.level == 1}">
											<span class="label label-info">Info</span>
										</c:if>
										<c:if test="${event.level == 2}">
											<span class="label label-info">Announcement</span>
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
							</table>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				
				<div class="row-fluid">				
					<div class="box span12">
						<div class="box-header well">
							<h2>
								Schedules
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
