<%-- 
    Document   : usrprof
    Created on : 2017/07/06, 17:16:12
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
        <%
            //取得する文字コードを指定
            request.setCharacterEncoding("UTF-8");

            //送られてきたユーザー名を取得　ここから
            //名前を取得
            String usrName;
            usrName = request.getParameter("name");

            //ユーザ名のセッションを取得
            HttpSession usrNameHs = request.getSession();
            //セッションにユーザーの名前を登録
            usrNameHs.setAttribute("usrname", usrName);
            String usrname = (String) usrNameHs.getAttribute("usrname");

            //フォームから性別を取得
            String valsex;
            valsex = request.getParameter("sex");

            //性別のセッションを取得
            HttpSession sexHs = request.getSession();
            //セッションに性別を登録
            sexHs.setAttribute("sex", valsex);
            String sex = (String) sexHs.getAttribute("sex");
            //送られて来た値の確認用
            //out.print("「" + sex + "」<br>");

            String male = "";
            String female = "";
            String none = "";

            if (valsex.equals("male")) {
                male = "checked";
            } else if (valsex.equals("female")) {
                female = "checked";
            }else if (valsex.equals("")){
                none = "checked";
            }
            
            //条件分岐後の値、確認用
            //out.print(male);
            //out.print(female);
            //out.print(none);

            //フォームから趣味を取得
            String usrHobby;
            usrHobby = request.getParameter("hobby");

            //セッションにユーザーの趣味を登録
            HttpSession usrHobbyHs = request.getSession();
            usrHobbyHs.setAttribute("usrhobby", usrHobby);
            String usrhobby = (String) usrHobbyHs.getAttribute("usrhobby");

        %>

        <div class="usrprof">

            <h1>登録フォーム</h1>

            <form action="usrprof.jsp" method="post">
                <!--名前入力フォーム-->
                <div class="name">
                    <span>お名前：</span>
                    <input class="name" type="text" name="name" size="40" maxlength="50" value=<%
                        if (usrname.equals("")) {
                            out.print("ここに名前を入力してください");
                        } else {
                            out.print(usrname);
                        }
                           %>
                           ><br>
                </div>
                <!--性別選択フォーム-->
                <div class="sex">       
                    <span>性別：</span>
                    <input type="radio" name="sex" value="male" <%=male%>/>男
                    <input type="radio" name="sex" value="female" <%=female%>/>女
                    <input type="radio" name="sex"value="" style="display: none;" <%=none%>/>
                </div>

                <div class="hobby">
                    <span>ご感想：</span>
                    <textarea name="hobby" rows="4" cols="40" ><%

                        if (usrhobby.equals("")) {
                            out.print("ここに趣味を入力してください");
                        } else {
                            out.print(usrhobby);
                        }

                        %></textarea>
                </div>

                <input type="submit" value="送信"><br>

            </form>

        </div>

    </body>
</html>
