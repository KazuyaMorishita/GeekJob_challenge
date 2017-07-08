<%-- 
    Document   : bunkai
    Created on : 2017/07/04, 20:07:52
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

            //取得する値の文字コードを設定
            request.setCharacterEncoding("UTF-8");

            //値を入れる変数を宣言
            String strNum;
            //送られてきた値を取得
            strNum = request.getParameter("num");
            int num = Integer.parseInt(strNum);

            //　送られてきた元の値を表示
            out.print("元の値は「" + num + "」<br>");
            out.print("素因数分解");
            // 2 で割れるだけ割り算する
            while (num % 2 == 0) {
                out.print(2);
                out.print("*");
                num = num / 2;
            }
            // 奇数で割り算していく
            for (int i = 3; i <= num; i = i + 2) {
                while (num % i == 0) {
                    out.print(i + "*");
                    num = num / i;
                }
            }
            if(num > 1){
                out.print(num);
            }

        %>

    </body>
</html>
