package DAO;

import Entity.Order;

import java.util.List;

public interface OrderDAO {
    Boolean insert(Order order);
    Boolean update(Order order);
    Boolean delete(int order_id);
    List<Order> findById(int order_id);
    List<Order> findByUserId(int user_id);
}
