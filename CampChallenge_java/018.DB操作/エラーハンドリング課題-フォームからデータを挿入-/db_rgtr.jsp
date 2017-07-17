<%-- 
    Document   : db_rgtr
    Created on : 2017/07/13, 13:31:02
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./style.css" media="all" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contents">
            <%
                //sessionにこのページの値を格納
                HttpSession hs = request.getSession();
                hs.setAttribute("rgtr", "rgtr");

            %>
            
            <h1>登録情報を入力して下さい</h1><br>
            
            <form action="Condb_Sess" method="post">
                
                <input type="hidden" name="id" size="30" value="-1">
                
                <p>名前：<input type="text" name="name" size="30"></p>
                
                <p>電話番号：<input type="text" name="tel" size="30"></p>
                
                <p>年齢：
                <select name="age">
                    <% for (int i = 1; i <= 117; i++){ %>
                        <option value="<%= i %>"><%= i %></option>                   
                    <% } %>
                </select>
                </p>
                
                <p>生年月日：
                <select name="bir_yy">
                    <% for(int i = 1900; i <= 2017; i++){ %>
                        <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                年
                <select name="bir_mm">
                    <% for (int i = 1; i <= 12; i++){ %>
                        <%if(i < 10){%>
                            <option value="0<%= i %>">0<%= i %></option>
                        <% }else { %>
                            <option value="<%= i %>"><%= i %></option>
                        <% } %>
                    <% } %>
                </select>
                月
                <select name="bir_dd">
                    <% for (int i = 1; i <= 31; i++){ %>
                        <%if(i < 10){ %>
                            <option value="0<%= i %>">0<%= i %></option>
                        <% }else { %>
                            <option value="<%= i %>"><%= i %></option>
                        <% } %>
                    <% } %>
                </select>
                日              
                </p>
                
                <input type="submit" value="新規登録">
                
            </form>
            
        </div>
    </body>
</html>
