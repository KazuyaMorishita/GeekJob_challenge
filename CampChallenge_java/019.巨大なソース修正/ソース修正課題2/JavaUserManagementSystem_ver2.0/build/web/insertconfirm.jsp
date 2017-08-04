<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <div class="insertconfirmContaner">

            <% if (chkList.size() == 0) {%>
            <h1>登録確認</h1>
            <p>名前:<%= udb.getName()%></p>
            <p>生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%></p>
            <p>種別:<%= jh.exTypenum(udb.getType())%></p>
            <p>電話番号:<%= udb.getTell()%></p>
            <p>自己紹介:<%= udb.getComment()%></p>
            <p>上記の内容で登録します。よろしいですか？</p>

            <form action="insertresult" method="POST">
                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                <input type="submit" name="yes" value="はい">
            </form>

            <% } else {%>
            <h1>入力が不完全です</h1>
            <%=jh.chkinput(chkList)%>
            <% }%>

            <form action="insert" method="POST">
                <input type="submit" name="no" value="登録画面に戻る">
                <input type="hidden" name="mode" value="REINPUT">
            </form>

            <%=jh.home()%>
        </div>
    </body>
</html>
