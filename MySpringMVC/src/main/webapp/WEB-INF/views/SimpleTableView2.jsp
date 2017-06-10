<%@ page import="MySpringMVC.model.PopStatistics" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.ProjectActivity" %>
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
                <h4>Informatii despre diferite proiecte</h4>
                <div id="view">
                    <a href="/viewSimpleTable/1">Statistici populatie</a>
                    <a href="/viewSimpleTable2/1">Informatii proiecte</a>
                </div>

                <table>
                    <th>Cluster</th>
                    <th>District</th>
                    <th>Municipalitate</th>
                    <th>Activitate</th>
                    <th>Tip Lucru</th>
                    <th>Nr. Total</th>
                    <th>Unitate de masura</th>

                    <% ArrayList<ProjectActivity> posts = (ArrayList<ProjectActivity>) request.getAttribute("listSimpleTable2");
                        for (ProjectActivity post : posts) { %>
                    <tr>
                        <td><%=post.getCluster()%>
                        </td>
                        <td><%=post.getDistrict()%>
                        </td>
                        <td><%=post.getMunicipality()%>
                        </td>
                        <td><%=post.getActivity()%>
                        </td>
                        <td><%=post.getItem()%>
                        </td>
                        <td><%=post.getTotal()%>
                        </td>
                        <td><%=post.getUnit()%>
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
                    <a href="/viewSimpleTable2/<%=pageId-10%>"> << </a>
                    <a href="/viewSimpleTable2/<%=pageId-1%>"> < </a>
                    <a href="/viewSimpleTable2/<%=pageId%>"> <%=pageId%> </a>
                    <a href="/viewSimpleTable2/<%=pageId+1%>"> > </a>
                    <a href="/viewSimpleTable2/<%=pageId+10%>"> >> </a>
                </div>

            </div>
        </section>
    </div>

</div>

</body>
</html>