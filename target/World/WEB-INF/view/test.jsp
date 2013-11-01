<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8">
        <title>Simple Example</title>
        <script src="http://www.google.com/jsapi"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <!-- earth-api-utility-library dependencies -->
        <script src="http://geojs.googlecode.com/svn/trunk/dist/geo.pack.js"></script>
        <script src="http://earth-api-utility-library.googlecode.com/svn/trunk/extensions/dist/extensions.pack.js">
        </script>
        <!-- kmltree source files -->
        <link type="text/css" href="<c:url value='/css/kmltree.css"'/>" rel="stylesheet" media="screen">
        <script type="text/javascript" src="<c:url value='/js/kmltree.min.js'/>"></script>
        
        <script>
            google.load("earth", "1");
            
            function init() {
                google.earth.createInstance('map3d', initCB, failureCB);
            }

            function initCB(instance) {
                ge = instance;
                ge.getWindow().setVisibility(true);
                
                var gex = gex = new GEarthExtensions(ge);
                
                var tree = kmltree({
                    url: 'http://localhost/World/js/includedLayers.kml',
                    gex: gex, 
                    mapElement: $('#map3d'), 
                    element: $('#tree'),
                    setExtent: true,
                    supportItemIcon: true,
                    restoreState: true
                });
                
                tree.load();
                var kml = kmltree({
                    url: '<c:out value="${kmlUrl}" />',
                    gex: gex, 
                    mapElement: $('#map3d'), 
                    element: $('#tree'),
                    setExtent: true,
                    supportItemIcon: true,
                    restoreState: true
                });
                
                tree.load();
                kml.load();
                enableGoogleLayersControl(tree, ge);
                enableGoogleLayersControl(kml, ge);
            }

            function failureCB(errorCode) {
                alert('failed to load plugin');
            }
            

            $(document).ready(init);
            
        </script>
    </head>
    <body>
        <div id="tree" style="float:left; width:300px; height: 400px;"></div>
        <div id="map3d" style="float:left; height: 400px; width: 600px;"></div>
    </body>
</html>