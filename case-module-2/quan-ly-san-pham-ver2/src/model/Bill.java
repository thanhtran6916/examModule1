package model;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Date;

public class Bill {
    private String id;
    private Product product;
    private Seller seller;
    private Buyer buyer;
    private int quantity;
    private double money;
    private LocalDate dateCreated;
    private LocalDate dateOfPayment;

    public Bill(String id, Product product, Seller seller, Buyer buyer, int quantity) {
        this.id = id;
        this.product = product;
        this.seller = seller;
        this.buyer = buyer;
        this.quantity = quantity;
        this.money = quantity * product.getCost();
        this.dateCreated = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", product=" + product +
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", quantity=" + quantity +
                ", money=" + money +
                '}';
    }
}
