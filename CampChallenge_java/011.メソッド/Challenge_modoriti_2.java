/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

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
public class Challenge_modoriti_2 extends HttpServlet {

    String[] usrProf() {

        //配列
        String[] prof = {"1", "森下和也", "岡山県", "生年月日"};

        return prof;

        /*
            //ユーザーID　配列
            ArrayList<String> ID = new ArrayList<String>();
                ID.add("1");
                ID.add("2");
                ID.add("3");
        
            //ユーザー名　配列
            ArrayList<String> Name = new ArrayList<String>();
            Name.add("森下和也");
            Name.add("越前引一");
            Name.add("神達昭雄");
                    
            //ユーザー生年月日　配列
            ArrayList<String> Bir = new ArrayList<String>();
                Bir.add("1988/08/16"); 
                Bir.add("1986/11/11");
                Bir.add("1987/04/06");
        
            //ユーザー住所　配列
            ArrayList<String> Adr = new ArrayList<String>();
                Adr.add("岡山県");
                Adr.add("大阪");
                Adr.add("岡山");
                
                        
            for(int i = 0;)
            
            String [] prof = {"Name.get(0)", "Bir.get(0)", "Add.get(0)"};
        
            return prof;
            
         */
    }

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
            String[] prof = usrProf();
            out.print(prof);
            out.print("<br>");

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
