package comm.library.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import comm.library.dao.BookDAO;
import comm.library.model.Book;
import java.sql.*;

public class BookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        BookDAO bookDAO = new BookDAO(con);
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setQuantity(quantity);
        bookDAO.addBook(book);
        res.sendRedirect("dashboard.html");
    }
}
