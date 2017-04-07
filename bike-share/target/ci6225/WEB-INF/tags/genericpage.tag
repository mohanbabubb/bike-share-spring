<%@tag description="Bike Share-Template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/justified-nav.css' />"
	rel="stylesheet"></link>
	  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<div id="pageheader">
	<jsp:invoke fragment="header" />
</div>
</head>
<body>
	<div class="container">
		<div class="header clearfix">
				<h3>Bike Share</h3>
			<div class="masthead">
				<nav>
					<ul class="nav nav-justified">
						<li class="active"><a href="<c:url value='/login' />">Home</a></li>
						<li><a href="<c:url value='/newuser' />">Register</a></li>
						<li><a href="<c:url value="/logout" />">Logout</a></li>
						<li><a href="<c:url value='/aboutus' />">AboutUs</a></li>
					</ul>
				</nav>
				<div id="body">
					<br /> <br />
					<jsp:doBody />
				</div>
			</div>
		</div>
	</div>
</body>
</html>