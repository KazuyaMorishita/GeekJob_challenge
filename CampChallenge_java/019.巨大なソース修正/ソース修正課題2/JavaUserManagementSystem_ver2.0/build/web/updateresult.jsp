<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.text.SimpleDateFormat"%>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) hs.getAttribute("updateUdd");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        
        <h1>変更結果</h1><br>
        
        名前:<%= udd.getName()%><br>
        生年月日:<%= sdf.format(udd.getBirthday())%><br>
        種別:<%= jh.exTypenum(udd.getType())%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        <p>以上の内容で登録しました。</p><br>
        <%=jh.home()%>
        
        <form action="">
            <%= jh.toResultDetail()%>
        </form>
        
    </body>
</html>
