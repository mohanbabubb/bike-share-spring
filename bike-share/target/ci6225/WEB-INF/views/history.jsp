<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
 	<jsp:attribute name="header">
    <title>History</title>
 	</jsp:attribute>
<jsp:body>
		<%@include file="users_nav.jsp" %>
		
		
		                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Booking History</div>
                        <div class="panel-body">
                            <p>Bikes booked by you. Bookings which crossed the shared date will be listed here.</p>
                            <br/>
                            <p>Count's Here may differ from Dashboard. Dashboard calculates only the rides acknowledged after use ( after share date).</p>
                        </div>
					<table class="table table-striped table-bordered">
					<thead>
					<tr>
					<th>Booked Date</th>
					<th>Model Name</th>
					<th>Shared Date</th>
					<th>Shared By</th>
					</tr>
					</thead>
						<tbody>
						<c:forEach items="${bikes}" var="bike">
						<tr>
						<td>${bike.booked_date}</td>
						<td>${bike.modelname}</td>
						<td>${bike.sharedate}</td>
						<td>${bike.shared_by}</td>
						</tr>
						</c:forEach>
						</tbody>
        			 </table>

                        <br/>
                    </div>
                </div>
</jsp:body>
</t:genericpage>