<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
 	<jsp:attribute name="header">
	<title>BikeShare - Add Bike</title>
 	</jsp:attribute>
<jsp:body>
				<%@include file="../users_nav.jsp" %>	
       <script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("modelname");
                var b = document.getElementById("type");
var c = document.getElementById("conditionstatus");
var d = document.getElementById("comments");
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0 || c.value.length<=0 || d.value.length<=0)
                    {
                        alert("Don't leave the field empty!");
                        valid = false;
                    }
                return valid;
            };

        </script>
					<h2>Add Bike:</h2>
			        <form:form method="POST" modelAttribute="bikes" class="form-horizontal" action="${loginUrl}" onsubmit="return validate();">
			           <div class="container">
			               <div class="row">
			               <div class="col-md-6">Model Name:
			       		<form:input type="text" path="modelname" id="modelname" placeholder="Merida,Trek"
										class="input-sm" />
			</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">Bike Type:
			       		<form:input type="text" path="type" id="type" placeholder="Folding,BmX,Mountain"
										class="input-sm" />
			</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">Condition:
			       		<form:input type="text" path="conditionstatus" placeholder="Good,Bad,Average"
										id="conditionstatus" class="input-sm" />
			</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">Comments:
			       		<form:input type="text" path="comments" id="comments" placeholder="Number Lock, Cable Lock, U-Lock"
										class="input-sm" />
			</div>
			               </div>
			               <div class="row">
			               <div class="col-md-6">

			               <input type="submit" value="Add bike" class="btn btn-primary btn-sm" />
			               <a type="button" class="btn btn-danger" href="<c:url value='/share' />">Back</a>
			               </div>
			               </div>
			           </div>
			          </form:form>

</jsp:body>
</t:genericpage>
