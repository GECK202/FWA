package edu.school21.cinema.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    // в случае GET-запроса следует просто отдать страницу home
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }

    // обработка запроса, который должен поменять цвет заголовка
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем параметр запроса
        String color = req.getParameter("color");
        // создаем Cookie с данным значением
        Cookie colorCookie = new Cookie("color", color);
        // кладем в ответ
        resp.addCookie(colorCookie);
        // перенаправляем пользователя обратно на страницу home
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
