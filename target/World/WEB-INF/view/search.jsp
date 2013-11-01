<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search View</title>
	<link type="text/css" href="<c:url value='/css/common.css"'/>" rel="stylesheet" >
	<script type="text/javascript">
		function searchClick() {
			var searchValue = document.getElementById('txtSearch').value
			window.location.href ="/World/search/" + searchValue;
		}
	</script>
</head>
<body>
	<header>
		<img width="302" height="76" alt="Data Interfuse" src="<c:url value='/images/logo.png'/>"/>
		<h1>Search</h1>
		<div>
			<nav>
				<ul>
					<li><a href="/World/">Home</a></li>
					<li><a href="/World/continent">Continents</a>
						<c:if test="${!empty continentList}">
							<ul>
								<c:forEach items="${continentList.continents}" var="conts">
									<li><a href="/World/continent/${conts.continent.code}">${conts.continent.name}</a></li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</ul>
			</nav>
		</div>
	</header>
	<div id="content">
		<div id="ListBody">
			<div id="mainBar">
				<a href="/World/">Home</a>
			</div>
			<div id="title">Search</div>
			<div>
				<c:if test="${empty value}"><c:set var="value" value=""/></c:if>
				<input type="text" name="txtSearch" id="txtSearch" value="${value}">
				<input type="button" value="Search" onclick="searchClick()">
			</div>
			<div>
				<c:if test="${!empty searchResults}">
					<c:forEach items="${searchResults}" var="match">
						<div>
							<div id="mainBar">
								<c:out value="Matched results in ${match.uri }:"/>
							</div>
							<c:if test="${!empty match.locations}">
								<c:forEach items="${match.locations}" var="loc">
									<c:if test="${!empty loc.snippets}">
										<div id="topic">
											<c:forEach items="${loc.snippets}" var="snippet">
												
													<c:if test="${snippet.highlight}">
														<b>
													</c:if>
														${snippet.text}
													<c:if test="${snippet.highlight}">
														</b>
													</c:if>
												
											</c:forEach>
									    </div>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
					</c:forEach>
				</c:if>
			</div>	
		</div>		
	</div>
	<footer>
		DataInterfuse 2013
	</footer>
</body>
</html>