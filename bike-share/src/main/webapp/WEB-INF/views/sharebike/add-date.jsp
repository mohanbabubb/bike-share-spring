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
    $( "#share_date" ).datepicker();
  }   
  );
  
  function validate() {
	  var d1=document.form-add-date.share_date.value;
	  var d2=document.form-add-date.notes.value;
	  
	  if (d1.length==0 || d2.length==0){
		  alert("Fields Cannot be Empty");  
		  return false;  
	  }else
		  {
		  return true;
		  }
  }
  </script>
				<%@include file="../users_nav.jsp" %>	
					<h2>Add Share Date:</h2>
			        <form:form method="POST" modelAttribute="shbs" class="form-horizontal" action="${pageContext.request.contextPath}/sharebike/bike-${bikeid}/sharedate/add" onsubmit="return validate();">
			           <div class="container">
			               <div class="row">
			               <div class="col-md-6">Sharing Date:
			       		<form:input path="share_date" id="share_date" placeholder="04/11/1988" class="input-sm" />
							</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">Notes:
			       		<form:input placeholder="Can Self pickup from my location." path="notes" id="notes" class="input-sm" />
							</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">
			               <input type="submit" value="Add bike" class="btn btn-primary btn-sm" />
			               </div>
			               </div>
			           </div>
			          </form:form>
			          <br/>
			          <a type="button" class="btn btn-danger" href="<c:url value='/sharebike/bike-${bikeid}/sharedate' />">Back</a>

</jsp:body>
</t:genericpage>
