/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp;

import com.data.Dao;
import com.files.QDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Expires","0");
        QDao dao = new QDao();
        List answer = new ArrayList();
        List questions = new ArrayList();
        Set<Integer> numbers = new LinkedHashSet<>();
        dao.generateRange(numbers);
        dao.readAnswers(numbers, answer);
        dao.readQuestion(numbers, questions);
        dao.close();
        HttpSession session = request.getSession();
        
        if (session.getAttribute("email")==null) {
            response.sendRedirect("index.html");
        }
        else{
        session.setAttribute("questions", questions);
        session.setAttribute("answers", answer);
        session.setAttribute("questionsNumbers", numbers);
        response.sendRedirect("home.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Expires","0");
        request.setCharacterEncoding("UTF-8");
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(request.getParameter(String.valueOf(i)));

        }
        QDao dao = new QDao();
        int result = dao.checkQuestions(list);
        dao.close();
        HttpSession session = request.getSession();
        String check="Temp";
        Dao d=new Dao();
        String mail=(String) session.getAttribute("email");
        String name=d.selectName(mail);
        d.storeRank(name, result);
        d.close();
        session.setAttribute("name", name);
        session.setAttribute("check",check);
        session.setAttribute("result", result);
        response.sendRedirect("result.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
