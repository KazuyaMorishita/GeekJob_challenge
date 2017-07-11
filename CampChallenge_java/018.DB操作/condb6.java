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

/**
 *
 * @author kazuya
 */
public class condb6 extends HttpServlet {

    //Connection変数の宣言
    Connection db_con = null;
    //PreparedStatement変数の宣言
    PreparedStatement db_stinsr = null;
    PreparedStatement db_stsel = null;
    PreparedStatement db_stdel = null;
    ResultSet db_data = null;

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

            //mysqlへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db", "K_Morishita", "bnoratotob");

            //PreparedStatementを取得し変数db_stinsrに格納
            db_stinsr = db_con.prepareStatement("INSERT INTO profiles VALUES(?, ?, ?, ?, ?)");

            //データベースに値をセット
            db_stinsr.setInt(1, 5);
            db_stinsr.setString(2, "高橋 清");
            db_stinsr.setString(3, "090-9900-1234");
            db_stinsr.setInt(4, 24);
            db_stinsr.setString(5, "2000-12-24");

            //excuteUpdateを使用しdlstinsrを実行
            db_stinsr.executeUpdate();

            //PreparedStatementを取得し変数db_stselに格納
            db_stsel = db_con.prepareStatement("SELECT * FROM profiles");

            //executeQueryを使用しdb_stselを実行
            db_data = db_stsel.executeQuery();

            //excureQueryの実行結果を出力
            while (db_data.next()) {
                out.print(db_data.getInt("profilesID") + "<br>");
                out.print(db_data.getString("name") + "<br>");
                out.print(db_data.getString("tell") + "<br>");
                out.print(db_data.getInt("age") + "<br>");
                out.print(db_data.getString("birthday") + "<br>");
            }

            //PreparedStatementを取得し変数db_stdelに格納
            db_stdel = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID = 5");
            
            //executeQueryを使用しdb_stdelを実行
            db_stdel.executeUpdate();
            
            out.print("<br>削除文の実行結果<br><br>");
            
            //PreparedStatementを取得し変数db_stselに格納
            db_stsel = db_con.prepareStatement("SELECT * FROM profiles");

            //executeQueryを使用しdb_stselを実行
            db_data = db_stsel.executeQuery();

            //excureQueryの実行結果を出力
            while (db_data.next()) {
                out.print(db_data.getInt("profilesID") + "<br>");
                out.print(db_data.getString("name") + "<br>");
                out.print(db_data.getString("tell") + "<br>");
                out.print(db_data.getInt("age") + "<br>");
                out.print(db_data.getString("birthday") + "<br>");
            }

        } catch (SQLException se_con) {

            System.out.println("SQL接続失敗" + se_con.getMessage());

        } catch (Exception e_con) {

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
