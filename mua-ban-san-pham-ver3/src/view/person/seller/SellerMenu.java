package view.person;
import model.account.Account;
import model.peson.Seller;
import model.product.Product;
import view.error.Error;

import java.util.ArrayList;
import java.util.Iterator;

import static view.Constant.*;


public class SellerMenu {


    public static void main(String[] args) {
        Seller seller = new Seller(new Account("thanh", "123"), SELLER, "123", "123", "thaibinh");

        int choose;
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    addProduct(seller);
                    break;
                case 2:
                    show5Product(seller);
                    break;
            }
        } while (choose != 3);
    }

    private static void show5Product(Seller seller) {
        int count = 5;
        Iterator<Product> productIterator = seller.getProductStore().iterator();
        ArrayList<Product> products1 = get5Product(count, productIterator);
        if (products1.size() == 0) {
            System.out.println("Gian hàng của bạn không có sản phẩm nào.");
        } else {
            int choose;
            menuShow5Product(products1);
            do {
                choose = Error.inputMismatchError();
                int firstChoose = 0;
                int lastChoose = products1.size();
                boolean check = Error.selectionInputError(choose, firstChoose, lastChoose);
                if (!check) {
                    continue;
                }
                switch (choose) {
                    case 0:
                        products1 = get5Product(count, productIterator);
                        if (products1.size() == 0) {
                            System.out.println("Không còn sản phẩm nào.");
                            return;
                        }
                        menuShow5Product(products1);
                        break;
                    case 1:
                        Product product1 = products1.get(1);
                        editAndRemoveProduct(product1, seller);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            } while (choose != 0);
        }
    }

    private static void editAndRemoveProduct(Product product, Seller seller) {
        int choose;
        do {
            menuEditAndRemoveProduct();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    editProduct();
                    break;
                case 2:
                    break;
            }
        } while (choose != 3);


    }

    private static void editProduct() {


    }

    private static ArrayList<Product> get5Product(int count, Iterator<Product> productIterator) {
        ArrayList<Product> products1 = new ArrayList<>();
        Product product;
        while (productIterator.hasNext()) {
            product = productIterator.next();
            products1.add(product);
            count--;
            if (count == 0) {
                break;
            }
        }
        return products1;
    }

    private static void addProduct(Seller seller) {
        Product product = inputProduct(seller);
        products.add(product);
        seller.getProductStore().add(product);
    }

    private static Product inputProduct(Seller seller) {
        Product product = inputInformation(seller);
        String category = inputCategory();
        product.setCategory(category);
        product.setSeller(seller);
        return product;
    }

    private static Product inputInformation(Seller seller) {
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        return new Product(name, cost, description, seller);
    }

    public static String inputCategory() {
        System.out.println("Nhập danh mục sản phẩm");
        String category = null;
        int choose;
        do {
            menuCategory();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 5);


            switch (choose) {
                case 1:
                    category = PHONE_LAPTOP_TABLET;
                    break;
                case 2:
                    category = TV_SPEAKER;
                    break;
                case 3:
                    category = AIR_CONDITIONING;
                    break;
                case 4:
                    category = WASHING_DRYER_MACHINE;
                    break;
                case 5:
                    category = KITCHEN_TOOLS;
                    break;
            }
        } while (choose != 1 && choose != 2 && choose != 3 && choose != 4 && choose != 5);

        return category;
    }

    public static void menuEditAndRemoveProduct() {
        System.out.println("1. Sửa sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }

    public static void menuShow5Product(ArrayList<Product> products1) {
        System.out.println("-----------Sản phẩm-----------");
        System.out.println("0. Xem tiếp");
        int count = 1;
        for (Product product : products1) {
            System.out.println(count + ". " + product);
            count++;
        }
        System.out.println("Nhập lựa chọn sản phẩm");
    }

    public static void menuCategory() {
        System.out.println("------------DANH MỤC SẢN PHẨM------------");
        System.out.println("1. Điện thoại, Laptop, Tablet");
        System.out.println("2. Tivi, Loa, Dàn Karaoke");
        System.out.println("3. Máy lạnh, Quạt điều hòa");
        System.out.println("4. Máy giặt, Sấy quần áo");
        System.out.println("5. Đồ dùng nhà bếp");
        System.out.println("Nhập lựa chọn");
    }

    public static void menu() {
        System.out.println("-----------MENU BÁN HÀNG-----------");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị tất cả sản phẩm trong shop");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }

    public static ArrayList<Product> getProducts()
}
