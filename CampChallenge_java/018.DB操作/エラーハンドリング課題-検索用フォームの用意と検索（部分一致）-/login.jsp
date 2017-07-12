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
            <h1>ログイン画面</h1><br>
            
            <form action="Condb_Srch" method="post">
                
                <p>名前：<input type="text" name="name" size="30"></p>
                <input type="submit" value="送信">
                
            </form>
            
        </div>
    </body>
</html>
