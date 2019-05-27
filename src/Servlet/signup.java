package Servlet;

import DAO.Factory;
import DAO.UserDAO;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class signup extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String logname = req.getParameter("logname");
        String realname = req.getParameter("realname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        //String problem = req.getParameter("problem");
        //String answer = req.getParameter("answer");
        String province = req.getParameter("province");
        String education = req.getParameter("education");
        String hobbies = req.getParameter("hobbies");
        String selfintro = req.getParameter("selfintro");

        User user = new User();
        user.setLogname(logname);
        user.setRealname(realname);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setPhone(Integer.parseInt(phone));
        user.setProvince(province);
        user.setEducation(education);
        user.setHobbies(hobbies);
        user.setSelfintro(selfintro);

        UserDAO userDAO = Factory.getUserDAO();

        if(userDAO.insert(user)) {
            req.setAttribute("succeed","注册成功");
            req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("failure","注册失败");
            req.getRequestDispatcher("/signup.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
