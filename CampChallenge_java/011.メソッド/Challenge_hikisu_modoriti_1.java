/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kazuya
 */
public class Challenge_hikisu_modoriti_1 extends HttpServlet {

    //メソッド　ここから
    /*
    String [] usrprof 
    
    String [] usr1 = {"ID:1", "森下和也", "1988/08/16", "岡山県"};
    String [] usr2 = {"ID:2", "越前引一", "1988/08/16", "岡山県"};
    String [] usr3 = {"ID:3", "中山和也", "1988/08/16", "岡山県"};
     */
    String[] usrProf(int UsrID) {

        int ID = UsrID;

        String[][] usr = {
            {"1", "森下和也", "1988/08/16", "岡山県"},
            {"2", "越前引一", "1986/11/11", "大阪府"},
            {"3", "中山和也", "1987/3/20", "岡山県"}
        };

        for (int i = 0; i < usr.length; i++) {
            String[] prof = usr[i];
            if (Integer.parseInt(prof[0]) == UsrID) {
                return prof;
            }
        }

        /*
        //ユーザーID　配列
        ArrayList<String> usr1 = new ArrayList<String>();
        usr1.add("1");
        usr1.add("森下和也");
        usr1.add("1988/08/16");
        usr1.add("岡山県");
        
        //ユーザー名　配列
        ArrayList<String> usr2 = new ArrayList<String>();
        usr2.add("2");
        usr2.add("越前引一");
        usr2.add("1986/11/11");
        usr2.add("大阪府");
        
        //ユーザー生年月日　配列
        ArrayList<String> usr3 = new ArrayList<String>();
        usr3.add("3");
        usr3.add("中山和也");
        usr3.add("1988/3/20");
        usr3.add("岡山県");
         */
        
        return null;

    }

    //メソッド　ここまで
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

            int UsrID = 2;
            String[] prof = usrProf(UsrID);
            for (int i = 1; i < prof.length; i++) {
                // 配列からi番目の要素を取得
                out.print(prof[i]);
                out.print("<br>");
            }
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
