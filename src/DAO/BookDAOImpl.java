package DAO;

import Entity.Book;
import JDBC.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public Boolean insert(Book book) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        String sql = "insert into book values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,book.getID());
            ps.setString(2,book.getName());
            ps.setString(3,book.getAuthor());
            ps.setString(4,book.getLanguage());
            ps.setString(5,book.getCategory());
            ps.setString(6,book.getCdrom());
            ps.setInt(7,book.getCommend());
            ps.setString(8,book.getContent());
            ps.setInt(9,book.getPrice());
            ps.setDate(10,book.getOn_sale_time());
            ps.setInt(11,book.getGood_price());
            ps.setString(12,book.getPublish_name());
            ps.setString(13,book.getPublish_address());
            ps.setInt(14,book.getBook_num());

            ps.executeUpdate();
            if(ps!=null){
                ps.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            dbc.closeDB();
        }
    }

    @Override
    public Boolean update(Book book) {
        return null;
    }

    @Override
    public Boolean delete(int book_id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        List<Book> books = new ArrayList<>();
        String sql = "select * from book";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Book book = new Book();
                book.setID(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setLanguage(rs.getString(4));
                book.setCategory(rs.getString(5));
                book.setCdrom(rs.getString(6));
                book.setCommend(rs.getInt(7));
                book.setContent(rs.getString(8));
                book.setPrice(rs.getInt(9));
                book.setOn_sale_time(rs.getDate(10));
                book.setGood_price(rs.getInt(11));
                book.setPublish_name(rs.getString(12));
                book.setPublish_address(rs.getString(13));
                book.setBook_num(rs.getInt(14));
                book.setPath(rs.getString(15));
                books.add(book);
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbc.closeDB();
        }
        return books;
    }

    @Override
    public Book findById(int book_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        Book book = new Book();
        String sql = "select * from book where id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,book_id);
            rs = ps.executeQuery();
            while(rs.next()){
                book.setID(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setLanguage(rs.getString(4));
                book.setCategory(rs.getString(5));
                book.setCdrom(rs.getString(6));
                book.setCommend(rs.getInt(7));
                book.setContent(rs.getString(8));
                book.setPrice(rs.getInt(9));
                book.setOn_sale_time(rs.getDate(10));
                book.setGood_price(rs.getInt(11));
                book.setPublish_name(rs.getString(12));
                book.setPublish_address(rs.getString(13));
                book.setBook_num(rs.getInt(14));
                book.setPath(rs.getString(15));
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbc.closeDB();
        }
        return book;
    }
}
