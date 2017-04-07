<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>


<t:genericpage>
	<jsp:attribute name="header">
	<title>BikeShare - Share Bike</title>
 	</jsp:attribute>
	<jsp:body>
   		<%@include file="users_nav.jsp"%>
        
            <div class="container">
           <br/>

               <div class="col-lg-12">
                    <div class="panel panel-primary">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Share My Bikes</div>
                    <div class="panel-body">
                        <a type="button" class="btn btn-success" href="<c:url value='/sharebike/addbike' />">Add Bike</a>
                    </div>
    
					<table class="table table-striped table-bordered">
					<thead>
					<tr>
					<th>Model Name</th>
					<th>Type</th>
					<th>Condition</th>
					<th>Comment</th>
					<th>Start Sharing</th>
					<th>Stop Sharing</th>
					<th>Delete</th>
					<th>Sharing Date slots<br />(Add / View / Delete )</th>
					</tr>
					</thead>
						<tbody>
						<c:forEach items="${bikes}" var="bike">
						<tr>
						<td>${bike.modelname}</td>
						<td>${bike.type}</td>
						<td>${bike.conditionstatus}</td>
						<td>${bike.comments}</td>
					 <c:choose>
					 <c:when test="${bike.sharestatus == 'off'}">
					<td><a type="button" class="btn btn-success" href="<c:url value='/sharebike/start-${bike.id}' />">Start Sharing</a>
                    </td>
					</c:when>
					<c:otherwise>
                    <td><a type="button" class="btn btn-success disabled" href="<c:url value='/sharebike/start-${bike.id}' />">Start Sharing</a>
                    </td>
					 </c:otherwise>
					</c:choose>
					<c:choose>
					 <c:when test="${bike.sharestatus == 'on'}">
						<td><a type="button" class="btn btn-warning" href="<c:url value='/sharebike/stop-${bike.id}' />">Stop Sharing</a>
                    </td>
                    </c:when>
					<c:otherwise>
					<td><a type="button" class="btn btn-warning disabled" href="<c:url value='/sharebike/stop-${bike.id}' />">Stop Sharing</a>
                    </td>
                    </c:otherwise>
					</c:choose>
						<td><a type="button" class="btn btn-danger" href="<c:url value='/sharebike/delete-${bike.id}' />">Delete</a>
                    </td>
						<td><a type="button" class="btn btn-info" href="<c:url value='/sharebike/sharedate' />">Add/View/Delete Dates</a>
                    </td>
						</tr>
						</c:forEach>
						</tbody>
                    </table>

                    <br />
                    </div>
                </div>

            </div>                 
            <br />

</jsp:body>
</t:genericpage>
