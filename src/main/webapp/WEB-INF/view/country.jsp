<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Country View</title>
	<link type="text/css" href="<c:url value='/css/common.css"'/>" rel="stylesheet" >
	<link type="text/css" href="<c:url value='/css/kmltree.css"'/>" rel="stylesheet" media="screen">
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://geojs.googlecode.com/svn/trunk/dist/geo.pack.js"></script>
    <script type="text/javascript" src="http://earth-api-utility-library.googlecode.com/svn/trunk/extensions/dist/extensions.pack.js"></script>
	<script type="text/javascript" src="<c:url value='/js/extensions-0.2.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/geo-0.2.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/kmltree.min.js'/>"></script>
	<script type="text/javascript">
		var ge;
		var gex;
		var geocoder = new google.maps.Geocoder();

		
		google.load("earth", "1", {"other_params":"sensor=false"});
		
		function init() {
			google.earth.createInstance('countryMap', initCB, failureCB);
		} 
		
		function initCB(instance) {
			var pathArray = window.location.pathname.split( '/' );
			//var country = pathArray[4];
			var country = document.getElementById('title').innerHTML;
			ge = instance;
			ge.getWindow().setVisibility(true);
			ge.getLayerRoot().enableLayerById(ge.LAYER_BORDERS, true);
			gex = new GEarthExtensions(ge);
			geocoder.geocode( { 'address': country}, function(results, status) {
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
					var tree = kmltree({
	                    url: 'http://localhost/World/js/includedLayers.kml',
	                    gex: gex, 
	                    mapElement: $('#countryMap'), 
	                    element: $('#tree'),
	                    setExtent: true,
	                    supportItemIcon: true,
	                    restoreState: true
	                });
	                tree.load();
	                enableGoogleLayersControl(tree, ge);
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
		<h1>Country View</h1>
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
					<li><a href="#">Countries</a>
						<c:if test="${!empty countryList}">
							<ul>
								<c:forEach items="${countryList.countries}" var="country">
									<li><a href="/World/continent/country/${country.code}">${country.name}</a></li>
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
				<a href="/World/">Home</a> > <a href="/World/continent/${continentInfo.code}"><c:out value="${continentInfo.name}"/></a> > <c:out value="${countryInfo.name}"/>
			</div>
			<c:if test="${!empty countryInfo}">
				<div id="title">
					<c:out value="${countryInfo.name}"/>
				</div>
				<div id="flag">
					<img alt="${countryInfo.name} Flag" src="${countryInfo.flagLink}"/>
				</div>
				<div id="mapView">
					<div id="countryMap"></div>
					<div id="tree"></div>
				</div>
				<div id="info">
					<div id="topic">
						<div id="left">
							Capital:
						</div>
						<div id="right">
							${countryInfo.capital}
						</div>
						<div id="clear"></div> 
					</div>
					<div id="topic">
						<div id="left">
							Phone Code:
						</div>
						<div id="right">
							${countryInfo.phoneCode}
						</div>
						<div id="clear"></div> 
					</div>
					<div id="topic">
						<div id="left">
							<a href="/World/currency">Currency:</a>
						</div>
						<div id="right">
							${countryInfo.currencyName}
						</div>
						<div id="clear"></div> 
					</div>
					<c:if test="${!empty countryInfo.languages }">
					<c:set var="langList" value="${countryInfo.languages}" scope="page" />
						<div id="topic">
							<div id="left">
								<a href="/World/language">Languages:</a>
							</div>
							<div id="right">
								<ul>
									<c:forEach items="${langList.languages}" var="lang">
										<li>${lang.name}</li>
									</c:forEach>
								</ul>
							</div>
							<div id="clear"></div> 
						</div>
					</c:if>
				</div>
			</c:if>
		</div>		
	</div>
	<footer>
		DataInterfuse 2013
	</footer>
</body>
</html>