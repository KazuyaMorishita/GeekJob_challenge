<%-- 
    Document   : rgtrform
    Created on : 2017/07/06, 16:09:53
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
        <div class="usrprof">

            <h1>登録フォーム</h1>

            <form action="./usrprof.jsp" method="post">
                <!--名前入力フォーム-->
                <div class="name">
                    <span>お名前：</span>

                    <input class="name" type="text" name="name" size="40" maxlength="50" value="ここに名前を入力してください"><br>
                </div>
                <!--性別選択フォーム-->
                <div class="sex">
                    <span>性別：</span>
                    <input type="radio" name="sex" value="male"/>男
                    <input type="radio" name="sex" value="female"/>女
                    <input type="radio" name="sex" value="" style="display: none;" checked/>
                </div>

                <div class="hobby">
                    <span>ご感想：</span>
                    <textarea name="hobby" rows="4" cols="40">ここに趣味を書いて下さい</textarea>
                </div>

                <input type="submit" value="送信"><br>

            </form>

        </div>
    </body>
</html>
