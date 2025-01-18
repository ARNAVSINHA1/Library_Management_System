package com.library.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.library.dao.UserDAO;
import com.library.model.User;
import java.sql.*;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Connection con=(Connection)getServletContext().getAttribute("DBConnection");
        UserDAO userDAO=new UserDAO(con);
        User user=userDAO.authenticate(username,password);
        if(user!=null) {
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            res.sendRedirect("dashboard.html");
        } else {
            res.sendRedirect("login.html?error=invalid");
        }
    }
}
