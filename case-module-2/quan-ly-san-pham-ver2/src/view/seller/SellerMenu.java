package view.seller;

import controller.ProductManagement;
import model.Product;

import static view.Main.scanner;

public class SellerMenu {
    public static ProductManagement products = new ProductManagement();

    public static void run() {
        int choose = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showProduct();
                    break;
                case 5:
                    saverProduct();
                    break;
                case 6:
                    readProduct();
                    break;
            }

        } while (choose != 0);
    }

    private static void readProduct() {
        products.read();
    }

    private static void saverProduct() {
        products.save();
    }

    private static void showProduct() {
        for (Product product : products.getProducts()) {
            System.out.println(product);
        }
    }

    private static void deleteProduct() {
        System.out.println("Nhập id sản phẩm cần xóa");
        String id = scanner.nextLine();
        boolean check = products.remove(id);
        if (check) {
            System.out.println("Đã xóa");
        } else {
            System.out.println("Id sản phẩm không tồn tại");
        }
    }

    private static void editProduct() {
        System.out.println("Nhập id sản phẩm cần sửa");
        String id = scanner.nextLine();
        System.out.println("Nhập sản phẩm thay thế");
        Product product = inputProduct();
        products.edit(id, product);
    }

    public static void addProduct() {
        products.add(inputProduct());
    }

    public static Product inputProduct() {
        System.out.println("1. Nhập id sản phẩm");
        String id = scanner.nextLine();
        System.out.println("2. Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("3. Nhập giá sản phẩm");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("4. Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        System.out.println("5. Nhập danh mục sản phẩm");
        String category = scanner.nextLine();

        return new Product(id, name, cost, description, category);
    }

    public static void menu() {
        System.out.println("MENU BÁN HÀNG");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị tất cả sản phẩm");
        System.out.println("5. Lưu");
        System.out.println("6. Đọc");
        System.out.println("0. Thoát");
    }
}
