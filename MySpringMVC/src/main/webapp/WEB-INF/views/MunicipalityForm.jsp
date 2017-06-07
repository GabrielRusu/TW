<%@ page import="MySpringMVC.model.Municipality" %>

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
                <h1>Edit/Add Municipality</h1>

                <% Municipality post = (Municipality) request.getAttribute("Municipality");
                %>
                <form action="saveMunicipality" method="post">
                    <table>
                        <tr>
                            <td> ID</td>
                            <td><input type="text" name="id" path="id" value="<%=post.getId()%>"></td>
                        </tr>
                        <tr>
                            <td> disID</td>
                            <td><input type="text" name="disID" path="disID" value="<%=post.getDisId()%>"></td>
                        </tr>
                        <tr>
                            <td> Name</td>
                            <td><input type="text" name="name" path="name" value="<%=post.getName()%>"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Submit" style="color: #ffffff;"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </section>
    </div>

</div>

</body>
</html>
