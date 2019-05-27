package Servlet;

import DAO.BookDAO;
import DAO.Factory;
import DAO.UserDAO;
import Entity.Book;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet("/signin")
public class signin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO userDAO = Factory.getUserDAO();

        User user = userDAO.findAccount(email,password);

        if(user!=null) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(3600);
            session.setAttribute("userid",user.getID());
            session.setAttribute("username",user.getLogname());

            req.setAttribute("userid",user.getID());
            req.setAttribute("username", user.getLogname());

            BookDAO bookDAO = Factory.getBookDAO();

            List<Book> books = bookDAO.findAll();


            req.setAttribute("book",books);
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("failure","登陆失败");
            req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
