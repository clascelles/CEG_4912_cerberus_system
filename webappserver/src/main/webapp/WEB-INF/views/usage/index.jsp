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
	
	<!-- This script is used to structure the values from Java in a proper array for the graphs -->
	<script type="text/javascript">
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
						<li><a href="#">Usage</a></li>
					</ul>
				</div>

				<div class="row-fluid">
					<div class="box span12">
						<div class="box-header well">
							<h2>
								<i class="icon-time"></i> Usage Options
							</h2>
						</div>
						<div class="box-content">
							<form id="getGraphInformation" class="form-horizontal"	method="post">
								<fieldset>
									<div class="control-group">
										<label class="control-label">Time Span</label>
										<div class="controls">
											<select id="selectGranularity"
												data-rel="chosen" name="timeSpan">
												<option value="1" <c:if test='${usageOptions.timeSpan == 1}'>selected="selected"</c:if>>Day</option>
												<option value="2" <c:if test='${usageOptions.timeSpan == 2}'>selected="selected"</c:if>>Month</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Date</label>
										<div class="controls">
											
											<div class="input-append date" id="datepickerUsageDay" data-date="${usageOptions.getDateFormated()}" style="display: inline;">
												<input id="dayDate" class="span2" size="100" type="text" value="${usageOptions.getDateFormated()}"> <span class="add-on"><i class="icon-th"></i></span>
											</div>
											
											<div class="input-append date" id="datepickerUsageMonth" data-date="${usageOptions.getDateFormated()}" style="display: none;">
												<input id="monthDate" class="span2" size="100" type="text" value="${usageOptions.getDateFormated()}"> <span class="add-on"><i class="icon-th"></i></span>
											</div>
											
											<input type="hidden" name="selectedDate" id="datePicked" value=""/>
										</div>
									</div>
								</fieldset>
									<div class="form-actions">
										<button type="submit" class="btn btn-primary" name="generateGraph" id="generateGraph" onClick="updateDate()">Generate Graph</button>
									</div>
							</form>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>


				<div class="row-fluid">
					<div class="box">
						<div class="box-header well">


							<h2>
								<i class="icon-list-alt"></i> Electricity Consumption Graph
							</h2>
							<div class="box-icon">
								<a href="#" class="btn btn-setting btn-round"><i
									class="icon-cog"></i></a> <a href="#"
									class="btn btn-minimize btn-round"><i
									class="icon-chevron-up"></i></a> <a href="#"
									class="btn btn-close btn-round"><i class="icon-remove"></i></a>
							</div>
						</div>
						<div class="box-content"><div><p align="center"><c:out value="${usageOptions.chartTitle}"/></p></div>
							<div id="usageGraph" class="center" style="height: 300px"></div>
							
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
			<p class="pull-left">&copy; Cerberus Technologies 2013</p>
			<p class="pull-right">
				Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a>
			</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	
	<%@include file="\WEB-INF\views\main\javascript.jsp" %>
	<script type="text/javascript">
	
	
	
	$(document).ready(function(){
		
		initDatePicker();
		$('#selectGranularity').change(changeGranularity);
		
		function initDatePicker(){
			
			
		$('#datepickerUsageDay').datepicker({
			format: "mm/dd/yyyy",
		    todayBtn: "linked",
		    autoclose: true,
		    defaultDate: $('#dayDate').val()
	    });
		
		$('#datepickerUsageMonth').datepicker({
			format: "mm/dd/yyyy",
			minViewMode: 1,
		    todayBtn: "linked",
		    autoclose: true,
		    defaultDate: $('#monthDate').val()
		});
		
		changeGranularity();


		}
		
		function changeGranularity(){
			switch($('#selectGranularity').val()){
			case '1':
				$('#datepickerUsageDay').css({ display: "inline"});
				$('#datepickerUsageMonth').css({ display: "none"});
				break;
			case '2':
				$('#datepickerUsageDay').css({ display: "none"});
				$('#datepickerUsageMonth').css({ display: "inline"});
				break;
			default:
				//Do nothing
				break;
			}
			
		}
		
		
		
	});
	
	function updateDate(){
		
		switch(document.getElementById('selectGranularity').value){
		case '1':
			document.getElementById('datePicked').value = document.getElementById('dayDate').value;
			break;
		case '2':
			document.getElementById('datePicked').value = document.getElementById('monthDate').value;
			break;
		}
		
	}
	
	</script>

	
</body>
</html>
