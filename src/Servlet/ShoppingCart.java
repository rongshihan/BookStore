package Servlet;

import DAO.BookDAO;
import DAO.CartDAO;
import DAO.Factory;
import DAO.OrderDAO;
import Entity.Book;
import Entity.Cart;
import Entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/shopping_cart")
public class ShoppingCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userid = session.getAttribute("userid").toString();
        String username = session.getAttribute("username").toString();

        CartDAO cartDAO = Factory.getCartDAO();
        List<Cart> carts = cartDAO.findAllByUserId(Integer.parseInt(userid));

        req.setAttribute("carts", carts);
        req.getRequestDispatcher("/shopping_cart.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
