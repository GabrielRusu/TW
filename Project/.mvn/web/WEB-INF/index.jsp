<%--
  Created by IntelliJ IDEA.
  User: Gabriel Rusu
  Date: 04-Jun-17
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page import="example.District" %>

<html>
<head>
    <title>Title</title>

    <table>
        <th>
        <td>ID</td>
        <td>NAME</td>
        </th>
        <%
            ArrayList<District> posts = (ArrayList<District>) request.getAttribute("message");
        %>
        <tr>
            <td><%=posts.get(0).getId()%>
            </td>
            <td><%=posts.get(0).getName()%>
            </td>
        </tr>
        <tr>
            <td><%=posts.get(2).getId()%>
            </td>
            <td><%=posts.get(2).getName()%>
            </td>
        </tr>
        <tr>
            <td>ASSS
            </td>
            <td>DUKFA
            </td>
        </tr>
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
</head>
<body>

</body>
</html>
