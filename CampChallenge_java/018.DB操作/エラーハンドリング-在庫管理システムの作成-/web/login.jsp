<%-- 
    Document   : login
    Created on : 2017/07/18, 13:21:08
    Author     : kazuya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpServlet"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="login_contents">

            <h1>ログイン画面</h1>

            <%
                HttpSession hs = request.getSession();
                String check = (String) hs.getAttribute("statas");
                if ("not_auth".equals(check)) {
                    out.print("認証失敗<br>");
                }
            %>

            <form action="LoginChk" method="post">

                <div class="form_style">


                    <div class="label"><label>名前：</label></div>
                    <div class="input">
                        <input type="text" name="name" size="30" placeholder="名前を入力してください" required>
                    </div>
                    <div class="clearboth"></div>
                </div>

                <div class="form_style">
                    <div class="label"><label>パスワード：</label></div>
                    <div class="input">
                        <input type="text"  name="pass" size="30" pattern="^[0-9]+$" placeholder="Passwordを入力してください" required>
                    </div>
                    <div class="clearboth"></div>
                </div>

                <div class="form_style">
                    <div class="input">
                        <input type="submit" value="ログイン">
                    </div>
                </div>

            </form>


        </div>

    </body>
</html>
