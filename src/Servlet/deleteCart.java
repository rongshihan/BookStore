package Servlet;

import DAO.CartDAO;
import DAO.Factory;
import DAO.OrderDAO;
import Entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteCart")
public class deleteCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userid = session.getAttribute("userid").toString();
        String username = session.getAttribute("username").toString();
        String order_id = req.getParameter("order_id");

        OrderDAO orderDAO = Factory.getOrderDAO();

        if (orderDAO.delete(Integer.parseInt(order_id))) {
            CartDAO cartDAO = Factory.getCartDAO();
            List<Cart> carts = cartDAO.findAllByUserId(Integer.parseInt(userid));

            req.setAttribute("carts", carts);
            req.getRequestDispatcher("/shopping_cart.jsp").forward(req, resp);
        } else {
            CartDAO cartDAO = Factory.getCartDAO();
            List<Cart> carts = cartDAO.findAllByUserId(Integer.parseInt(userid));

            req.setAttribute("carts", carts);
            req.getRequestDispatcher("/shopping_cart.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
