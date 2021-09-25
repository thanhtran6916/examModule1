package view.buyer;

import model.Product;

import java.util.ArrayList;

import static view.Main.scanner;
import static view.seller.SellerMenu.products;

public class BuyerMenu {
    public static void run() {
        int choose = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    showTop10();
                    break;
                case 2:
                    showCategory();
                    break;
                case 3:
                    showCostIncrease();
                    break;
                case 4:
                    showCostReduce();
                    break;
                case 5:
                    break;
            }
        } while (choose != 0);
    }


    private static void showCategory() {
        int choose = -1;
        do {
            menuCategory();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    showCategory("style");
                    break;
                case 2:
                    showCategory("phone");
                    break;
                case 3:
                    showCategory("tivi");
                    break;
                case 4:
                    showCategory("moto");
                    break;
                case 5:
                    showCategory("house");
                    break;
            }
        } while (choose != 0);
    }

    public static void showCategory(String category) {
        ArrayList<Product> products1 = products.productsCategory(category);
        for (Product product : products1) {
            System.out.println(product);
        }
    }

    private static void showCostIncrease() {
        products.sortByCostIncrease();
        for (Product product : products.getProducts()) {
            System.out.println(product);
        }
    }

    private static void showCostReduce() {
        products.sortByCostReduce();
        for (Product product : products.getProducts()) {
            System.out.println(product);
        }
    }

    private static void showTop10() {
        ArrayList<Product> products1 = products.top10Product();
        for (Product product : products1) {
            System.out.println(product);
        }
    }

    private static void menuCategory() {
        System.out.println("1. Thời trang");
        System.out.println("2. Thiết bị điện tử");
        System.out.println("3. Tủ lạnh, Tivi, Máy giặt");
        System.out.println("4. Xe cộ");
        System.out.println("5. Bất động sản");
        System.out.println("0. Thoát");
    }

    public static void menu() {
        System.out.println("MENU MUA HÀNG");
        System.out.println("1. Xem sản phẩm bán chạy");
        System.out.println("2. Xem sản phẩm theo danh mục");
        System.out.println("3. Xem sản phẩm theo giá tăng dần");
        System.out.println("4. Xem sản phẩm theo giá giảm dần");
        System.out.println("5. Mua hàng");
        System.out.println("0. Thoát");
    }
}
