<%@ page import="java.util.ArrayList" %>
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

                <h1>Damage List</h1>
                <a href="newDamage"><h4>New Damage</h4></a>

                <table>
                    <th>disId</th>
                    <th>maleDeath</th>
                    <th>femaleDeath</th>
                    <th>maleInjured</th>
                    <th>femaleInjured</th>
                    <th>publicDamages</th>
                    <th>Edit</th>
                    <th>Delete</th>

                    <% ArrayList<Damage> posts = (ArrayList<Damage>) request.getAttribute("listDamage");
                        for (Damage post : posts) { %>
                    <tr>
                        <td><%=post.getDisId()%>
                        </td>
                        <td><%=post.getMaleDeath()%>
                        </td>
                        <td><%=post.getFemDeath()%>
                        </td>
                        <td><%=post.getMaleInjured()%>
                        </td>
                        <td><%=post.getFemInjured()%>
                        </td>
                        <td><%=post.getPublicDamages()%>
                        </td>
                        <td><a href="/editDamage?dis_id=<%=post.getDisId()%>"><h5>Edit</h5></a></td>
                        <td><a href="/deleteDamage?dis_id=<%=post.getDisId()%>"><h5>Delete</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>

