<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
 	<jsp:attribute name="header">
    <title>My profile</title>
 	</jsp:attribute>
<jsp:body>
		<%@include file="../users_nav.jsp" %>
		<div class="alert alert-failure lead">
	    	${success}
		</div>
		
		<span class="well floatRight">
			Go to <a href="<c:url value='/share' />">My Profile Page</a>
		</span>
</jsp:body>
</t:genericpage>