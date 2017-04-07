<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:genericpage>
 	<jsp:attribute name="header">
	<title>BikeShare - My profile</title>
 	</jsp:attribute>
<jsp:body>
		<%@include file="../users_nav.jsp" %>
		<div class="container">
		<div class="well lead">My profile</div>
	 	<form:form method="POST" modelAttribute="user" action=""
				class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />	
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">First Name</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName"
								class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="firstName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last Name</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName"
								class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
					<div class="col-md-7">
								<input type="text" id="ssoId" value="${user.ssoId}"
										class="form-control input-sm" disabled/>
								<div class="has-error">
									<form:errors path="ssoId" class="help-inline" />
								</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password"
								class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			

	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<input type="text" id="email"
								class="form-control input-sm" disabled  value="${user.email}"/>
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Mobile Number</label>
					<div class="col-md-7">
						<form:input type="text" path="mobileno" id="mobileno"
								class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
	        
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
					<div class="col-md-7">
						<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="userProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-actions floatRight">
							<input type="submit" value="Update"
									class="btn btn-primary btn-sm" /> or <a
									href="<c:url value='/myprofile' />">Cancel</a>
				</div>
			</div>
			</form:form>
			</div>	
</jsp:body>
</t:genericpage>


