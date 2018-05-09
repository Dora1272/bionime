<%-- 
    Document   : workSpaceView
    Created on : 2018/5/7
    Author     : Dora
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link rel=stylesheet type="text/css" href="jsp/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>站點異動</title>
    </head>

    <body>
        <fieldset>
            <button id="backBtn">返回</button> <button id="saveBtn">儲存</button>
        </fieldset>
        
        <fieldset>
       
        <input id="workSpace" type="text" name="${spaceId}" value="${spaceName}" required>
        <label for="workSpace">站點名稱</label>
        <div class="after"></div>        
        </fieldset>
        
        <table>   
            <thead>
            <tr>
                <th scope="col">員工編號</th>
                <th scope="col">護士姓名</th>
                <th scope="col">加入時間</th>
            </tr>
            </thead>
               <c:forEach var="li" items="${list}">

                <tr>
                    <td scope="row"><c:out value="${li.getId()}"></c:out></td>
                    <td><c:out value="${li.getName()}"></c:out></td>
                    <td><c:out value="${li.getCrtTime()}"></c:out></td>                    
                    </tr>
            </c:forEach>
            <tr></tr>
        </table>
            <script>
            $("#backBtn").click(function () {

                history.back();
            });
            $("#saveBtn").click(function () {
                
                var id = $('#workSpace').attr('name');
                var name = $('#workSpace').val();

                var url = "/bionimeJava/WorkSpaceModifySave?workSpaceId=" + id + "&workSpaceName=" + name;

                $.ajax({
                    type: 'get',
                    url: url,                   
                    success: function (data, result) {
                       alert('異動成功');
                    },
                    error: function () {
                        alert('異動失敗');
                    }
                });
            });

        </script>
    </body>
</html>
