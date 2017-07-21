<%-- 
    Document   : itemLi_print
    Created on : 2017/07/18, 23:13:58
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.java.RS_itemList"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            RS_itemList rsData = (RS_itemList)request.getAttribute("rsData");
            ResultSet rs = rsData.getRsdata();
        %>
    </head>
    <body>
        
        <div class="itemLi_print_contents">
        
            <div class="print_filed">

                <table>
                    <tr>
                        <th>商品ID</th>
                        <th>商品名</th>
                        <th>レーベル</th>
                        <th>在庫数</th>
                    </tr>
                    <% while(rs.next()){ %>
                    <tr>
                        <th><% out.print(rs.getInt("id") + "<br>"); %></th>
                        <th><% out.print(rs.getString("name") + "<br>"); %></th>
                        <th><% out.print(rs.getString("label") + "<br>"); %></th>
                        <th><% out.print(rs.getInt("stock") + "<br>"); %></th>
                    </tr>
                    <% } %>
            </div>
            
        </div>
    
    </body>
</html>
