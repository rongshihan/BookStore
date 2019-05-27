package Servlet;

import DAO.Factory;
import DAO.UserDAO;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class Selinfo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession() == null) {
            req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("userid") == null) {
                req.getRequestDispatcher("/signin.jsp").forward(req, resp);
            } else {
                String userid = session.getAttribute("userid").toString();
                String username = session.getAttribute("username").toString();

                UserDAO userDAO = Factory.getUserDAO();
                User user = userDAO.findById(Integer.parseInt(userid));

                req.setAttribute("userid", userid);
                req.setAttribute("username", username);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/selinfo.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
