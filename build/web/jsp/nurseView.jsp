<%-- 
    Document   : nurseView
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
        <link rel=stylesheet type="text/css" href="jsp/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>護士異動</title>
    </head>
    <body>
        <div>
           <input type="hidden" id="id" value="${id}"/>             
        </div>
        <fieldset>
            <button id="backBtn">返回</button> <button id="saveBtn">儲存</button>
        </fieldset>
        <fieldset>
            <input id="nurseId" type="text" value="${nurseId}" required>
            <label for="nurseId">員工編號</label>
            <div class="after"></div> 
        </fieldset> 
        <fieldset>
            <input id="nurseName" type="text" value="${nurseName}" required>
            <label for="nurseName">護士姓名</label>
            <div class="after"></div> 
         </fieldset>
        
        <div id="workList"> </div>           
        
        <script>
            
            getWorkList();

           
           function nurseWorkAppend(){
                
                var count = $("input[name='workSpaceNotIn[]']:checked").length;
                if(count == 0){
                    alert("請至少勾選一筆站點!");
                }else{
                    
                    var space = [];
                    $.each($("input[name='workSpaceNotIn[]']:checked"), function(){                            
                        space.push($(this).val());
                    });

                    var spaceIdArray = space.join(",");
                    var nurseId = $('#id').attr('value');

                    $.ajaxSetup({
                        headers: {
                            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
                        }
                    });

                    var url = "/bionimeJava/NurseWorkAppend?nurseId=" + nurseId + "&workId="+spaceIdArray;

                    $.ajax({
                        url: url,
                        type: "GET",
                        success: function (data) {
                            if ($.isEmptyObject(data.error)) {

                                $('#workList').html(data);
                            } else {
                                printErrorMsg(data.error);
                            }
                        }
                    }); 
                }
                
          
            }
           
            function nurseWorkRemove(){
               
                var count = $("input[name='workSpaceIn[]']:checked").length;
               if(count == 0){
                    alert("請至少勾選一筆站點!");
                }else{
                    
                    
                }
                var space = [];
                $.each($("input[name='workSpaceIn[]']:checked"), function(){   
				//alert($(this).val());
                    space.push($(this).val());
                });
			
		var spaceIdArray = space.join(",");
                var nurseId = $('#id').attr('value');
                
                    $.ajaxSetup({
                        headers: {
                            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
                        }
                    });
                  
                    var url = "/bionimeJava/NurseWorkRemove?nurseId=" + nurseId + "&workId="+spaceIdArray;

                    $.ajax({
                        url: url,
                        type: "GET",
                        success: function (data) {
                            if ($.isEmptyObject(data.error)) {

                                $('#workList').html(data);
                            } else {
                                printErrorMsg(data.error);
                            }
                        }
                    });
           
            }
            $("#backBtn").click(function () {

                history.back();
            });
            $("#saveBtn").click(function () {

                var id = $('#id').val();
                var nurseId = $('#nurseId').val();
                var name = $('#nurseName').val();

                var url = "/bionimeJava/NurseAppendSave?id="+ id +"&nurseId=" + nurseId + "&nurseName=" + name;

                $.ajax({
                    type: 'POST',
                    url: url,
                    success: function (data, result) {
                         $('#workList').html(data);
                        
                    },
                    error: function () {
                        alert('異動失敗');
                    }
                });
            });
            function getWorkList() {


                
               
                    $.ajaxSetup({
                        headers: {
                            'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
                        }
                    });
                    var id = $('#id').attr('value');
                    var url = "/bionimeJava/NurseWorkList?id=" + id;

                    $.ajax({
                        url: url,
                        type: "GET",
                        success: function (data) {
                            if ($.isEmptyObject(data.error)) {

                                $('#workList').html(data);
                            } else {
                                printErrorMsg(data.error);
                            }
                        }
                    });
                    
                    


            }
        </script>
    </body>
</html>
