<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
 	<jsp:attribute name="header">
	<title>BikeShare - Add Bike</title>
 	</jsp:attribute>
<jsp:body>


		            <div class="col-lg-12">
				Go Back to <a class="btn btn-primary" href="<c:url value='/share' />">Share Page</a>
				<br/>
				<br/>
                <div class="panel panel-info">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Bike - Details</div>
                    <div class="panel-body">
                        <p>Selected Bike Details</p>
                    </div>
                    <!-- Table -->
                    <table class="table table-striped table-bordered">
                        <thead><tr>
                                <th scope="col">Model Name</th>
                                <th scope="col">Type</th>
                                <th scope="col">Condition</th>
                                <th scope="col">Comments</th>
                            </tr></thead>
                        <tr>
                        
                            <td>${bikedetail.modelname}</td>
                            <td>${bikedetail.type}</td>
                            <td>${bikedetail.conditionstatus}</td>
                            <td>${bikedetail.comments}</td>
                        
                        </tr>
                    </table>
                    <br/>
                </div>
            </div>
		
		<div class="col-lg-12">
                <div class="panel panel-info">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Sharing Date Slots</div>

                    <form:form method="POST" class="form-horizontal">
                    <div class="panel-body">
                        <p>
                            <a type="button" class="btn btn-success" href="<c:url value='/sharebike/bike-${bikeid}/sharedate/add' />">Add Share Date</a>
                            <br/>
                            Note: Booked date slots cannot be deleted.
                            <br/>
                            Info: All older Bookings are listed in HISTORY page.
                        </p>
                    </div>
                    <!-- Table -->
                    
                    <table class="table table-striped table-bordered">
                        <thead><tr>
                                <th scope="col">Shared date</th>
                                <th scope="col">Notes</th>
                                <th scope="col">Booking Status</th>
                                <th scope="col">Booked By</th>
                                <th scope="col">Delete</th>
                            </tr></thead>
                        
                        <c:forEach items="${shareddates}" var="shbdate">
                        <tr>
                            <td>${shbdate.share_date}</td>
                            <td>${shbdate.notes}</td>
                            <td>${shbdate.bookingstatus}</td>    
                    <c:choose>
					<c:when test="${shbdate.booked_by == 0}">
						<td>None</td>
						 <td><a type="submit" class="btn btn-danger" href="<c:url value='/sharebike/bike-${bikeid}/sharedate/sh-${shbdate.id}/delete' />">Delete</a></td>
                    </c:when>
					<c:otherwise>
					<td>Registered User</td>
					<td>Cannot Delete</td>
                    </c:otherwise>
					</c:choose>
					 </tr>
                        </c:forEach>
                        
                    </table>
                    </form:form>
                   </div>
            </div>

</jsp:body>
</t:genericpage>


