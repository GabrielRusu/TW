<%@ page import="MySpringMVC.model.MapInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<meta charset="UTF-8">

<html>
<head>
    <title>INepal</title>
    <link rel="stylesheet" type="text/css" href="../../resources/crud.css"/>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>

<div id="header">
    <div class="menu">
        <a href="/#intro">INTRODUCERE</a>
        <a href="/#first">DETALII</a>
        <a href="/#second">APLICATII</a>
        <a href="/#voluntar">FII VOLUNTAR!</a>
        <a href="/#third">FINAL</a>
    </div>
</div>

<div id="main-app">
    <div align="center">
        <section id="intro">
            <div class="article-intro">

                <div id="view">
                    <a href="/viewSimpleTable/1">Tabel</a>
                    <a href="/viewGraph">Grafic</a>
                    <a href="/viewChart">Chart</a>
                    <a href="/viewMap?hazard=-1">Harta</a>
                </div>

                <h3>Harta</h3>
                <h4>In acest mod de vizualizare puteti vedea zonele cele mai afectate</h4>

                <div id="view" style="background: #300000">
                    <a>Gravitatea cutremurului:</a>
                    <a href="/viewMap?hazard=4">Foarte severa</a>
                    <a href="/viewMap?hazard=3">Severa</a>
                    <a href="/viewMap?hazard=2">Mare</a>
                    <a href="/viewMap?hazard=1">Medie</a>
                    <a href="/viewMap?hazard=0">Mica</a>
                </div>

                <div class="container">
                    <div id="map"></div>
                    <script>

                        function initMap() {

                            var pozInit = {lat: 27.700769, lng: 85.300140};
                            var map = new google.maps.Map(document.getElementById('map'), {
                                zoom: 9,
                                center: pozInit
                            });

                            <% ArrayList<MapInfo> posts = (ArrayList<MapInfo>) request.getAttribute("listMapInfo");
                            for (MapInfo post : posts) { %>

                            var poz = {lat: <%=post.getCoord2()%>, lng: <%=post.getCoord1()%>};
                            var name = "<%=post.getName()%>";

                            var marker<%=post.getId()%> = new google.maps.Marker({
                                position: poz,
                                map: map,
                                title: name
                            });

                            <% } %>
                        }
                    </script>
                    <script async defer
                            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABxkncQ2p_Qqgzalrjvb-d-0sOKvlHvJE&callback=initMap">
                    </script>
                </div>

                <p><h4>Puteti exporta chart-ul in format .png sau .jpg</h4></p>

                <div id="view">
                    <a href="">PNG</a>
                    <a href="">JPG</a>
                </div>

            </div>
        </section>
    </div>
</div>

</body>
</html>