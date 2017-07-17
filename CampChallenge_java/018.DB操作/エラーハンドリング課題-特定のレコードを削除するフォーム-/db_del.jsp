<%-- 
    Document   : db_del
    Created on : 2017/07/14, 11:01:54
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
                //sessionにこのページの値を格納
                HttpSession hs = request.getSession();
                hs.setAttribute("del", "del");

            %>
            
            <h1>登録情報削除</h1><br>
            
            <form action="Condb_Sess" method="post">
                
                <p>削除するユーザーを入力してください</p>
                <p>ID：<input type="text" name="id"><br>
                <input type="hidden" name="age" size="30" value="-1">

                <input type="submit" value="登録情報削除">
            
            </form>
            
        </div>
    </body>
</html>
