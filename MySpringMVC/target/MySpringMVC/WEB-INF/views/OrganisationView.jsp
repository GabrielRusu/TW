<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.Organisation" %>

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

    <div align="center">
        <section id="intro">
            <div class="article-intro">

                <div id="view">
                    <a href="/viewTables">Intoarce-te la tabele</a>
                </div>

                <h3>Organisation List</h3>
                <a href="newOrganisation"><h4>New Organisation</h4></a>

                <table>
                    <th>ID</th>
                    <th>Cluster ID</th>
                    <th>Nume</th>
                    <th>Acronim</th>

                    <% ArrayList<Organisation> posts = (ArrayList<Organisation>) request.getAttribute("listOrganisation");
                        for (Organisation post : posts) { %>
                    <tr>
                        <td><%=post.getId()%>
                        </td>
                        <td><%=post.getClusId()%>
                        </td>
                        <td><%=post.getName()%>
                        </td>
                        <td><%=post.getAcronym()%>
                        </td>
                        <td><a href="/editOrganisation?id=<%=post.getId()%>"><h5>Edit</h5></a></td>
                        <td><a href="/deleteOrganisation?id=<%=post.getId()%>"><h5>Delete</h5></a></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </section>
    </div>

</div>

</body>
</html>
