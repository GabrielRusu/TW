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
        <a href="/viewTables">Intoarce-te la tabele</a>
    </div>

    <div align="center">
        <section id="intro">
            <div class="article-intro">

                <h1>Village List</h1>
                <a href="newCluster"><h4>Adauga un nou Cluster</h4></a>

                <table>
                    <th>ID</th>
                    <th>District ID</th>
                    <th>Municipiu ID</th>
                    <th>Tip activitate</th>
                    <th>Nume lucru</th>
                    <th>Nr. unitati</th>
                    <th>Unitate de masura</th>

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
                        <td><a href="/editProject?clus_id=<%=post.getClusId()%>"><h5>Modifica</h5></a></td>
                        <td><a href="/deleteProject?clus_id=<%=post.getClusId()%>"><h5>Sterge</h5></a></td>
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
