	<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page session="false" %>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="page.title"/></title>
<link href="res/bootstrap-3.2.0/css/bootstrap.costum.css" type="text/css" rel="stylesheet">
<link href="res/bootstrap-3.2.0/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet">
<link href="res/css/fontstyle.css" type="text/css" rel="stylesheet">
<link href="res/css/custom.css" type="text/css" rel="stylesheet"> 
</head>
<body>

	${locVar}
	Hier soll die Auswertung stehen: 
	<c:forEach items="${stringCheck}" var="entry">
    	Key = ${entry.key}, value = ${entry.value}<br>
	</c:forEach>  Ende der Auswertung


<!-- Scripte -->
<script defer src="res/js/jquery-1.11.1.min.js" type="text/javascript"></script>    
<script defer src="res/bootstrap-3.2.0/js/bootstrap.min.js" type="text/javascript"></script>
<script defer src="res/js/bootstrap-dialog.min.js" type="text/javascript"></script>
<script defer src="res/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script defer src="res/js/custom.js" type="text/javascript"></script>  
</body>
</html>	