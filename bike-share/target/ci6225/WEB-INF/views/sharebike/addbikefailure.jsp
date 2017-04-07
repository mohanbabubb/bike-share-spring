<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
 	<jsp:attribute name="header">
	<title>BikeShare - Add Bike</title>
 	</jsp:attribute>
<jsp:body>


		<div class="alert alert-failure lead">
	    	${success}
		</div>
		
		<span class="well floatRight">
			Go to <a href="<c:url value='/share' />">Share Page</a>
		</span>

</jsp:body>
</t:genericpage>


