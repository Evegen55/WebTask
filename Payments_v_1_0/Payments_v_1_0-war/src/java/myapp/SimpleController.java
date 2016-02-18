/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lartsev
 */
public class SimpleController extends HttpServlet {
    /*
    @see http://stackoverflow.com/questions/285793/what-is-a-serialversionuid-and-why-should-i-use-it
    */
    private static final long serialVersionUID = 1L;
    
    public SimpleController() {
        super();
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        response.setContentType("text/html");
        
        String login = request.getParameter("username");
        String pwd = request.getParameter("password");
        
        
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
        out.println("<title>Tits</title>");
        out.println("</head><body>");
        out.println("<h1>"+login+"</h1>");
        out.println("<h1>"+pwd+"</h1>");
        out.println("</body></html>");
        
    }
}
