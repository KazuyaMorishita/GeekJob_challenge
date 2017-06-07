<%-- 
    Document   : challenge_6_1_2
    Created on : 2017/06/05, 20:42:37
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            
            ArrayList<String> datas = new ArrayList<String>();
            
            datas.add("10");
            datas.add("100");
            datas.add("soeda");
            datas.add("hayashi");
            datas.add("-20");
            datas.add("118");
            datas.add("END");
            
                //out.println(datas.get(2));
            
            datas.set(2,"33");
                out.println(datas.get(2));
        
        %>
        
    </body>
</html>
