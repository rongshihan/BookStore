package Servlet;

import DAO.BookDAO;
import DAO.Factory;
import Entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/book_detail")
public class BookDetail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession() == null) {
            req.setAttribute("username", "登录");
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("userid") == null) {
                req.setAttribute("username", "登录");
            } else {
                String userid = session.getAttribute("userid").toString();
                String username = session.getAttribute("username").toString();
                req.setAttribute("userid", userid);
                req.setAttribute("username", username);
            }
        }

        String ID = req.getParameter("ID");

        BookDAO bookDAO = Factory.getBookDAO();

        Book book = bookDAO.findById(Integer.parseInt(ID));

        if (book != null) {
            req.getSession().setAttribute("book", book);
            req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
        } else
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
