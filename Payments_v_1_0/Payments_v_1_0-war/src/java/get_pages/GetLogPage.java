/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package get_pages;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lartsev
 */
@WebServlet(name = "GetLogPage", urlPatterns =  {
    "/GetLogPage"}
)

public class GetLogPage extends HttpServlet {
    
    public GetLogPage(){
        super();
    }
    
    /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //LOG OUT FROM SERVER
        HttpSession session= request.getSession();
        session.invalidate();
        RequestDispatcher requestDispather = request.getRequestDispatcher("/jsp/login.jsp");
        requestDispather.forward(request, response);
    }
    
}
