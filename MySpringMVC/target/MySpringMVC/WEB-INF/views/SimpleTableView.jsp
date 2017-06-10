<%@ page import="MySpringMVC.model.PopStatistics" %>
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
                    <a href="/viewSimpleTable">Tabel</a>
                    <a href="/viewGraph">Grafic</a>
                    <a href="/viewChart">Chart</a>
                    <a href="/viewMap?hazard=-1">Harta</a>
                </div>

                <h3>Table</h3>
                <h4>Informatii despre populatie</h4>
                <div id="view">
                    <a href="/viewSimpleTable/1">Statistici populatie</a>
                    <a href="/viewSimpleTable2/1">Informatii proiecte</a>
                </div>

                <table>
                    <th>Nume District</th>
                    <th>Populatie</th>
                    <th>Morti</th>
                    <th>Raniti</th>

                    <% ArrayList<PopStatistics> posts = (ArrayList<PopStatistics>) request.getAttribute("listSimpleTable");
                        for (PopStatistics post : posts) { %>
                    <tr>
                        <td><%=post.getName()%>
                        </td>
                        <td><%=post.getPopulation()%>
                        </td>
                        <td><%=post.getDead()%>
                        </td>
                        <td><%=post.getInjured()%>
                        </td>
                    </tr>
                    <%}%>
                </table>

                <p><h4>Puteti exporta chart-ul in format .png, .jpg sau in format .csv</h4></p>

                <div id="view">
                    <a href="">PNG</a>
                    <a href="">JPG</a>
                    <a href="">CSV</a>
                </div>

                <div id="view" style="background: transparent;">
                    <% Integer pageId = (Integer) request.getAttribute("pageId"); %>
                    <a href="/viewSimpleTable/<%=pageId-10%>"> << </a>
                    <a href="/viewSimpleTable/<%=pageId-1%>"> < </a>
                    <a href="/viewSimpleTable/<%=pageId%>"> <%=pageId%> </a>
                    <a href="/viewSimpleTable/<%=pageId+1%>"> > </a>
                    <a href="/viewSimpleTable/<%=pageId+10%>"> >> </a>
                </div>

            </div>
        </section>
    </div>

</div>

</body>
</html>