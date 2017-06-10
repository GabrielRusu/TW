<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.District" %>

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

                <h3>District List</h3>
                <a href="newDistrict"><h5>Adauga un nou District</h5></a>

                <table>
                    <th>ID</th>
                    <th>Nume</th>

                    <% ArrayList<District> posts = (ArrayList<District>) request.getAttribute("listDistrict");
                        for (District post : posts) { %>
                    <tr>
                        <td><%=post.getId()%>
                        </td>
                        <td><%=post.getName()%>
                        </td>
                        <td><a href="/editDistrict?id=<%=post.getId()%>"><h5>Modifica</h5></a></td>
                        <td><a href="/deleteDistrict?id=<%=post.getId()%>"><h5>Sterge</h5></a></td>
                    </tr>
                    <%}%>
                </table>

                <div id="view" style="background: transparent;">
                    <% Integer pageId = (Integer) request.getAttribute("pageId"); %>
                    <a href="/viewVillage/<%=pageId-10%>"> << </a>
                    <a href="/viewVillage/<%=pageId-1%>"> < </a>
                    <a href="/viewVillage/<%=pageId%>"> <%=pageId%> </a>
                    <a href="/viewVillage/<%=pageId+1%>"> > </a>
                    <a href="/viewVillage/<%=pageId+10%>"> >> </a>
                </div>

            </div>
        </section>
    </div>

</div>

</body>
</html>
