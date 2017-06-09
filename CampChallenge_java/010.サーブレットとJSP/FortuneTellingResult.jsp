<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/06/08, 17:03:00
    Author     : kazuya
--%>


<%@page import="org.mypackage.sample.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>今日の運勢</title>
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
        %>
    </head>
    <body>
        <%
        
            if (data != null){
                out.println("<h1>あなたの" + data.getD() + "運勢は、" + data.getLuck() + "です！<h1>");
            }

        %>
    </body>
</html>
