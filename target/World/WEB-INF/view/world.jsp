<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>World View</title>
	<link type="text/css" href="<c:url value='/css/common.css'/>" rel="stylesheet" >
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<script type="text/javascript" src="<c:url value='/js/extensions-0.2.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/geo-0.2.js'/>"></script>
	<script type="text/javascript">
		var ge;
		var gex;
		var geocoder = new google.maps.Geocoder();

		
		google.load("earth", "1", {"other_params":"sensor=false"});
		
		function init() {
			google.earth.createInstance('map', initCB, failureCB);
		} 
		
		function initCB(instance) {
			ge = instance;
			ge.getWindow().setVisibility(true);
			ge.getLayerRoot().enableLayerById(ge.LAYER_BORDERS, true);
			gex = new GEarthExtensions(instance);
			geocoder.geocode( { 'address': 'USA'}, function(results, status) {
			    if (status == google.maps.GeocoderStatus.OK) {
			    	var ne = results[0].geometry.viewport.getNorthEast();
			    	var nelat = ne.lat();
			    	var nelo = ne.lng();
			    	var sw = results[0].geometry.viewport.getSouthWest();
			    	var swlat = sw.lat();
			    	var swlo = sw.lng();
			    	gex.dom.clearFeatures();
					var folder = gex.dom.addFolder([
		               gex.dom.buildPointPlacemark([swlat, swlo]),
		               gex.dom.buildPointPlacemark([nelat, nelo])
		             ]);
					var bounds = gex.dom.computeBounds(folder);
					gex.view.setToBoundsView(bounds, { aspectRatio: 1.0 });
			    } else {
			      alert('Geocode was not successful for the following reason: ' + status);
			    }
			 });
		}
		
		function failureCB(instance) {
			
		}

		
		google.setOnLoadCallback(init);
	</script>
</head>
<body>
	<header>
		<img width="302" height="76" alt="Data Interfuse" src="<c:url value='/images/logo.png'/>"/>
		<h1>World View</h1>
		<div style="padding: 0; margin: 0">
			<nav>
				<ul>
					<li><a href="/World/">Home</a></li>
					<li><a href="#">Continents</a>
						<c:if test="${!empty continentList}">
							<ul>
								<c:forEach items="${continentList.continents}" var="conts">
									<li><a href="continent/${conts.continent.code}">${conts.continent.name}</a></li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</ul>
			</nav>
		</div>
	</header>
	<div id="content">
		<div id="mainBody">
			<div id="mainBar">
				Welcome!
			</div>
			<div id="welcome">
				<p>
					Welcome to the World View.  This application provides a brief view of the Continents and Countries of the world.
					This information contains names, flags, currencies, capitals and languages.
				</p>
			</div>
			<div id="mapView">
				<div id="map"></div>
			</div>
			<div id="clear" ></div>
			<div id="left">
				<table id="box-table-b">
					<tr>
						<td><a href="flag">Flags of the World</a></td>
					</tr>
				</table>
			</div>
			<div id="clear" ></div>
		</div>
	</div>
	<footer>
		DataInterfuse 2013
	</footer>
</body>
</html>