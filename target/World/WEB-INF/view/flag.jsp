<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Flag View</title>
	<link type="text/css" href="<c:url value='/css/common.css"'/>" rel="stylesheet" >
</head>
<body>
	<header>
		<img width="302" height="76" alt="Data Interfuse" src="<c:url value='/images/logo.png'/>"/>
		<h1>World Flags</h1>
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
			<div id="title">
					World Flags
				</div>
			<c:if test="${!empty flagList}">
				<div style="display: inline-block;">
					<table>
						<tbody>
							<tr>
							<c:set var="theCount" value="0"/>
							<c:forEach items="${flagList}" var="flag" >
								<c:set var="theCount" value="${theCount + 1}" />    
									<td>
										<div>
											<img alt="Flag" height="80px" width="150px" src="${flag.link}">
											${flag.name}
										</div>
									</td>
									<c:if test="${theCount == '7'}">
										<c:set var="theCount" value="0"/>
										</tr>
										<tr>
									</c:if>
							</c:forEach>
							</tr>
						</tbody>
					</table>	
				</div>
			</c:if>
		</div>		
	</div>
	<footer>
		DataInterfuse 2013
	</footer>
</body>
</html>