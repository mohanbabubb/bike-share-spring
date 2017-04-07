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
		<div class="col-md-6"><br/>
					Go Back to <a class="btn btn-info" href="<c:url value='/book' />">Booking Page</a>
                        <br/>
                        <br/>
                        <div class="panel panel-primary">  
                   <!-- Default panel contents -->
                    <div class="panel-heading">Available dates</div>
                    <div class="panel-body">
                        <p>Book a bike on available shared dates below </p>
                    </div>
			                     <table class="table table-striped table-bordered">
			                        <thead><tr>
			                                <th scope="col">Shared date</th>
			                                <th scope="col">Notes</th>
			                                <th scope="col">Booking Status</th>
			                                <th scope="col">Boot it</th>
			                            </tr></thead>
			                        <tr>
			                        <c:forEach items="${shareddates}" var="shareddate">
			                            <td>${shareddate.shareddate}</td>
			                            <td>${shareddate.notes}</td>
			                            <td>${shareddate.bookingstatus}</td>
			                            <td><a type="submit" onclick="if (! confirm('Once Booked slot cannot be reverted/release? Press OK, if sure.')) return false" class="btn btn-default" href="<c:url value='/bookbike/book/confirm' />">Book IT</a></td>
			                        </c:forEach>
			                        </tr>
			                    </table>
                            
                        </div>
                    </div>
		

</jsp:body>
</t:genericpage>


