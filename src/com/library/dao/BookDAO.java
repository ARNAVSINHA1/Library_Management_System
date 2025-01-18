package com.library.dao;

import com.library.model.Book;
import java.sql.*;

public class BookDAO {

    private final Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void addBook(Book book) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO books(title,author,quantity)VALUES(?,?,?)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public ResultSet getAllBooks() {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery("SELECT * FROM books");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
