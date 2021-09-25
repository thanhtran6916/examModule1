package controller;

import controller.FileData.FileManagement;
import model.Product;
import model.ProductComparatorByCostReduce;
import model.ProductComparatorByCostIncrease;
import model.ProductComparatorByCountReduce;

import java.util.ArrayList;
import java.util.Collections;

public class ProductManagement {
    public static final String PRODUCT_DATA = "E:\\CodeGym\\case-module-2\\quan-ly-san-pham-ver2\\productData.txt";

    private ArrayList<Product> products = new ArrayList<>();

    private FileManagement<Product> write = new FileManagement<>(PRODUCT_DATA, products);

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int searchIndexById(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                index = i;
            }
        }
        return index;
    }

    public void add(Product product) {
        products.add(product);
    }

    public boolean edit(String id, Product product) {
        int index = searchIndexById(id);
        if (index == -1) {
            return false;
        }
        products.set(index, product);
        return true;
    }

    public boolean remove(String id) {
        int index = searchIndexById(id);
        if (index == -1) {
            return false;
        }
        products.remove(index);
        return true;
    }

    public Product searchProductById(String id) {
        int index = searchIndexById(id);
        if (index == -1) {
            return null;
        } else {
            return products.get(index);
        }
    }

    public ArrayList<Product> searchProductByName(String name) {
        ArrayList<Product> products1 = new ArrayList<>();
        int count = 0;
        for (Product product : products) {
            if (count > 5) {
                break;
            }
            if (product.getName().contains(name)) {
                products1.add(product);
                count++;
            }
        }
        return products1;
    }

    public void save() {
        write.Write();
    }

    public void read() {
        products = write.Read();
    }

    public void sortByCostReduce() {
        ProductComparatorByCostReduce byCostIncrease = new ProductComparatorByCostReduce();
        Collections.sort(products, byCostIncrease);
    }

    public void sortByCostIncrease() {
        ProductComparatorByCostIncrease byCostReduce = new ProductComparatorByCostIncrease();
        Collections.sort(products, byCostReduce);
    }

    public ArrayList<Product> top10Product() {
        ProductComparatorByCountReduce byCountIncrease = new ProductComparatorByCountReduce();
        Collections.sort(products, byCountIncrease);
        ArrayList<Product> products1 = new ArrayList<>();
        int count = 10;  //Giới hạn lấy 10 sản phẩm count lớn nhất
        for (Product product : products) {
            if (products1.size() >= count) {
                break;
            }
            products1.add(product);
        }
        return products1;
    }

    public ArrayList<Product> productsCategory(String category) {
        ArrayList<Product> products1 = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                products1.add(product);
            }
        }
        return products1;
    }
}
