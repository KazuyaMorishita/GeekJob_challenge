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
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kazuya
 */
public class Condb_UD extends HttpServlet {
    
    Connection db_con = null;
    PreparedStatement db_stsel_bfr = null;
    PreparedStatement db_stsel_aft = null;
    PreparedStatement db_stud = null;
    ResultSet db_rs_bfr = null;
    ResultSet db_rs_aft = null;
    

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
            
            HttpSession hs = request.getSession();
            
            //sessionから値を取得
            int usrid = (int)hs.getAttribute("usrid");
            String usrname = (String)hs.getAttribute("usrname");
            String usrtel = (String)hs.getAttribute("usrtel");
            int usrage = (int)hs.getAttribute("usrage");
            String usrbir = (String)hs.getAttribute("usrbir");
            
            //mysqlへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GEEKJOB_db", "K_Morishita", "bnoratotob");
            
            //preparedstatementにsql文を格納
            db_stsel_bfr = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = ?");
            db_stsel_bfr.setInt(1, usrid);
            
            //sql文を実行し、resuleset変数に返却された値を格納
            db_rs_bfr = db_stsel_bfr.executeQuery();
            
            //変更前のプロフィールを表示
            out.print("<p>変更前ユーザー情報</p><br>");
            while (db_rs_bfr.next()){
                out.print("ID：" + db_rs_bfr.getInt("profilesID") + "<br>");
                out.print("名前：" + db_rs_bfr.getString("name") + "<br>");
                out.print("電話番号：" + db_rs_bfr.getString("tell") + "<br>");
                out.print("年齢：" + db_rs_bfr.getInt("age") + "<br>");
                out.print("生年月日：" + db_rs_bfr.getString("birthday") + "<br>");
                out.print("<br>");
            }
            
            db_stud = db_con.prepareStatement("UPDATE profiles SET name = ?, tell = ?, age = ?, birthday = ? WHERE profilesID = ?");
            db_stud.setString(1,usrname);
            db_stud.setString(2,usrtel);
            db_stud.setInt(3,usrage);
            db_stud.setString(4, usrbir);
            db_stud.setInt(5,usrid);
            
            db_stud.executeUpdate();
            
            db_stsel_aft = db_con.prepareStatement("SELECT * FROM profiles WHERE profilesID = ?");
            db_stsel_aft.setInt(1, usrid);
            
            db_rs_aft = db_stsel_aft.executeQuery();
            
            //変更後のプロフィールを表示
            out.print("<br><p>変更後ユーザー情報</p><br>");
            while (db_rs_aft.next()){
                out.print("ID：" + db_rs_aft.getInt("profilesID") + "<br>");
                out.print("名前：" + db_rs_aft.getString("name") + "<br>");
                out.print("電話番号：" + db_rs_aft.getString("tell") + "<br>");
                out.print("年齢：" + db_rs_aft.getInt("age") + "<br>");
                out.print("生年月日：" + db_rs_aft.getString("birthday") + "<br>");
                out.print("<br>");
            }
            
            
        }catch (SQLException e_con) {

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
