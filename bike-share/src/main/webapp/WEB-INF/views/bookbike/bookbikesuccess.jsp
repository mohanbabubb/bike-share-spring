<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
 	<jsp:attribute name="header">
	<title>BikeShare - Book a Bike</title>
 	</jsp:attribute>
<jsp:body>
		<%@include file="../users_nav.jsp" %>
		<div class="alert alert-success lead">
	    	Booed Successfully.
		</div>
		
		<span class="well floatRight">
			Go to <a href="<c:url value='/bookbike/bike-${rbikeid}' />">Back to Booking Page</a>
		</span>

</jsp:body>
</t:genericpage>


