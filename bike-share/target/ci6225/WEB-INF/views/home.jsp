<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
 	<jsp:attribute name="header">
    <title>Home</title>
 	</jsp:attribute>
<jsp:body>
		<%@include file="authheader.jsp" %>
		<%@include file="users_nav.jsp" %>
		<br/>
		<table class="table">
		<tr>
		<td>
		<h4>Bikes Shared:<span class="label label-default">New</span></h4>
		</td>
		<td>
		<h4>Bikes Booked: <span class="label label-default">New</span></h4>
		</td>
		<td>
		<h4>Bikes Rided: <span class="label label-default">New</span></h4>
		</td>
		<td>
		<h4>Credits Earned: <span class="label label-default">New</span></h4>
		</td>
		<tr>
		</table>
</jsp:body>
</t:genericpage>