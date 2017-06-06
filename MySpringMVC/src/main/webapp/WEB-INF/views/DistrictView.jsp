<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.District" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<meta charset="UTF-8">

<html>
<head>
    <title>INepal</title>
    <link rel="stylesheet" type="text/css" href="../../resources/crud.css"/>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="../../resources/js/sidebar.js"></script>
    <script src="../../resources/js/charts.js"></script>
</head>
<body>

<div id="header">
    <div class="menu">
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

    <div align="center">
        <section id="intro">
            <div class="article-intro">

                <h1>District List</h1>
                <a href="newDistrict"><h4>New District</h4></a>

                <table>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Edit</th>
                    <th>Delete</th>

                    <% ArrayList<District> posts = (ArrayList<District>) request.getAttribute("listDistrict");
                        for (District post : posts) { %>
                    <tr>
                        <td><%=post.getId()%>
                        </td>
                        <td><%=post.getName()%>
                        </td>
                        <td><a href="/editDistrict?id=<%=post.getId()%>"><h5>Edit</h5></a></td>
                        <td><a href="/deleteDistrict?id=<%=post.getId()%>"><h5>Delete</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>
