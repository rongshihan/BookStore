package Entity;

import java.sql.Date;

public class Book {
    private int ID;
    private String name;
    private String author;
    private String language;
    private String category;
    private String cdrom;
    private int commend;
    private String content;
    private int price;
    private Date on_sale_time;
    private int good_price;
    private String publish_name;
    private String publish_address;
    private int book_num;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCdrom() {
        return cdrom;
    }

    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }

    public int getCommend() {
        return commend;
    }

    public void setCommend(int commend) {
        this.commend = commend;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getOn_sale_time() {
        return on_sale_time;
    }

    public void setOn_sale_time(Date on_sale_time) {
        this.on_sale_time = on_sale_time;
    }

    public int getGood_price() {
        return good_price;
    }

    public void setGood_price(int good_price) {
        this.good_price = good_price;
    }

    public String getPublish_name() {
        return publish_name;
    }

    public void setPublish_name(String publish_name) {
        this.publish_name = publish_name;
    }

    public String getPublish_address() {
        return publish_address;
    }

    public void setPublish_address(String publish_address) {
        this.publish_address = publish_address;
    }

    public int getBook_num() {
        return book_num;
    }

    public void setBook_num(int book_num) {
        this.book_num = book_num;
    }

}
