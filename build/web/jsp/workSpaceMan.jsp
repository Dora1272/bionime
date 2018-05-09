<%-- 
    Document   : work
    Created on : 2018/5/3
    Author     : Dora
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link rel=stylesheet type="text/css" href="jsp/main.css">
        <title>站點管理</title>
    </head>
    <body>
        <fieldset>
            <button id="backBtn" onclick="backBtn()">返回</button>            
        </fieldset>
        <table>
            <thead>
                <tr>
                    <th scope="col">編號</th>
                    <th scope="col">名稱</th>
                    <th scope="col">異動時間</th>
                    <th scope="col">站點異動</th>
                </tr>
            </thead>
            <c:forEach var="Workspace" items="${listWS}">
                
                <tr>
                    <td scope="row"><c:out value="${Workspace.getId()}"></c:out></td>
                    <td><c:out value="${Workspace.getName()}"></c:out></td>
                    <td><c:out value="${Workspace.getUptTime()}"></c:out></td>
                    <td>
                        <a href="/bionimeJava/WorkSpaceModify?workSpaceId=${Workspace.getId()}">修改</a>
                        <a href="/bionimeJava/WorkSpaceDel?workSpaceId=${Workspace.getId()}">刪除</a>
                    </td>
                </tr>
            </c:forEach>
           
        </table>
        <script>
            
            function backBtn(){

                history.back();
            }
        </script>
    </body>
</html>
