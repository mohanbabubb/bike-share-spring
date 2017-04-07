<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
 	<jsp:attribute name="header">
		<title>Users List</title>
 	</jsp:attribute>
<jsp:body>
	<c:choose>
		<c:when test="${status}">
		<div class="alert alert-success lead">
	    	${success}
		</div>
		</c:when>
	</c:choose>
				<%@include file="../users_nav.jsp" %>
				<br/>
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">My Profile </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Firstname</th>
				        <th>Lastname</th>
				        <th>Email</th>
				        <th>SSO ID</th>
				        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('ADMIN')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
					<tr>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.ssoId}</td>
					    <sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/myprofile/edit-${user.id}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
					</tr>
	    		</tbody>
	    	</table>
		</div>
</jsp:body>
</t:genericpage>