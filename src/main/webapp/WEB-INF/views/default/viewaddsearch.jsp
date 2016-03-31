<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Webcrawler parameter form</title>
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
			<a href="${localisationVariable}/${profileVariable}/searchinput"><h1><font color="red"><spring:message code="colum.back"></spring:message></font></h1></a>
			<br><br>
			<spring:message code="legend.legend"></spring:message>
			<div class="btn btn-success"><spring:message  code="legend.green"></spring:message></div>
			<div class="btn btn-danger"><spring:message  code="legend.red"></spring:message></div> 
	    </header>				
	</div> 

    <div align="center">
        <form:form action="searchinput" method="post" commandName="dataInput">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Webcrawler Parameter </h2></td>
                </tr>
                <tr>
                    <td>Datainput searchterm:</td>
                    <td><form:input path="searchTerm" /></td>
                </tr>
                <tr>
                    <td>Datainput search Url:</td>
                    <td><form:input path="urlToCheck" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="start" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>