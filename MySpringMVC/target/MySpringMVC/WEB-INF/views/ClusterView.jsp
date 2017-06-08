<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.Cluster" %>

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
        <a href="/#intro">INTRODUCERE</a>
        <a href="/#first">DETALII</a>
        <a href="/#second">APLICATII</a>
        <a href="/#voluntar">FII VOLUNTAR!</a>
        <a href="/#third">FINAL</a>
    </div>
</div>

<div id="main-app">

    <div id="view">
        <a href="/viewCluster">Clusters</a>
        <a href="/viewDamage">Damages</a>
        <a href="/viewDistrict">Districts</a>
        <a href="/viewEarthquake">Earthquakes</a>
        <a href="/viewMunicipality">Municipalities</a>
        <a href="/viewVillage">Villages</a>
    </div>

    <div align="center">
        <section id="intro">
            <div class="article-intro">

                <h1>Cluster List</h1>
                <a href="newCluster"><h4>New Cluster</h4></a>

                <table>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Edit</th>
                    <th>Delete</th>

                    <% ArrayList<Cluster> posts = (ArrayList<Cluster>) request.getAttribute("listCluster");
                        for (Cluster post : posts) { %>
                    <tr>
                        <td><%=post.getId()%>
                        </td>
                        <td><%=post.getName()%>
                        </td>
                        <td><a href="/editCluster?id=<%=post.getId()%>"><h5>Edit</h5></a></td>
                        <td><a href="/deleteCluster?id=<%=post.getId()%>"><h5>Delete</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>
