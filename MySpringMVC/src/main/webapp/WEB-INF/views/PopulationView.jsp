<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.Population" %>

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
                <a href="/newPopulation"><h5>Adauga o noua Populatie</h5></a>

                <table>
                    <th>Municipiu ID</th>
                    <th>District ID</th>
                    <th>Locuinte</th>
                    <th>Barbati</th>
                    <th>Femei</th>
                    <th>Densitate</th>

                    <% ArrayList<Population> posts = (ArrayList<Population>) request.getAttribute("listPopulation");
                        for (Population post : posts) { %>
                    <tr>
                        <td><%=post.getMunId()%>
                        </td>
                        <td><%=post.getDisId()%>
                        </td>
                        <td><%=post.getHouseholds()%>
                        </td>
                        <td><%=post.getMalePop()%>
                        </td>
                        <td><%=post.getFempop()%>
                        </td>
                        <td><%=post.getDensity()%>
                        </td>
                        <td><a href="/editPopulation?id=<%=post.getMunId()%>"><h5>Modifica</h5></a></td>
                        <td><a href="/deletePopulation?id=<%=post.getMunId()%>"><h5>Sterge</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>
