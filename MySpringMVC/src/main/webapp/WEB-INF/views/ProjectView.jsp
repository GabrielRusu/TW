<%@ page import="java.util.ArrayList" %>
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

                <h1>Project List</h1>
                <a href="newProject"><h4>New Project</h4></a>

                <table>
                    <th>clusId</th>
                    <th>disId</th>
                    <th>munId</th>
                    <th>activityType</th>
                    <th>item</th>
                    <th>total</th>
                    <th>unit</th>
                    <th>Edit</th>
                    <th>Delete</th>

                    <% ArrayList<Project> posts = (ArrayList<Project>) request.getAttribute("listProject");
                        for (Project post : posts) { %>
                    <tr>
                        <td><%=post.getClusId()%>
                        </td>
                        <td><%=post.getDisId()%>
                        </td>
                        <td><%=post.getMunId()%>
                        </td>
                        <td><%=post.getActivityType()%>
                        </td>
                        <td><%=post.getItem()%>
                        </td>
                        <td><%=post.getTotal()%>
                        </td>
                        <td><%=post.getUnit()%>
                        </td>
                        <td><a href="/editProject?clus_id=<%=post.getClusId()%>"><h5>Edit</h5></a></td>
                        <td><a href="/deleteProject?clus_id=<%=post.getClusId()%>"><h5>Delete</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>
