<%-- 
    Document   : nurse
    Created on : 2018/5/3, 下午 05:26:59
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
            <c:forEach var="listN" items="${listN}">
                
                <tr>
                    <td><c:out value="${listN.getId()}"></c:out></td>
                    <td><c:out value="${listN.getName()}"></c:out></td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>
    </body>
</html>
