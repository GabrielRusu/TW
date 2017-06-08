<%@ page import="MySpringMVC.model.Project" %>

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
                <h1>Edit/Add Project</h1>

                <% Project post = (Project) request.getAttribute("Project");
                %>
                <form action="saveProject" method="post">
                    <table>
                        <tr>
                            <td> clusId</td>
                            <td><input type="text" name="clusId" path="clusId" value="<%=post.getClusId()%>"></td>
                        </tr>
                        <tr>
                            <td> disID</td>
                            <td><input type="text" name="disID" path="disID" value="<%=post.getDisId()%>"></td>
                        </tr>
                        <tr>
                            <td> munId</td>
                            <td><input type="text" name="munId" path="munId" value="<%=post.getMunId()%>"></td>
                        </tr>
                        <tr>
                            <td> ActivityType</td>
                            <td><input type="text" name="ActivityType" path="ActivityType" value="<%=post.getActivityType()%>"></td>
                        </tr>
                        <tr>
                            <td> item</td>
                            <td><input type="text" name="item" path="item" value="<%=post.getItem()%>"></td>
                        </tr>
                        <tr>
                            <td> total</td>
                            <td><input type="text" name="total" path="total" value="<%=post.getTotal()%>"></td>
                        </tr>
                        <tr>
                            <td> unit</td>
                            <td><input type="text" name="unit" path="unit" value="<%=post.getUnit()%>"></td>
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
