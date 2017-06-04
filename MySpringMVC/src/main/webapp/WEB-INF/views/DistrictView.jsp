<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.District" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<meta charset="UTF-8">

<html>
<head>
    <title>INepal</title>
    <link rel="stylesheet" type="text/css" href="../../resources/style.css"/>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="../../resources/js/sidebar.js"></script>
    <script src="../../resources/js/charts.js"></script>
</head>
<body>

<div id="header">
    <div class="menu">
        <!--<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>-->
        <a href="/home#intro">INTRODUCERE</a>
        <a href="/home#first">DETALII</a>
        <a href="/home#second">APLICATII</a>
        <a href="/home#voluntar">FII VOLUNTAR!</a>
        <a href="/home#third">FINAL</a>
    </div>
</div>

<div id="main-app">

    <div id="view">
        <a href="table.html">Tabel</a>
        <a href="graphic.html">Grafic</a>
        <a href="chart.html">Chart</a>
        <a href="map.html">Harta</a>
    </div>

    <section id="intro">
        <div class="article-intro">

            <div align="center">
                <h1>New/Edit district</h1>
                <form action="saveDistrict" method="post" modelAttribute="district">
                    <table>
                        <hidden path="id"/>
                        <tr>
                            <td>Name:</td>
                            <td><input path="name"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" value="Save"></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div align="center">
                <h1>District List</h1>
                <h4><a href="/newDistrict">New District</a></h4>
                <div class="article">
                    <table>
                        <th><h4>ID</h4></th>
                        <th><h4>Name</h4></th>
                        <th><h4>Edit or Delete</h4></th>

                        </th>
                        <%
                            ArrayList<District> posts = (ArrayList<District>) request.getAttribute("listDistrict");
                        %>
                        <%
                            for (District post : posts) {
                        %>
                        <tr>
                            <td><h5><%=post.getId()%>
                            </h5>
                            </td>
                            <td><h5><%=post.getName()%>
                            </h5>
                            </td>
                            <td>
                                <a href="/editContact?id=<%=post.getId()%>"><h5>Edit</h5></a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/deleteContact?id=<%=post.getId()%>"><h5>Delete</h5></a>
                            </td>
                        </tr>
                        <%}%>
                    </table>

                </div>

            </div>

            <h3>Table</h3>
            <p>
            <h2>Sunteti la modul de vizualizare tabel</h2></p>
            <p>
            <h2>Aici puteti alege din ce categorie doriti sa afisati si puteti filtra informatiile sau alege coloanele
                separat pentru afisare</h2></p>
            <p>
            <h2>Puteti exporta chart-ul in format .png, .jpg sau in format .csv</h2></p>

            <div id="view">
                <a href="">PNG</a>
                <a href="">JPG</a>
                <a href="">CSV</a>
            </div>

        </div>
    </section>


</div>

</body>
</html>
