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
import javax.servlet.http.HttpSession;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author kazuya
 */
public class LoginChk extends HttpServlet {

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

            //変数宣言
            Connection db_con = null;
            PreparedStatement pstSel = null;
            ResultSet rs = null;

            HttpSession session = request.getSession();
            session.invalidate();
            
            //文字コードをセット
            request.setCharacterEncoding("UTF-8");

            String name = request.getParameter("name");
            String strpass = request.getParameter("pass");
            int pass = Integer.parseInt(strpass);

            HttpSession hs = request.getSession();

            hs.setAttribute("formname", name);
            hs.setAttribute("formpass", pass);

            String formname = (String) hs.getAttribute("formname");
            int formpass = (int) hs.getAttribute("formpass");

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "K_Morishita", "bnoratotob");

            pstSel = db_con.prepareStatement("select name, pass from usrprof where name = ? && pass = ?");
            pstSel.setString(1, formname);
            pstSel.setInt(2, formpass);
            rs = pstSel.executeQuery();

            String usrname = "";
            int usrpass = -1;
            while (rs.next()) {
                usrname = rs.getString("name");
                usrpass = rs.getInt("pass");
            }
            
            String check;
            String a = "";
            if (formname.equals(usrname) && formpass == usrpass) {
                check = "auth";
                RequestDispatcher dispatch = request.getRequestDispatcher("/select.jsp");
                dispatch.forward(request, response);
                hs.setAttribute("login", check);
            } else {
                check = "not_auth";
                hs.setAttribute("statas", check);
                a = (String)hs.getAttribute("statas");
                RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
                dispatch.forward(request, response);

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
