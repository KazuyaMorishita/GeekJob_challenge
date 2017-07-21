<%-- 
    Document   : select
    Created on : 2017/07/18, 15:29:01
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LogOut" type="post">
            <input type="submit" value="ログアウト">
        </form>
        
        <div class="sel_contents">
            
            <h1>メニュー画面</h1>

            <div class="ul_style">

                <ul>
                    <li><a href="reg_form.jsp" style="color:#716246;text-decoration:none">
                            商品情報登録
                        </a>
                    </li>
                    <li><a href="http://localhost:8080/Challenge_DB/itemList" style="color:#716246;text-decoration:none">
                            商品一覧
                        </a>
                    </li>
                </ul>

            </div>

        </div>
    </body>
</html>
