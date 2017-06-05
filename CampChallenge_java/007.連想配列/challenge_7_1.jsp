<%-- 
    Document   : challenge_7_1
    Created on : 2017/06/05, 21:07:22
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%
        
            HashMap<String,String> a = new HashMap<String,String>();
            
            a.put("1","AAA");
            a.put("hello","world");            
            a.put("soeda","33");
            a.put("20","20");
            
            out.println(a.get("1"));
                
        %>
        
    </body>
</html>
