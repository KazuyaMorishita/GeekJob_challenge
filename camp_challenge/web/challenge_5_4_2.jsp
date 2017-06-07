<%-- 
    Document   : challenge_5_4_2
    Created on : 2017/06/04, 19:58:23
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
           String num = "A";
           
           switch(num){
                 case "A":
                    out.println("英語");
                    break;
                 case "あ":
                    out.println("日本語");
                    break;
           }
       
       %>
    </body>
</html>
