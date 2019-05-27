package DAO;

import Entity.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> findAllByUserId(int user_id);
    List<Cart> findStatus1(int user_id);
}
