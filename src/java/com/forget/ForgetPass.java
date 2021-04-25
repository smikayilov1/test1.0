/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forget;

import com.aut.Email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author smikayilov
 */
@WebServlet(name = "ForgetPassword", urlPatterns = {"/ForgetPass"})
public class ForgetPass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail=request.getParameter("fmail");
        Email email=new Email();
        int numberForget=email.generateNumber();
        HttpSession session=request.getSession();
         if (session.getAttribute("email") == null) {
                response.sendRedirect("index.html");
            }
         else{
        session.setAttribute("numberForget", numberForget);
        email.send(mail, numberForget);
        response.sendRedirect("forgetpass.jsp");
         }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
