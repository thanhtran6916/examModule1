package view;

import controller.PersonManagement;
import model.Account;
import model.Person;
import view.buyer.BuyerMenu;
import view.buyer.RegisterBuyer;
import view.seller.RegisterSeller;
import view.seller.SellerMenu;

import java.util.Scanner;

import static view.buyer.RegisterBuyer.BUYER;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static PersonManagement people = new PersonManagement();

    public static void main(String[] args) {
        int choose = -1;
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
            }
        } while (choose != 0);
    }

    private static void register() {
        int choose = -1;
        do {
            menuRegister();
            System.out.println("Nhập lựa chọn");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    RegisterBuyer.run();
                    break;
                case 2:
                    RegisterSeller.run();
                    break;
            }
        } while (choose != 0);


    }

    private static void login() {
        people.read();
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        Account account = new Account(name, password);
        String role = checkRole(account);
        if (role == null) {
            System.out.println("Thông tin tài khoản không chính xác");
        } else {
            if (role.equals(BUYER)) {
                BuyerMenu.run();
            } else {
                SellerMenu.run();
            }
        }
    }

    public static String checkRole(Account account) {
        String role = null;
        for (Person person : people.getPeople()) {
            if (account.equals(person.getAccount())) {
                role = person.getRole();
            }
        }
        return role;
    }

    public static void menuRegister() {
        System.out.println("1. Đăng ký người mua hàng");
        System.out.println("2. Đăng ký người bán hàng");
        System.out.println("0. Thoát");
    }

    public static void menu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
    }
}
