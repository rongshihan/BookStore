package Servlet;

import DAO.CartDAO;
import DAO.Factory;
import Entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/purchase_record")
public class purchase_record extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userid = session.getAttribute("userid").toString();
        String username = session.getAttribute("username").toString();

        CartDAO cartDAO = Factory.getCartDAO();
        List<Cart> carts = cartDAO.findStatus1(Integer.parseInt(userid));

        req.setAttribute("carts", carts);
        req.getRequestDispatcher("/purchase_record.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
