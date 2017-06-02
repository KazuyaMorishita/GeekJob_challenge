<%-- 
    Document   : challenge_3_1
    Created on : 2017/06/02, 15:43:05
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
            int num_1 = 1;
            int num_2 = 1;
            int num_3 = 2;
            int num_4 = 10;
            
            final int NUM_1_1 = 1;
            final int NUM_2_1 = 1;
            final int NUM_3_1 = 2;
            final int NUM_4_1 = 10;
            
            out.println(num_1 + 1 + "<br>");
            out.println(num_2 - 1 + "<br>");
            out.println(num_3 * 2 + "<br>");
            out.println(num_4 / 2 + "<br><br><br>");
            
            out.println(NUM_1_1 + 1 + "<br>");
            out.println(NUM_2_1 - 1 + "<br>");
            out.println(NUM_3_1 * 2 + "<br>");
            out.println(NUM_4_1 / 2);

        %>
    </body>
</html>
