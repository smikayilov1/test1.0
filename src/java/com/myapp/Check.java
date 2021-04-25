/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp;

import com.aut.Email;
import com.data.Dao;
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
@WebServlet(name = "Check", urlPatterns = {"/Check"})
public class Check extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        String email=request.getParameter("email");
        PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession();
        session.setAttribute("name",name);
        session.setAttribute("password",password);
        session.setAttribute("password2",password2);
        session.setAttribute("email",email);
        Dao dao=new Dao();
        boolean check=dao.check(email);
         if (!password.equals("") && !password2.equals("")&& !name.equals("") && !email.equals("") && password.equals(password2)
           &&  check==false     ){
             Email send=new Email();
             int number=send.generateNumber();
             send.send(email, number);
             session.setAttribute("number",number);
             response.sendRedirect("authentication.jsp");
        }
         else {
            response.sendRedirect("error.html");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
