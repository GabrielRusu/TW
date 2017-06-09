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
                <h1>Modifica/Adauga un Project</h1>

                <% Project post = (Project) request.getAttribute("Project");
                %>
                <form action="saveProject" method="post">
                    <table>
                        <tr>
                            <td> ID Proiect</td>
                            <td><input type="text" name="clusId" path="clusId" value="<%=post.getClusId()%>"></td>
                        </tr>
                        <tr>
                            <td> District ID</td>
                            <td><input type="text" name="disID" path="disID" value="<%=post.getDisId()%>"></td>
                        </tr>
                        <tr>
                            <td> Municipiu ID</td>
                            <td><input type="text" name="munId" path="munId" value="<%=post.getMunId()%>"></td>
                        </tr>
                        <tr>
                            <td> Tip Activitate</td>
                            <td><input type="text" name="ActivityType" path="ActivityType" value="<%=post.getActivityType()%>"></td>
                        </tr>
                        <tr>
                            <td> Nume lucru</td>
                            <td><input type="text" name="item" path="item" value="<%=post.getItem()%>"></td>
                        </tr>
                        <tr>
                            <td> Nr. unitati</td>
                            <td><input type="text" name="total" path="total" value="<%=post.getTotal()%>"></td>
                        </tr>
                        <tr>
                            <td> Unitate de masura</td>
                            <td><input type="text" name="unit" path="unit" value="<%=post.getUnit()%>"></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td><input type="submit" value="Submit" style="color: #ffffff;"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </section>
    </div>

</div>

</body>
</html>
