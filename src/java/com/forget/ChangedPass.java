/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forget;

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
@WebServlet(name = "ChangedPass", urlPatterns = {"/ChangedPass"})
public class ChangedPass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session=request.getSession();
        
         if (session.getAttribute("email") == null) {
                response.sendRedirect("index.html");
            }
         else{
        String mail=(String) session.getAttribute("recoveredmail");
        String newPass=request.getParameter("changedpass");
        Dao dao=new Dao();
        boolean check=dao.changePassword(mail, newPass);
        dao.close();
        if (check) {
            response.sendRedirect("Home");
        }
        else{
            response.sendRedirect("error.html");
        }
         }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
