package DAO;

import Entity.User;

import java.util.List;

public interface UserDAO {
    Boolean insert(User user);
    Boolean update(User user);
    Boolean delete(int user_id);
    User findById(int user_id);
    User findAccount(String email, String password);
}
