package DAO;

import Entity.Order;
import JDBC.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public Boolean insert(Order order) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        String sql = "insert into orders values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, order.getID());
            ps.setInt(2, order.getUser_id());
            ps.setString(3, order.getUser_name());
            ps.setInt(4, order.getBook_id());
            ps.setString(5, order.getBook_name());
            ps.setInt(6, order.getBook_number());
            ps.setInt(7, order.getGoods_price());
            ps.setInt(8, order.getStatus());
            ps.setDate(9, order.getTime());

            ps.executeUpdate();
            if (ps != null) {
                ps.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            dbc.closeDB();
        }
    }

    @Override
    public Boolean update(Order order) {
        return null;
    }

    @Override
    public Boolean delete(int order_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        String sql = "delete from orders where ID=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, order_id);

            ps.executeUpdate();
            if (ps != null) {
                ps.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            dbc.closeDB();
        }
    }

    @Override
    public List<Order> findById(int order_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        List<Order> orders = new ArrayList<>();
        String sql = "select * from orders where id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, order_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setID(rs.getInt(1));
                order.setUser_id(rs.getInt(2));
                order.setUser_name(rs.getString(3));
                order.setBook_id(rs.getInt(4));
                order.setBook_name(rs.getString(5));
                order.setBook_number(rs.getInt(6));
                order.setGoods_price(rs.getInt(7));
                order.setStatus(rs.getInt(8));
                order.setTime(rs.getDate(9));
                orders.add(order);
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeDB();
        }
        return orders;
    }

    @Override
    public List<Order> findByUserId(int user_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        List<Order> orders = new ArrayList<>();
        String sql = "select * from orders where user_id=? and status=0";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setID(rs.getInt(1));
                order.setUser_id(rs.getInt(2));
                order.setUser_name(rs.getString(3));
                order.setBook_id(rs.getInt(4));
                order.setBook_name(rs.getString(5));
                order.setBook_number(rs.getInt(6));
                order.setGoods_price(rs.getInt(7));
                order.setStatus(rs.getInt(8));
                order.setTime(rs.getDate(9));
                orders.add(order);
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbc.closeDB();
        }
        return orders;
    }
}
