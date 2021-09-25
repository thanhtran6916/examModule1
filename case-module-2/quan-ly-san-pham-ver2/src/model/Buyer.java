package model;

import java.util.ArrayList;

public class Buyer extends Person {
    private String phone;
    private String address;
    private int point;
    private ArrayList<Product> cart;

    public Buyer(Account account, String role, String phone, String address) {
        super(account, role);
        this.phone = phone;
        this.address = address;
        point = 0;
        cart = new ArrayList<>();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                '}';
    }
}
