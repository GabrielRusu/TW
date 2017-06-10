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
                    <a href="/viewSimpleTable">Tabel</a>
                    <a href="/viewGraph">Grafic</a>
                    <a href="/viewChart">Chart</a>
                    <a href="/viewMap?hazard=-1">Harta</a>
                </div>

                <div class="container">
                    <div id="chart_div"></div>
                </div>

                <div class="container">
                    <center><img src="../../resources/images/Pie_Chart.jpeg" alt="Chart"></center>
                </div>

                <h3>Chart</h3>
                <p>
                <h2>Sunteti la modul de vizualizare chart</h2></p>
                <p>
                <h2>Aici puteti alege dintre mai multe statistici pe care le doriti sa le afisati</h2></p>
                <p>
                <h2>Puteti exporta chart-ul in format .png sau .jpg</h2></p>

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
