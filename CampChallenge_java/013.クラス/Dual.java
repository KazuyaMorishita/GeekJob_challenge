/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kazuya
 */
public class Dual extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //クラス「Dealer」をインスタンスし、初期処理でトランプ54枚を生成
            Dealer dealer = new Dealer();
            //クラス「User」をインスタンス
            User user = new User();

            //引数の要素数を計算しmyCardsへ要素数分の要素の値を追加する
            dealer.setCard(dealer.deal());
            
            //メソッド「deal」を呼び出し戻り値としてuser分の手札2枚をセット
            user.setCard(dealer.deal());

            //セットされた値を表示（※確認用）
            out.println("---------------------------------------<br>ディーラーの初期ステータス" + dealer.myCards + "<br><br>");
            out.println("プレイヤーの初期ステータス" + user.myCards + "<br>---------------------------------------<br><br>");
            
            //checkSumでチェックされた値がtrueかfalseかを確認
            //out.print(dealer.checkSum() + "<br>");
            //out.print(user.checkSum() + "<br>");
            
            //ディーラーの手札を確認し戻り値として返されたtrueかfalseを表示
            if (dealer.checkSum() == true) {
                for (int i = 0; dealer.open() <= 17; i++) {
                    dealer.setCard(dealer.hit());
                    out.print("ディーラーが力を蓄えている<br>");
                }
            } else {
                out.print("ディーラーが自身にダメージ<br>");
            }
            out.println("ディーラーのステータスが上がった" + dealer.myCards + "<br><br>");

        
            //プレイヤーの手札を確認し戻り値として返されたtrueかfalseを表示
            if (user.checkSum() == true) {
                
                for(int i = 0; user.open() <= 16; i++){
                    user.setCard(dealer.hit());
                    out.print("プレイヤーが力を蓄えている<br>");
                }
            } else {
                out.print("プレイヤーが自身にダメージ。<br>");
            }
            out.println("プレイヤーのステータスが上がった" + user.myCards + "<br><br>");
            
            //各openメソッドよ呼び出しディーラーとプレイヤーの手札の合計値を表示
            out.print("ディーラーのステータス" + dealer.open() + "<br>" );
            out.print("プレイヤーのステータス" + user.open() + "<br><br>");
            
            out.print("-------------------------------------------------<br>");
            
            //勝利条件を指定ディーラーとプレイヤーの手札の合計値を表示する
            //プレイヤーが21を超えて（bust）した場合は無条件でディーラーの勝ち
            if (user.open() > 21){
                
                out.print("プレイヤーが自滅した<br>テテテテーテーテーテッテレー<br>ディーラーは100pの経験値を得た");
                        //ディーラーとプレイヤーの値が同じ場合は引き分け
            
            }else if(user.open() == dealer.open()){
                
                out.print("引き分けてしまった");
                
            }else if (user.open() <= 21 && dealer.open() > 21){
            
                out.print("ディーラーが自滅した<br>テテテテーテーテーテッテレー<br>プレイヤーは100pの経験値を得た");
            
            }else if (user.open() < 21 && dealer.open() == 21){
            
                out.print("プレイヤーに会心の一撃<br>テテテテーテーテーテッテレー<br>ディーラーは100pの経験値を得た");
            
            }else if (dealer.open() < 21 && user.open() == 21){
            
                out.print("ディーラーに会心の一撃<br>テテテテーテーテーテッテレー<br>プレイヤーは100pの経験値を得た");
            
            }else if (user.open() < dealer.open()){
            
                out.print("プレイヤーにダメージを与えた<br>テテテテーテーテーテッテレー<br>ディーラーは50pの経験値を得た");
            
            }else if (dealer.open() < user.open()){
            
                out.print("ディーラーにダメージを与えた<br>テテテテーテーテーテッテレー<br>プレイヤーは50pの経験値を得た");
            
            }

            
            out.print("<br>-------------------------------------------------<br>");
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
