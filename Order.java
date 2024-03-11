package models;

public class Order {
    String Bookname;
    int Quantity;

    public Order(String bookname, int quantity) {
        Bookname = bookname;
        Quantity = quantity;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void vieworder(){
        System.out.println("-------Books---------");
        System.out.println(getBookname());
        System.out.println("Quantity: "+getQuantity());
    }
}
