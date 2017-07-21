/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kazuya
 */
public class itemList extends HttpServlet {
    
    Connection db_con = null;
    PreparedStatement pstmtSel = null;
    ResultSet rs = null;

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
        try {
            
            //mysqlへの接続を取得
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "K_Morishita", "bnoratotob");
            
            //preparestatementにaql文を格納
            pstmtSel = db_con.prepareStatement("SELECT * FROM items;");
            //sql文を実行しresultset変数に値を格納
            rs = pstmtSel.executeQuery();
            
//            //arraylistをインスタンス化し、rs_id変数を宣言
//            ArrayList<Integer> rs_id = new ArrayList<Integer>();
//            //arraylistをインスタンス化し、rs_name変数を宣言
//            ArrayList<String> rs_name = new ArrayList<String>();
//            //arraylistをインスタンス化し、rs_label変数を宣言
//            ArrayList<String> rs_label = new ArrayList<String>();
//            //arraylistをインスタンス化し、rs_stock変数を宣言
//            ArrayList<Integer> rs_stock = new ArrayList<Integer>();
            
            RS_itemList rs_item = new RS_itemList();
            rs_item.setRsdata(rs);
            request.setAttribute("rsData", rs_item);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemLi_print.jsp");
            rd.forward(request, response);
            
        }catch (SQLException se_con) {

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
