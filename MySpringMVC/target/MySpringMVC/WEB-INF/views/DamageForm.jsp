<%@ page import="MySpringMVC.model.Damage" %>

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
                <h1>Edit/Add Damage</h1>

                <% Damage post = (Damage) request.getAttribute("Damage");
                %>
                <form action="saveDamage" method="post">
                    <table>
                        <tr>
                            <td> disID</td>
                            <td><input type="text" name="disId" path="disId" value="<%=post.getDisId()%>"></td>
                        </tr>
                        <tr>
                            <td> maleDeath</td>
                            <td><input type="text" name="maleDeath" path="MaleDeath" value="<%=post.getMaleDeath()%>"></td>
                        </tr>
                        <tr>
                            <td> femDeath</td>
                            <td><input type="text" name="femaleDeath" path="femaleDeath" value="<%=post.getFemDeath()%>"></td>
                        </tr>
                        <tr>
                            <td> maleInjured</td>
                            <td><input type="text" name="maleInjured" path="MaleInjured" value="<%=post.getMaleInjured()%>"></td>
                        </tr>
                        <tr>
                            <td> femaleInjured</td>
                            <td><input type="text" name="femaleInjured" path="femaleInjured" value="<%=post.getFemInjured()%>"></td>
                        </tr>
                        <tr>
                            <td> publicDamages</td>
                            <td><input type="text" name="publicDamages" path="publicDamages" value="<%=post.getPublicDamages()%>"></td>
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
