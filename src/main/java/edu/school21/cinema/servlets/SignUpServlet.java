package edu.school21.cinema.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;
import edu.school21.cinema.repositories.UsersRepositoryInMemoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        this.usersRepository = new UsersRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<User> users = usersRepository.findAll();
//        req.setAttribute("usersFromServer", users);
        //resp.sendRedirect("/cinema/login");
//        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
//        dispatcher.forward(req, resp);
        resp.getWriter().write("Hello " + req.getParameter("firstname") + " " + req.getParameter("lastname"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // вытащили данные регистрации
        String name = req.getParameter("firstname");
        String password = req.getParameter("lastname");
        // создали пользователя и сохранили его в хранилище
        //User user = new User(name, password);
        //usersRepository.save(user);
        doGet(req, resp);
    }
}
