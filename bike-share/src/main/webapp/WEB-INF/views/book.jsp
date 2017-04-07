<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:genericpage>
	<jsp:attribute name="header">
    <title>Book a Bike</title>
 	</jsp:attribute>
	<jsp:body>
		<%@include file="users_nav.jsp"%>

		<br>
		<div class="col-lg-12">
		<div class="panel panel-danger">
		<!-- Default panel contents -->
		<div class="panel-heading">Current bookings</div>
        <div class="panel-body">
		<p>The bikes currently booked by you.</p>
		</div>
		<table class="table table-striped table-bordered">
					<thead>
					<tr>
					<th>Model Name</th>
					<th>Type</th>
					<th>Shared Date</th>
					<th>Booked Date</th>
					<th>Status</th>
					<th>Shared Person Name:</th>
					<th>Shared Person Contact Number:</th>
					<th>Ride Ack</th>
					</tr>
					</thead>
						<tbody>
						<c:forEach items="${currentbooked}" var="cb">
						<tr>
						<td>${cb.modelname}</td>
						<td>${cb.type}</td>
						<td>${cb.share_date}</td>
						<td>${cb.booked_date}</td>
						<td>${cb.bookingstatus}</td>
						<td>${cb.firstname}</td>
						<td>${cb.mobileNo}</td>
						<th><a type="submit" onclick="if (! confirm('Make sure, you have ride the bike on shared date. Because, if acknowledge before share date. you wont get credited.')) return false" class="btn btn-success" href="<c:url value='/bookbike/bike-${cb.bk_id}/ridedone-${cb.share_book_id}' />">Ride Done</a>
						</th>
						</tr>
						</c:forEach>
						</tbody>
         </table>
		
		                 <br />
                        </div>
                    </div> 
                            <form:form method="POST" modelAttribute="bikes" class="form-horizontal">
                        <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <!-- Default panel contents -->
                            <div class="panel-heading">Book a Bike</div>
                            <div class="panel-body">
					        <p>Bikes available for booking</p>
                            </div>
							<table class="table table-striped table-bordered">
							<thead>
							<tr>
							<th>Model Name</th>
							<th>Type</th>
							<th>Condition</th>
							<th>Comment</th>
							<th>Shared Person Name:</th>
							<th>Available Date slots( View / Book )</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${bookablebikes}" var="bike">
							<tr>
							<td>${bike.modelname}</td>
							<td>${bike.type}</td>
							<td>${bike.conditionstatus}</td>
							<td>${bike.comments}</td>
							<td>${bike.bikeowner}</td>
							<td>
								<a type="button" class="btn btn-success" href="<c:url value='/bookbike/bike-${bike.bk_id}'/>">View and Book a Date</a>
                            </td>
							</tr>
							</c:forEach>
							</tbody>
							</table>
                        <br />

                        </div>
                        </div>
                        </form:form>

		
</jsp:body>
</t:genericpage>