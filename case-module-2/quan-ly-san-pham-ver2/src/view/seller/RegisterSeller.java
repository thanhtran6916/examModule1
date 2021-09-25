package view.seller;

import model.Account;
import model.Person;
import model.Seller;

import static view.Main.people;
import static view.Main.scanner;

public class RegisterSeller {
    public static final String SELLER = "Seller";

    public static void run() {
        int choose = -1;
        do {
            Person seller = inputBuyer();
            System.out.println("Kiểm tra thông tin tài khoản");
            System.out.println(seller);
            menu();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    people.add(seller);
                    people.save();
                    break;
                case 2:
                    break;
            }
        } while (choose == 0);
    }

    public static void menu() {
        System.out.println("1. Đăng ký");
        System.out.println("2. Nhập lại");
        System.out.println("0. Hủy");
    }

    public static Seller inputBuyer() {
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        System.out.println("Nhập mã số giấy phép kinh doanh");
        String license = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        Account account = new Account(name, password);
        return new Seller(account, SELLER, license, phoneNumber, address);
    }
}
