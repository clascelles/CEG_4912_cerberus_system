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
	<title><fmt:message key="overview.title"/></title>
	
	<!-- Import CSS Links Here -->
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/plugins/buttons/screen.css" />" type="text/css" media="screen">
	
</head>

<body>
<div class="container">
	<h1><fmt:message key="overview.title"/></h1>
	<div class="span-12 last">	
		
	</div>
	
		
	<!-- <ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	-->
</div>
</body>
</html>