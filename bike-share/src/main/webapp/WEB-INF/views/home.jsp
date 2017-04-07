<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
    <title>Home</title>
 	</jsp:attribute>
	<jsp:body>
		<%@include file="authheader.jsp"%>
		<%@include file="users_nav.jsp"%>
		<br />
			
			 <br />
			 <div class="col-lg-4">
			 <div class="panel panel-default">
			         <!-- Default panel contents -->
			<div class="panel-heading">
						<h4>Shared bikes</h4>
					</div>
			<div class="panel-body">
 
            <button class="btn btn-primary" type="button">
				<h2>Bikes Shared:<span class="label label-default">${bikeshared}</span>
								</h2>
            </button>
		    </div>
			    </div>
			</div>
			
			 <div class="col-lg-4">
			 <div class="panel panel-default">
			         <!-- Default panel contents -->
			<div class="panel-heading">
						<h4>Bikes Booked</h4>
					</div>
			<div class="panel-body">
 
            <button class="btn btn-primary" type="button">
							<h2>Bikes Booked: <span class="label label-default">${bikebooked}</span>
								</h2>
            </button>
		    </div>
			    </div>
			</div>

			 <div class="col-lg-4">
			 <div class="panel panel-default">
			         <!-- Default panel contents -->
			<div class="panel-heading">
						<h4>Rides:</h4>
					</div>
			<div class="panel-body">
 
            <button class="btn btn-primary" type="button">
			<h2>Bikes Rided: <span class="label label-default">${bikesrided}</span>
			</h2>
            </button>
		    </div>
			    </div>
			</div>



			 <div class="col-lg-4">
			 <div class="panel panel-default">
			         <!-- Default panel contents -->
			<div class="panel-heading">
						<h4>Credits</h4>
					</div>
			<div class="panel-body">
 
            <button class="btn btn-primary" type="button">
			<h2>Credits Earned: <span class="label label-default">${creditearned}</span>
			</h2>
            </button>
		    </div>
			    </div>
			</div>

	</jsp:body>
</t:genericpage>