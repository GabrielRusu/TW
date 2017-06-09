<%@ page import="MySpringMVC.model.Municipality" %>

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

                <h3>Modifica/Adauga o Municipalitate</h3>

                <h4>Pentru a introduce o noua Municipalitate, adaugati un ID inexistent si restul datelor</h4>
                <h4>Pentru a modifica o Municipalitate existenta, modificati doar numele si District IDul</h4>


                <% Municipality post = (Municipality) request.getAttribute("Municipality");
                %>
                <form action="saveMunicipality" method="post">
                    <table>
                        <tr>
                            <td> ID</td>
                            <td><input type="text" name="id" path="id" value="<%=post.getId()%>"></td>
                        </tr>
                        <tr>
                            <td> District ID</td>
                            <td><input type="text" name="disId" path="disId" value="<%=post.getDisId()%>"></td>
                        </tr>
                        <tr>
                            <td> Nume</td>
                            <td><input type="text" name="name" path="name" value="<%=post.getName()%>"></td>
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
