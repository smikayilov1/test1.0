/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp;

import com.data.Dao;
import com.data.Person;
import java.io.IOException;
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
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
               
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Person person = new Person();
        person.setName(session.getAttribute("name").toString());
        person.setPassword(session.getAttribute("password").toString());
        person.setEmail(session.getAttribute("email").toString());
        Dao dao = new Dao();
        dao.writer(person);
        dao.close();
        response.sendRedirect("Home");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
