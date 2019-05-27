package DAO;

public class Factory {
    public static BookDAO getBookDAO(){ return new BookDAOImpl(); }
    public static UserDAO getUserDAO() { return new UserDAOImpl(); }
    public static OrderDAO getOrderDAO() { return new OrderDAOImpl(); }
    public static CartDAO getCartDAO(){ return new CartDAOImpl();}
}
