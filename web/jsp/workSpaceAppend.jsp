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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <link rel=stylesheet type="text/css" href="jsp/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>站點新增</title>
    </head>
    <body>
        <fieldset>
            <button id="backBtn">返回</button>
            <button id="saveBtn">儲存</button>
        </fieldset>
        <fieldset>
        
            <input id="workSpaceId" type="text" name="${spaceId}" required>
            <label for="workSpaceName">新增站點</label>
            <div class="after"></div>        
        </fieldset>
        
        <script>
            $("#backBtn").click(function () {

                history.back();
            });
            $("#saveBtn").click(function () {


                var name = $('#workSpaceId').val();

                var url = "/bionimeJava/WorkSpaceAppendSave?workSpaceName=" + name;

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
