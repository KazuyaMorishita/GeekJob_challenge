<%-- 
    Document   : sumMoney
    Created on : 2017/07/03, 19:52:31
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
            
        //　取得する値の文字コードを指定
        request.setCharacterEncoding("UTF-8");
        
        //取得した値によって条件を分岐
        
        //送られて来た情報を取得
        String val;
        val = request.getParameter("items");
        
        //取得した値で条件を指定
        if(val.equals("1")){
            out.print("雑貨<br>");
        }else if(val.equals("2")){
            out.print("生鮮食品<br>");
        }else if(val.equals("3")){
            out.print("その他<br>");
        }
        
        //送られてきた値（総額）を取得し変数に格納
        String strTorMoney;
        strTorMoney = request.getParameter("tormoney");
        //String型からint型に型変換
        int torMoney = Integer.parseInt(strTorMoney);
        
        //受け取った値（総額）を表示
        out.print("総額は「" + torMoney + "円」です。<br>");
        
        //送られてきた値（総額）を取得し変数に格納
        String strNum;
        strNum = request.getParameter("num");
        //String型からint型に型変換
        int num = Integer.parseInt(strNum);
        
        //受け取った値（個数）を表示
        out.print("購入した商品の個数は「" + num + "個」です<br>");
        
        //商品１個あたりの金額計算
        int item = torMoney / num;
        //商品一個あたりの金額を表示
        out.print("商品1個あたりの金額は「" + item + "円」です<br>");
        
        //総額に応じたポイントを計算（3000円以上で4%、5000円以上で5%）
        //購入に応じたポイントを表示
        if(torMoney >= 5000){
            int pointA = torMoney * 5 / 100;
            out.print("ポイントは" + pointA + "円」です");
        }else if(torMoney >= 3000){
            //(5 / 100)この計算式だと括弧の計算結果が「0.05」にるため、少数点を切り上がられ0となってしまい、
            //結果としてtorMoneyとの計算結果が0になってしまう。
            //int pointB = torMoney * (5 / 100);
            //こちらが正しい式
            int pointB = torMoney * 4 / 100;
            out.print("ポイントは「" + pointB + "円」です");
        }
        
        %>
    </body>
</html>
