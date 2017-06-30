<%-- 
    Document   : usrInfo
    Created on : 2017/06/30, 13:44:21
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
        <div class="container">

            <div class="content">

                <%
                    // 受け取るパラメータの文字コード
                    request.setCharacterEncoding("UTF-8");

                    // テキストボックスの情報
                    out.print("名前：");
                    out.print(request.getParameter("usrName") + "<br>");

                    // ラジオボタンの情報
                    String sex;
                    sex = request.getParameter("rdoBtn");
                    
                    if(sex.equals("male")){
                        out.print("性別：男<br>");
                    }else{
                        out.print("性別：女<br>");
                    }
                    
                    // テキストエリアの情報
                    out.print("趣味：");
                    out.print(request.getParameter("mulText") + "<br>");
                %>

            </div>

        </div>
    </body>
</html>
