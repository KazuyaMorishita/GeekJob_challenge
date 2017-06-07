<%-- 
    Document   : challenge_5_4
    Created on : 2017/06/04, 19:15:14
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
        
            int num = 0;
           
            switch(num){
                case 1:
                    out.println("one");
                    break;
                
                case 2:
                    out.println("two");
                    break;
                
                default:
                    out.println("想定外");
                    break;
            }
        
        %>
        
    </body>
</html>