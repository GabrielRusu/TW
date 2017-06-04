<%@ page import="java.util.ArrayList" %>
<%@ page import="MySpringMVC.model.District" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>District List</title>
</head>
<body>
<div align="center">
    <h1>District List</h1>
    <h3><a href="/newDistrict">New District</a></h3>
    <table border="1">
        <th>ID</th>
        <th>Name</th>

        </th>
        <%
            ArrayList<District> posts = (ArrayList<District>) request.getAttribute("listDistrict");
        %>
        <%
            for (District post : posts) {
        %>
        <tr>
            <td><%=post.getId()%>
            </td>
            <td><%=post.getName()%>
            </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
