<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    boolean nullCheck = udb != null;
    out.print("nullCheckの値は「" + nullCheck + "」です<br>");
    out.print("入力された値は「" + hs.getAttribute("name") + "」です");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <% if (nullCheck) { %>
            <input type="text" name="name" value="<%= hs.getAttribute("name") %>">
        <% } else { %>
            <input type="text" name="name" value="">
        <% } %>
        <br><br>
        

        生年月日:
        
        <select name="year">
            <% if ("".equals(hs.getAttribute("year"))) { %>
                <option value="">----</option>
                <% for(int i=1950; i<=2010; i++){ %>
                    <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            <% } else if (nullCheck) { %>
                    <option value="<%= hs.getAttribute("year") %>"><%= hs.getAttribute("year") %></option>
            <% } else { %>
                <option value="">----</option>
                <% for(int i=1950; i<=2010; i++){ %>
                    <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            <% } %>
        </select>年
        <select name="month">
            <% if ("".equals(hs.getAttribute("month"))) { %>
                <option value="">--</option>
                <% for(int i = 1; i<=12; i++){
                    if(i < 10) { %>
                        <option value="<%= "0" + i %>"><%= "0" + i %></option>
                    <% } else { %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                <% } %>
            <% } else if (nullCheck){ %>
                    <option value="<%= hs.getAttribute("month") %>"><%= hs.getAttribute("month") %></option>
            <% } else { %>
                <option value="">--</option>
                <% for(int i = 1; i<=12; i++){
                    if(i < 10) { %>
                        <option value="<%= "0" + i %>"><%= "0" + i %></option>
                    <% } else { %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                <% } %>
            <% } %>
        </select>月
        <select name="day">
            <% if ("".equals(hs.getAttribute("day"))) { %>
                <option value="">--</option>
                <% for(int i = 1; i<=31; i++){
                    if (i < 10) { %>
                        <option value="<%= "0" + i %>"><%= "0" + i %></option>
                    <% } else { %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                <% } %>
            <% } else if (nullCheck) { %>
                <option value="<%= hs.getAttribute("day") %>"><%= hs.getAttribute("day") %></option>
                <option value="">--</option>
                <% for(int i = 1; i<=31; i++){
                    if (i < 10) { %>
                        <option value="<%= "0" + i %>"><%= "0" + i %></option>
                    <% } else { %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                <% } %>
            <% } else { %>
                <option value="">--</option>
                <% for(int i = 1; i<=31; i++){
                    if (i < 10) { %>
                        <option value="<%= "0" + i %>"><%= "0" + i %></option>
                    <% } else { %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                <% } %>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" checked>エンジニア<br>
        <input type="radio" name="type" value="2">営業<br>
        <input type="radio" name="type" value="3">その他<br>
        <br>

        電話番号:
        <% if (nullCheck) { %>
        <input type="text" name="tell" value="<%= hs.getAttribute("tell") %>">
        <% } else { %>
            <input type="text" name="tell" value="">
        <% } %>
        <br><br>

        自己紹介文
        <br>
        <% if (nullCheck) { %>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= hs.getAttribute("comment") %></textarea>
            <br><br>
        <% } else { %>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"></textarea><br><br>
        <% } %>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
        
    </form>
        <br>
        <%= JumsHelper.getInstance().home() %>
    </body>
</html>
