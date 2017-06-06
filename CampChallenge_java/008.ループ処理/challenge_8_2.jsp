<%-- 
    Document   : challenge_8_2
    Created on : 2017/06/06, 19:58:37
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
            
            int num = 1000;
            int count = 0;
            
            while(num < 100){
                num = num / 2;
                count ++;
            }
            
            out.println(num + "<br>");
            out.println(count + "回");
        
        %>
        
    </body>
</html>
