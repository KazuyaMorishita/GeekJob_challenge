/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kazuya
 */
public class Condb_Rgtr extends HttpServlet {

    Connection db_con = null;
    PreparedStatement db_stinsr = null;
    PreparedStatement db_stsel = null;
    ResultSet db_rs = null;
    PreparedStatement db_stsel2 = null;
    ResultSet db_rs2 = null;
    

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

            //セッションの取得
            HttpSession hs = request.getSession();

            //sessionから値を取得
            String usrname;
            usrname = (String) hs.getAttribute("usrname");
            String usrtel;
            usrtel = (String) hs.getAttribute("usrtel");
            int usrage;
            usrage = (int)hs.getAttribute("usrage");
            String usrbir;
            usrbir = (String) hs.getAttribute("usrbir");

            //mysqlへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db", "K_Morishita", "bnoratotob");

            //preparedstatementを取得しselect文をdb_stinsrに格納
            db_stinsr = db_con.prepareStatement("INSERT INTO profiles(name, tell, age, birthday) VALUES(?, ?, ?, ?)");
            //preparestatementの?へ値を指定
            db_stinsr.setString(1, usrname);
            db_stinsr.setString(2, usrtel);
            db_stinsr.setInt(3, usrage);
            db_stinsr.setString(4, usrbir);

            //executeUpeateを使用しdb_insr変数を実行
            db_stinsr.executeUpdate();
            
            //preparedstatementを取得しselect文をdb_stselに格納
           db_stsel = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = (SELECT MAX(profilesID) FROM profiles)");
           //executeQueryを使用してdb_selを実行し、resultset変数に返却された値を格納
           db_rs = db_stsel.executeQuery();
           
           
           out.print("<h1>登録が完了しました。</h1>");
           //resultset変数に格納された値を表示
           while (db_rs.next()){
               
                out.print("ID：" + db_rs.getInt("profilesID") + "<br>");
                out.print("名前：" + db_rs.getString("name") + "<br>");
                out.print("電話番号：" + db_rs.getString("tell") + "<br>");
                out.print("年齢：" + db_rs.getInt("age") + "<br>");
                out.print("生年月日：" + db_rs.getString("birthday") + "<br>");
                out.print("<br>");                
           }

            //mysqlへの接続を切断
            db_con.close();
            db_stinsr.close();
            db_rs.close();

        } catch (SQLException e_con) {

            System.out.println("SQL接続失敗" + e_con.getMessage());

        } catch (Exception e_con){
            
            System.out.println("接続失敗" + e_con.getMessage());
        
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
