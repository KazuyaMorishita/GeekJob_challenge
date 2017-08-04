<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("detailData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        
        <h1>更新情報入力画面</h1>
        
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%= udd.getName()%>">
            <br><br>
            生年月日:　
            <select name="year">
                <option value="">----</option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>" <% if (i == jh.exYear(udd.getBirthday())) {
                        out.print("selected");
                    }%>><%=i%></option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>" <% if (i == jh.exMonth(udd.getBirthday())) {
                        out.print("selected");
                    }%>><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>" <% if (i == jh.exDay(udd.getBirthday())) {
                        out.print("selected");
                    }%>><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%= i%>" <% if (udd.getType() == i) {
                    out.print("checked");
                }%>>
            <%= jh.exTypenum(i)%><br>
            <% }%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%= udd.getTell()%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udd.getComment()%></textarea>
            <br><br>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="更新">
            
        </form>
        <br>
        <%=jh.home()%><br>
        <%= jh.toSerch()%><br>
        <%= jh.toSerchResult()%><br>
        <%= jh.toResultDetail()%>
    </body>
</html>
