package model;

import java.util.Comparator;

public class ProductComparatorByCostReduce implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o2.getCost() - o1.getCost() > 0) {
            return 1;
        } else if (o2.getCost() - o1.getCost() < 0) {
            return -1;
        }
        return 0;
    }
}
