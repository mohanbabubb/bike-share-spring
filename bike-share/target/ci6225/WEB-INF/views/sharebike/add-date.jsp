<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
 	<jsp:attribute name="header">
	<title>BikeShare - Add Share Date</title>
 	</jsp:attribute>
<jsp:body>
  <script>
  $( function() {
    $( "#shareddate" ).datepicker();
  } );
  </script>
				<%@include file="../users_nav.jsp" %>	
		<span class="well floatRight">
			Go to <a href="<c:url value='/share' />">Share Page</a>
		</span>
					<h2>Add Bike:</h2>
			        <form:form method="POST" modelAttribute="user" class="form-horizontal" action="/sharebike/sharedate/add">
			           <div class="container">
			               <div class="row">
			               <div class="col-md-6">Bike Name:
			       		<input type="text" id="modelname" placeholder="Merida,Trek"
										class="input-sm" />
							</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">Sharing Date:
			       		<input type="text" id="shareddate" placeholder="04/11/1988"
										class="input-sm" />
							</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">Notes:
			       		<input type="text" placeholder="Good,Bad,Average"
										id="conditionstatus" class="input-sm" />
							</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">
			               <input type="submit" value="Add bike" class="btn btn-primary btn-sm" />
			               <a type="button" class="btn btn-danger" href="<c:url value='/sharebike/sharedate' />">Back</a>
			               </div>
			               </div>
			           </div>
			          </form:form>

</jsp:body>
</t:genericpage>
