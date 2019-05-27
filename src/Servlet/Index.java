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
import java.util.List;

@WebServlet("/index")
public class Index extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        if(req.getSession() == null){
            req.setAttribute("username","登录");
        }
        else {
            HttpSession session = req.getSession();
            if(session.getAttribute("username") == null){
                req.setAttribute("username","登录");
            }
            else {
                String username = session.getAttribute("username").toString();
                req.setAttribute("username",username);
            }
        }

        BookDAO bookDAO = Factory.getBookDAO();

        List<Book> books = bookDAO.findAll();


        req.setAttribute("book",books);
        req.getRequestDispatcher("/home.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
