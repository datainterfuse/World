<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Language View</title>
	<link type="text/css" href="<c:url value='/css/common.css"'/>" rel="stylesheet" >
</head>
<body>
	<header>
		<img width="302" height="76" alt="Data Interfuse" src="<c:url value='/images/logo.png'/>"/>
		<h1>Language View</h1>
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
					World Languages
				</div>
			<c:if test="${!empty languageList}">
				<div style="display: inline-block;">
					<table id="box-table-a">
						<thead>
							<tr>
								<th>Name</th><th>Countries</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${languageList.languages}" var="lang">
									<tr>
										<td>${lang.language.name}</td>
										<td>
											<ul>
												<c:forEach items="${lang.countries}" var="country">
													<li>${country.name}</li>
												</c:forEach>
											</ul>
										</td>
									</tr>
							</c:forEach>
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