<%-- 
    Document   : nurseWorkList
    Created on : 2018/5/8
    Author     : Dora
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet type="text/css" href="jsp/main.css">
        <title>JSP Page</title>
    </head>
    <body>
        
   
            <input type="hidden" id="appendStatus" value="${status}"/> 
            <input type="hidden" id="id" value="${id}"/> 
            <table>
                <tr>
                <thead>
                    <th scope="col">已授權</th>
                    <th scope="col"> </th>
                    <th scope="col">未授權</th>
                </thead>
                </tr>
                <tr>
                    <td>
                        <table>
                            <c:forEach var="Workspace" items="${lstIn}">
                            <tr>
                                <td scope="row"><input type="checkbox" name="workSpaceIn[]" id="${Workspace.getId()}" value="${Workspace.getId()}"></td>
                                <td>${Workspace.getName()}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </td>
                    <td>
                        <button onclick="nurseWorkAppend()" style="width: 80px"><新增</button><br>
                        <button onclick="nurseWorkRemove()" style="width: 80px">>移除</button>
                    </td>
                    <td>
                        <table>
                            <c:forEach var="Workspace" items="${list}">
                                <tr>
                                    <td scope="row"><input type="checkbox" name="workSpaceNotIn[]" id="${Workspace.getId()}" value="${Workspace.getId()}"></td>
                                    <td>${Workspace.getName()}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>
           
    </body>
</html>
