package view;

import controller.ProductManagement;
import model.Product;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final String PRODUCT_DATA = "E:\\CodeGym\\module_2\\thuc-hanh\\data\\productData.csv";

    public static final File FILE_PRODUCT_DATA = new File(PRODUCT_DATA);

    public static final Scanner scanner = new Scanner(System.in);

    public static ProductManagement products = new ProductManagement();

    public static void main(String[] args) {
        int choose = -1;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            menu();
            try {
                choose = scanner.nextInt();
            } catch (Exception e) {
                System.err.println("Nhập sai định dạng của trường dữ liệu");
            }
            scanner.nextLine();
            switch (choose) {
                case 1:
                    show5Product();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    break;
                case 6:
                    searchCostMaxProduct();
                    break;
                case 7:
                    readFile();
                    break;
                case 8:
                    saveFile();
                    break;
            }
        } while (choose != 9);
    }

    public static void readFile() {
        try {
            if (!FILE_PRODUCT_DATA.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(FILE_PRODUCT_DATA);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                double cost = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                String description = data[4];
                Product product = new Product(id, name, cost, quantity, description);
                products.add(product);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File data không tồn tại");
        } catch (IOException e) {
            System.err.println("Lỗi đọc file");
        }
    }

    public static void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PRODUCT_DATA);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product product : products.getProducts()) {
                bufferedWriter.write(product.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Lỗi lưu file");;
        }
    }

    public static void searchCostMaxProduct() {
        double costMax = 0;
        int index = -1;
        for (int i = 0; i < products.getProducts().size(); i++) {
            Product product = products.getProducts().get(i);
            if (product.getCost() > costMax) {
                costMax = product.getCost();
                index = i;
            }
        }
        Product productCostMax = products.getProducts().get(index);
        System.out.println(productCostMax);
    }


    public static void removeProduct() {
        System.out.println("Nhập vào ID sản phẩm cần xóa");
        String id = scanner.nextLine();
        int index = products.searchIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
            System.out.println("Ấn phím bất kỳ để nhập lại / Ấn phím Enter để thoát ra");
            String choose = scanner.nextLine();
            if (choose.equals("")) {
                return;
            } else {
                removeProduct();
            }
        } else {
            System.out.println("Nhập y để xác nhận xóa");
            String choose = scanner.nextLine();
            if (choose.equals("y")) {
                products.remove(index);
                System.out.println("Đã xóa");
            } else {
                return;
            }
        }
    }

    public static void editProduct() {
        System.out.println("Nhập mã sản phẩm cần sửa");
        String id = scanner.nextLine();
        int index = products.searchIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm được sản phẩm với mã sản phẩm trên.");
            System.out.println("Ấn phím bất kỳ để nhập lại / Ấn phím Enter để thoát ra");
            String choose = scanner.nextLine();
            if (choose.equals("")) {
                return;
            } else {
                editProduct();
            }
        } else {
            addProduct();
        }
    }


    public static void addProduct() {
        try {
            Product product = inputProduct();
            boolean check = products.add(product);
            if (check) {
                System.out.println("Đã thêm sản phẩm mới");
            } else {
                System.out.println("Không thể thêm được sản phẩm mới");
            }
        } catch (Exception e) {
            System.err.println("Nhập sai định dạng của trường dữ liệu");
            scanner.nextLine();
        }
    }

    private static void show5Product() {
        int count = 0;
        for (Product product : products.getProducts()) {
            if (count >= 5) {
                break;
            }
            System.out.println("Nhấn phím Enter để tiếp tục.");
            scanner.nextLine();
            System.out.println(product);
            count++;
        }

    }

    public static Product inputProduct() throws InputMismatchException {
        System.out.println("Mã sản phẩm");
        String id = scanner.nextLine();
        System.out.println("Tên");
        String name = scanner.nextLine();
        System.out.println("Giá");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Số lượng");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mô tả");
        String description = scanner.nextLine();
        return new Product(id, name, cost, quantity, description);
    }

    public static void menu() {
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhập");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá trị đắt nhất");
        System.out.println("7. Đọc từ File");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.println("Chọn chức năng: ");

    }
}
