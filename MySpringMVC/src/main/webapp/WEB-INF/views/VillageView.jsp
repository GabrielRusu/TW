<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.Village" %>

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

                <h1>Village List</h1>
                <a href="newVillage"><h4>New Village</h4></a>

                <table>
                    <th>ID</th>
                    <th>munId</th>
                    <th>disId</th>
                    <th>Name</th>
                    <th>Edit</th>
                    <th>Delete</th>

                    <% ArrayList<Village> posts = (ArrayList<Village>) request.getAttribute("listVillage");
                        for (Village post : posts) { %>
                    <tr>
                        <td><%=post.getId()%>
                        </td>
                        <td><%=post.getMunId()%>
                        </td>
                        <td><%=post.getDisId()%>
                        </td>
                        <td><%=post.getName()%>
                        </td>
                        <td><a href="/editVillage?id=<%=post.getId()%>"><h5>Edit</h5></a></td>
                        <td><a href="/deleteVillage?id=<%=post.getId()%>"><h5>Delete</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>
