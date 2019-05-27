package DAO;

import Entity.Cart;
import JDBC.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO{
    @Override
    public List<Cart> findAllByUserId(int user_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        List<Cart> carts = new ArrayList<>();
        String sql = "select * from cart where user_id=? and status=0";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Cart cart = new Cart();
                cart.setUser_id(rs.getInt("user_id"));
                cart.setOrder_id(rs.getInt("order_id"));
                cart.setBook_id(rs.getInt("book_id"));
                cart.setBook_name(rs.getString("book_name"));
                cart.setPrice(rs.getInt("price"));
                cart.setBook_number(rs.getInt("book_num"));
                cart.setGoods_price(rs.getInt("goods_price"));
                cart.setTime(rs.getDate("time"));
                cart.setPath(rs.getString("path"));
                carts.add(cart);
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
        return carts;
    }

    @Override
    public List<Cart> findStatus1(int user_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        List<Cart> carts = new ArrayList<>();
        String sql = "select * from cart where user_id=? and status=1";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while(rs.next()){
                Cart cart = new Cart();
                cart.setUser_id(rs.getInt("user_id"));
                cart.setOrder_id(rs.getInt("order_id"));
                cart.setBook_id(rs.getInt("book_id"));
                cart.setBook_name(rs.getString("book_name"));
                cart.setPrice(rs.getInt("price"));
                cart.setBook_number(rs.getInt("book_num"));
                cart.setGoods_price(rs.getInt("goods_price"));
                cart.setTime(rs.getDate("time"));
                cart.setPath(rs.getString("path"));
                carts.add(cart);
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
        return carts;
    }
}
