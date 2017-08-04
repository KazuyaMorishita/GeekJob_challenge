package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kazuya
 */
public class UpdateResult extends HttpServlet {

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

        //セッションスタート
        HttpSession session = request.getSession();
        UserDataDTO udd = (UserDataDTO)session.getAttribute("detailData");

        try {

            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            //フォームからの入力を取得して、UserDataBeansに格納
            UserDataBeans udb = new UserDataBeans();
            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setMonth(request.getParameter("month"));
            udb.setDay(request.getParameter("day"));
            udb.setType(request.getParameter("type"));
            udb.setTell(request.getParameter("tell"));
            udb.setComment(request.getParameter("comment"));

            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO updateUdd = new UserDataDTO();
            udb.UD2DTOMapping(updateUdd);
            updateUdd.setUserID(udd.getUserID());

            //sessionへupdateUdd変数を格納
            session.setAttribute("updateUdd", updateUdd);

            //DBへアップデート用のデータを挿入
            UserDataDAO.getInstance().update(updateUdd);

            //sessionに格納されている以下のデータを削除
            session.removeAttribute("ac");


            //更新後の詳細情報を取得しsessionに再格納（更新完了ページから詳細画面に遷移した場合の対処）
            UserDataDTO detailData = UserDataDAO.getInstance().searchByID(updateUdd);
            session.setAttribute("detailData", detailData);
            ArrayList<UserDataDTO> resultData = UserDataDAO.getInstance().search((UserDataDTO)session.getAttribute("searchData"));
            session.setAttribute("resultData", resultData);

            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);

        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
