<%-- 
    Document   : 123
    Created on : 2018/5/3, 下午 05:58:00
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
        <h1>Hello World!12222</h1>
        <table>
            <tr><th>id</th><th>name</th></tr>
            <c:forEach var="list" items="${listNW}">
                
                <tr>
                    <td><c:out value="${list.getId()}"></c:out></td>
                    <td><c:out value="${list.getNurseId()}"></c:out></td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>
    </body>
</html>
