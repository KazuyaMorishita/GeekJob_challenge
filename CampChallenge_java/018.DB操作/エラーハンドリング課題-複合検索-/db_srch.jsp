<%-- 
    Document   : db_srch
    Created on : 2017/07/12, 15:30:45
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
        <div class="contents">
            
            <%
                HttpSession hs = request.getSession();
                hs.setAttribute("srch", "srch");
            %>
            
            <h1>検索フォーム</h1><br>
            
            <form class="db_srch" action="Condb_Sess" method="post">
                
                <input type="hidden" name="id" value="-1">
                    
                <p>名前：<input type="text" name="name"></p>
                
                <p>年齢：
                <select name="age">
                    <option value="-1"></option>
                    <% for (int i = 0; i <= 117; i++){ %>
                        <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                </p>
                <p>生年月日：
                <select name="bir_yy">
                    <option value="null"></option>
                    <% for(int i = 1900; i <= 2017; i++){ %>
                        <option value="<%= i %>"><%= i %></option>
                    <% } %>
                </select>
                年
                <select name="bir_mm">
                    <option value="null"></option>
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
                    <option value="null"></option>
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
                <input type="submit" value="検索">
                
            </form>
            
        </div>
    </body>
</html>
