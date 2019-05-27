package DAO;

import Entity.User;
import JDBC.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public Boolean insert(User user) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getID());
            ps.setString(2,user.getLogname());
            ps.setString(3,user.getRealname());
            ps.setString(4,user.getPassword());
            ps.setString(5,user.getEmail());
            ps.setString(6,user.getGender());
            ps.setInt(7,user.getPhone());
            ps.setString(8,user.getProblem());
            ps.setString(9,user.getAnswer());
            ps.setString(10,user.getProvince());
            ps.setString(11,user.getEducation());
            ps.setString(12,user.getHobbies());
            ps.setString(13,user.getSelfintro());

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
    public Boolean update(User user) {
        return null;
    }

    @Override
    public Boolean delete(int user_id) {
        return null;
    }

    @Override
    public User findById(int user_id) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        User user = new User();
        String sql = "select * from user where id=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while(rs.next()){
                user.setID(rs.getInt(1));
                user.setLogname(rs.getString(2));
                user.setRealname(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setGender(rs.getString(6));
                user.setPhone(rs.getInt(7));
                user.setProblem(rs.getString(8));
                user.setAnswer(rs.getString(9));
                user.setProvince(rs.getString(10));
                user.setEducation(rs.getString(11));
                user.setHobbies(rs.getString(12));
                user.setSelfintro(rs.getString(13));
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
        return user;
    }

    @Override
    public User findAccount(String email, String password) {
        Connect dbc = new Connect();
        Connection conn = dbc.getConnection();
        User user = new User();

        String sql = "select * from user where email=? and password=?";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,email);
            ps.setString(2,password);
            rs = ps.executeQuery();

            while(rs.next()){
                user.setID(rs.getInt(1));
                user.setLogname(rs.getString(2));
                user.setRealname(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setGender(rs.getString(6));
                user.setPhone(rs.getInt(7));
                user.setProblem(rs.getString(8));
                user.setAnswer(rs.getString(9));
                user.setProvince(rs.getString(10));
                user.setEducation(rs.getString(11));
                user.setHobbies(rs.getString(12));
                user.setSelfintro(rs.getString(13));
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
        return user;
    }
}
