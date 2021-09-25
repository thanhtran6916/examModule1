package view.buyer;

import model.Account;
import model.Buyer;
import model.Person;

import static view.Main.people;
import static view.Main.scanner;

public class RegisterBuyer {
    public static final String BUYER = "Buyer";

    public static void run() {
        int choose = -1;
        do {
            Person buyer = inputBuyer();
            System.out.println("Kiểm tra lại thông tin tài khoản");
            System.out.println(buyer);
            menu();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    people.add(buyer);
                    people.save();
                    break;
            }
        } while (choose == 2);
    }

    public static void menu() {
        System.out.println("1. Đăng ký");
        System.out.println("2. Nhập lại");
        System.out.println("0. Hủy");
    }

    public static Buyer inputBuyer() {
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        Account account = new Account(name, password);
        return new Buyer(account, BUYER, phoneNumber, address);
    }
}
