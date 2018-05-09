<%-- 
    Document   : work
    Created on : 2018/5/3, 下午 05:14:56
    Author     : toprd
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr><th>id</th><th>name</th></tr>
            <c:forEach var="Workspace" items="${listWS}">
                
                <tr>
                    <td><c:out value="${Workspace.getId()}"></c:out></td>
                    <td><c:out value="${Workspace.getName()}"></c:out></td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>
    </body>
</html>
