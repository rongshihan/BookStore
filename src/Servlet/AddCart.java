package Servlet;

import DAO.BookDAO;
import DAO.Factory;
import DAO.OrderDAO;
import Entity.Book;
import Entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
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
                String book_id = req.getParameter("book_id");
                String number = req.getParameter("book_number");
                int stutas = 0;
                Date time = new Date(System.currentTimeMillis());

                BookDAO bookDAO = Factory.getBookDAO();

                Book book = bookDAO.findById(Integer.parseInt(book_id));

                Order order = new Order();
                order.setUser_id(Integer.parseInt(userid));
                order.setUser_name(username);
                order.setBook_id(Integer.parseInt(book_id));
                order.setBook_name(book.getName());
                order.setBook_number(Integer.parseInt(number));
                order.setGoods_price(Integer.parseInt(number) * book.getPrice());
                order.setStatus(stutas);
                order.setTime(time);

                OrderDAO orderDAO = Factory.getOrderDAO();
                if (orderDAO.insert(order)) {
                    req.setAttribute("succeed", "提交成功");
                    req.getRequestDispatcher("/purchase_succeed.jsp").forward(req, resp);
                } else {
                    req.setAttribute("fail", "提交失败");
                    req.getRequestDispatcher("/purchase_fail").forward(req, resp);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
