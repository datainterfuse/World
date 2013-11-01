xquery version "1.0-ml";
declare namespace x="http://www.opengis.net/kml/2.2";
let $pins := cts:search(/x:kml/x:Document, cts:element-query(xs:QName("x:Placemark"), cts:and-query(())))
for $pin in $pins
where fn:exists($pin/x:Placemark)
return
<result>
{$pin/x:Placemark}
</result>
