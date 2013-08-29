<!-- General Page Information Defined Here -->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!-- Importing all the Tag Libraries Here -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title><fmt:message key="welcome.title"/></title>
	
	<!-- Import CSS Links Here -->
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/plugins/buttons/screen.css" />" type="text/css" media="screen">
	
</head>

<body>
<div class="container">
	<h1><fmt:message key="welcome.title"/></h1>
	<div class="span-12 last">	
		<form:form modelAttribute="loginBackingObject" action="" method="post">		
		  	<fieldset>		
				<legend><fmt:message key="welcome.table.legend"/></legend>
				<p>
					<form:label	for="username" path="username" cssErrorClass="error"><fmt:message key="welcome.table.username"/></form:label><br/>
					<form:input path="username" />			
				</p>
				<p>	
					<form:label for="password" path="password" cssErrorClass="error"><fmt:message key="welcome.table.password"/></form:label><br/>
					<form:input path="password" />
				</p>
				<p>	
					<button type="submit" class="button positive">
	  					<img src="resources/blueprint/plugins/buttons/icons/tick.png" alt=""/> 
						<fmt:message key="welcome.table.button.login"/>
					</button>

					<a class="button" href="/password/reset/">
					  <img src="resources/blueprint/plugins/buttons/icons/key.png" alt=""/>
					  <fmt:message key="welcome.table.button.forgot"/>
					</a>
				</p>
			</fieldset>
		</form:form>
	</div>
	
		
	<!-- <ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	-->
</div>
</body>
</html>