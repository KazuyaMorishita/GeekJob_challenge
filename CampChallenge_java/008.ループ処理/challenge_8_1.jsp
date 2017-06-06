<%-- 
    Document   : challege_8_1
    Created on : 2017/06/05, 21:59:06
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
                int x = 8;
                int a = 1;
                
            
            for(int i = 0; i<=20; i++){
                a *= x; 
            }
            out.println(a);
            
            
        %>
        
    </body>
</html>
