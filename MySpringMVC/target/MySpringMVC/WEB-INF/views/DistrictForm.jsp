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
    <link rel="stylesheet" type="text/css" href="../../resources/style.css"/>

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

    <section id="intro">
        <div class="article-intro">

            <div align="center">
                <h1>Edit/Add District</h1>

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

                <% District post = (District) request.getAttribute("district");
                %>
                <form action="saveDistrict" method="post" modelAttribute="district">
                    ID:<br>
                    <input type="text" name="id" path="id" value="<%=post.getId()%>">
                    <br>
                    Name:<br>
                    <input type="text" name="name" path="name" value="<%=post.getName()%>">
                    <br><br>
                    <input type="submit" value="Submit">
                </form>

            </div>

        </div>
    </section>

</div>

</body>
</html>
