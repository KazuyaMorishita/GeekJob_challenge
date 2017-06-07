<%-- 
    Document   : challenge_5_1
    Created on : 2017/06/03, 19:50:43
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
        
            int num = 100;
                
            if (num == 1) {
                out.println("1です!");
            }else if(num == 2) {
                out.println("プログラミングキャンプです!");
            }else {
                out.println("それ以外です!");
            }
          
            
           
            
            

        %>
    </body>
</html>
