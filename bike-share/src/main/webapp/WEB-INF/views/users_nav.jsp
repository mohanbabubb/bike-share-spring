<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
                <ul class="nav nav-tabs">
                <li role="presentation"><a href="<c:url value="/home" />">Dashboard</a></li>
                <li role="presentation"><a href="<c:url value="/share" />">Share a Bike</a></li>
                <li role="presentation"><a href="<c:url value="/book" />">Book a Bike</a></li>
                <li role="presentation"><a href="<c:url value="/history" />">History</a></li>
                <li role="presentation"><a href="<c:url value="/myprofile" />">My profile</a></li>
                <sec:authorize access="hasRole('ADMIN')">
                <li role="presentation"><a href="<c:url value="/list" />">Users List</a></li>
                </sec:authorize>
				</ul>
