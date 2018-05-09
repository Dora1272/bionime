<%-- 
    Document   : nurseMan
    Created on : 2018/5/7
    Author     : Dora
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet type="text/css" href="jsp/main.css">
        <title>護士管理</title>
    </head>
    <body>
        <fieldset>
            <button id="backBtn">返回</button> 
        </fieldset>
        <table>
            <thead>
                <tr><th scope="col">員工編號</th><th scope="col">異動時間</th><th scope="col">站點異動</th></tr>
            </thead>
            <c:forEach var="nurse" items="${list}">
                
                <tr>
                    <td cope="row"><c:out value="${nurse.getId()}"></c:out></td>                   
                    <td><c:out value="${nurse.getUptTime()}"></c:out></td>
                    <td>
                        <a href="/bionimeJava/NurseModify?id=${nurse.getId()}">修改</a>
                        <a href="/bionimeJava/NurseDel?id=${nurse.getId()}">刪除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>
        <script>
             $("#backBtn").click(function () {

                history.back();
            });
        </script>
    </body>
</html>
