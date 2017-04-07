<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
 	<jsp:attribute name="header">
    <title>BikShare</title>
 	</jsp:attribute>
<jsp:body>
<div class="container">
<div class="jumbotron">
        <h1>Bike Share!</h1>
        <p class="lead">Earn Credits for Every share as well as for Each ride</p>
        <p><a class="btn btn-lg btn-success" href="<c:url value='/login'/>" role="button">Get started today</a></p>
      </div>
      </div>
</jsp:body>
</t:genericpage>