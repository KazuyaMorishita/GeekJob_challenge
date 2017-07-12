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
public class Condb_Srch extends HttpServlet {
    
    //Connection変数の宣言
    Connection db_con = null;
    //PreparedStatement変数の宣言
    PreparedStatement db_stsel = null;
    //ResultSetの変数を宣言
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
            
            //受け取るパラメーターの文字コードを指定
            request.setCharacterEncoding("UTF-8");
            
            //受け取った値を格納するための変数を宣言
            String name = "";
            //送られてきた値を受け取り、変数に格納
            name = request.getParameter("name");
            //確認用
            out.print("formから取得した値「" + name + "」<br>");
            
            //Sessionの取得
            HttpSession hs = request.getSession();
            
            //Sessionへデータを書き込み
            hs.setAttribute("usrname", name);
            
            //Sessionからデータを取得
            String usrname = (String)hs.getAttribute("usrname");
            //確認用
            out.print("Sessionに格納した後、取得した値「" + usrname + "」");
            
            //mysqlへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db", "K_Morishita", "bnoratotob");
            
            //prepareStatementを取得し、db_stselに格納
            db_stsel = db_con.prepareStatement("SELECT * FROM profiles WHERE name LIKE ?");
            db_stsel.setString(1, "%" + name + "%");
            //excutQueryを使用しdb_stselを実行、取得した値をdb_dataに格納
            db_data = db_stsel.executeQuery();
            
            //db_data内の値を確認
            while (db_data.next()){
            
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
