/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sevelet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

public class EfetuarLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          RequestDispatcher rd = null;
        
        String login = request.getParameter("login");
        String login_senha = request.getParameter("login_senha");
        
        Usuario usuario = new Usuario(login,login_senha);
        if (login.equals("admin") && login_senha.equals("12345"))
        {
            rd = request.getRequestDispatcher("Home.xhtml");
            rd.forward(request, response);
        
        
        }
        else {
        rd = request.getRequestDispatcher("formulario-login.jsp");
        rd.forward(request, response);
        
               
                }
        
        
        
       
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alerta = "<script>\n" +
"\n" +
"    alert(\"Login ou Senha Incorreto!\");\n" +
"     \n" +
"\n" +
"</script>";
        
        RequestDispatcher rd = null;
        
        String login = request.getParameter("login");
        String login_senha = request.getParameter("login_senha");
        Usuario usuario = new Usuario(login,login_senha);
        if (login.equals("Admin") && login_senha.equals("15479123"))
        {
            rd = request.getRequestDispatcher("Home.xhtml");
            rd.forward(request, response);
        
        
        }
        else{
        rd = request.getRequestDispatcher("formulario-login.jsp");
        rd.forward(request, response);
        out.print(alerta);
        
        }
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
