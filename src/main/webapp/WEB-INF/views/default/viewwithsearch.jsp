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

	<div class="container">		
	    <header>
	        <h3 class="pull-left">Webcrawler parameter form</h3>
	        <figure class="pull-right">
	            <img src="res/images/logo.png">
	        </figure>
	        <div class="clearfix"></div>
	        <br> 
			<a href="${localisationVariable}/${profileVariable}/searchinput"><h1><font color="blue"><spring:message code="colum.back"></spring:message></font></h1></a>
			<br><br>
			<spring:message code="legend.legend"></spring:message>
			<div class="btn btn-success"><spring:message  code="legend.green"></spring:message></div>
			<div class="btn btn-danger"><spring:message  code="legend.red"></spring:message></div> 
	    </header>				
	</div> 
		
	  <table cellspacing="0">
    <thead>
      <tr>
      	<th><spring:message code="column.key"/></th>
        <th><spring:message code="column.searchterm"/></th>
        <th><spring:message code="column.searchterminformation"/></th>
        <th><spring:message code="column.searchtermamount"/></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${crawlingDataMap}" var="entry">
        <tr>     
          <td data-label="<spring:message code="column.table.key"/>">
	          <c:if test="${not empty entry.key}">
	            ${entry.key}
	          </c:if>
          </td>
          
          <td data-label="<spring:message code="column.table.searchterm"/>">
	            ${entry.value.getSearchTerm()}
          </td>
                    
           <c:choose>
            <c:when test="${entry.value.getInformationAboutSearchTerm() == false}">
              <td data-label="<spring:message code="column.false"/>">
              <div class="btn btn-danger"><spring:message code="colum.code.red"/></div>
            </c:when>
            <c:otherwise>
              <td data-label="<spring:message code="column.true"/>" >
              <div class="btn btn-success"><spring:message code="colum.code.ok"/></div>
            </c:otherwise>
          </c:choose>
          
          <td data-label="<spring:message code="column.table.searchtermamount"/>">
	          <c:if test="${not empty entry.value.getInformationAboutSearchTermAmount()}">
	           ${entry.value.getInformationAboutSearchTermAmount()}
	          </c:if>
          </td>            
        </tr>
      </c:forEach>
    </tbody>
  </table>


<!-- Scripte -->
<script defer src="res/js/jquery-1.11.1.min.js" type="text/javascript"></script>    
<script defer src="res/bootstrap-3.2.0/js/bootstrap.min.js" type="text/javascript"></script>
<script defer src="res/js/bootstrap-dialog.min.js" type="text/javascript"></script>
<script defer src="res/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script defer src="res/js/custom.js" type="text/javascript"></script>  
</body>
</html>	