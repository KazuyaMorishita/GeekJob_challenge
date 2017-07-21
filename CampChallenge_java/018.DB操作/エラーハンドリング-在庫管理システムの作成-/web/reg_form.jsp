<%-- 
    Document   : reg
    Created on : 2017/07/18, 16:20:43
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
        <div class="reg_contents">
            
            <h1>商品登録画面</h1>
            
            <form action="RegChk" method="post">
                
                <div class="form_style">
                    <div class="label"><label>商品名：</label></div>
                    <div class="input">
                        <input type="text" name="name" size="30" placeholder="商品名を入力してください" required>
                    </div>
                    <div class="clearboth"></div>
               </div>
                    
                <div class="form_style">
                    <div class="label"><label>レーベル：</label></div>
                    <div class="input">
                        <input type="text" name="label" size="30" placeholder="レーベルを入力してください" required>
                    </div>
                    <div class="clearboth"></div>
               </div>
                
                <div class="form_style">
                    <div class="label"><label>商品数：</label></div>
                    <div class="input">
                        <input type="text"  name="stock" size="30" pattern="^[0-9A-Za-z]+$" placeholder="商品数を入力してください" required>
                    </div>
                    <div class="clearboth"></div>
                </div>
                
                <div class="form_style">
                    <div class="input">
                        <input type="submit" value="登録確認">  
                    </div>
                </div>
                
            </form>
            
        </div>
    </body>
</html>
