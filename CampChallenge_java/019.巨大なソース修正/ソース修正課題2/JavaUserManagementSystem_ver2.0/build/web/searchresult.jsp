<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="java.sql.Timestamp"
        import="java.text.SimpleDateFormat"
        import="jums.UserDataBeans"
        import="java.util.ArrayList"%>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> alUdd = (ArrayList<UserDataDTO>)hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        
        <h1>検索結果</h1>
        
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <% for (UserDataDTO result : alUdd) { %>
            <tr>
                <td><a href="ResultDetail?id=<%= result.getUserID()%>"><%= result.getName()%></a></td>
                <td><%= result.getBirthday()%></td>
                <td><%= jh.exTypenum(result.getType())%></td>
                <td><%= jh.exTimestamp(result.getNewDate())%></td>
            </tr>
            <% }%>
        </table>
        <%= jh.home()%>
        <%= jh.toSerch()%>
    </body>

</html>
