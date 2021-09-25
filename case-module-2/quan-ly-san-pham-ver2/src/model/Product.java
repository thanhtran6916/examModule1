package model;

import java.io.Serializable;
import java.util.Arrays;

public class Product implements Serializable {
    private String id;
    private String name;
    private double cost;
    private String description;
    private String category;
    private int count;
    private String seller;
    private String[] comment;

    public Product(String id, String name, double cost, String description, String category) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String[] getComment() {
        return comment;
    }

    public void setComment(String[] comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", count=" + count +
                ", seller='" + seller + '\'' +
                ", comment=" + Arrays.toString(comment) +
                '}';
    }
}
