<%-- 
    Document   : req
    Created on : 2017/07/19, 16:23:01
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.mypackage.java.RegCont"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        
        RegCont rc = (RegCont)request.getAttribute("regCont");
        
        String item = rc.getItem();
        String label = rc.getLabel();
        int stock = rc.getStock();

        %>
    </head>
    <body>

        <div class="reg_contents">
            
            <h1>商品登録確認</h1>
            
            <form action="Reg" method="post">
                
                <div class="form_style">
                    <label>商品名：<%= item %></label>    
                    <div class="clearboth"></div>
               </div>
                    
                <div class="form_style">
                    <label>レーベル：<%= label %></label>
                    <div class="clearboth"></div>
               </div>
                
                <div class="form_style">
                    <label>商品数：<%= stock %></label>
                    <div class="clearboth"></div>
                </div>
                
                <div class="form_style">
                    <div class="input">
                        <input type="submit" value="登録">
                    </div>
                </div>
                
            </form>
            
        </div>
    </body>
</html>
