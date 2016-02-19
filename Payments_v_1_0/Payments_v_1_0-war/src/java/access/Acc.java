/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lartsev
 */
@WebServlet("/Acc")
public class Acc extends HttpServlet {
    
    public Acc() {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        
        String authType = request.getAuthType();
        String usr = request.getParameter("username");
        String pwd = request.getParameter("username");
        
        
        
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"> ");
        out.println("<title>Title</title>");
        out.println("</head><body>");
        
        out.println("<h1>"+"Hi, " + usr +"</h1>");
        out.println("<h1>"+"your password is " + pwd +"</h1>");
        out.println("<h1>"+"your AuthType is "+authType+"</h1>");
        
        out.println("</body></html>");
    }
}
