package view;

import model.Customer;

import java.util.ArrayList;

import static view.Main.customers;
import static view.Main.scanner;

public class CustomerMenu {
    public static void run() {
        int choose = -1;
        do {
            readData();
            System.out.println("Mời nhập lựa chọn");
            menu();
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1: {
                    login();
                    break;
                }
                case 2: {
                    register();
                    saveFile();
                    break;
                }
                case 3:
                    customers.show();
            }

        } while (choose != 0);


    }

    public static void login() {
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        Customer customer = new Customer(name, password);
        boolean check = customers.checkCustomer(customer);
        if (check) {
            System.out.println("đã đăng nhập");
        } else {
            System.out.println("Tài khoản hoặc mật khẩu không chính xác");
        }
    }

    public static void register() {
        Customer customer = inputCustomer();
        for (Customer customer1 : customers.getCustomers()) {
            boolean sameName = customer.getName().equals(customer1.getName());
            boolean samePhoneNumber = customer.getPhoneNumber().equals(customer1.getPhoneNumber());
            if (sameName) {
                System.out.println("Tên tài khoản đã tồn tại");
                return;
            }
            if (samePhoneNumber) {
                System.out.println("Số điện thoại đã tồn tại");
                return;
            }
        }
        customers.add(customer);
        System.out.println("Done!");
    }

    public static void saveFile() {
        customers.saveFile("E:\\CodeGym\\case-module-2\\dataCustomer.txt");
    }

    public static void readData() {
        ArrayList<Customer> customerList = customers.readFile("E:\\CodeGym\\case-module-2\\dataCustomer.txt");
        customers.setCustomers(customerList);
    }

    public static Customer inputCustomer() {
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        return new Customer(name, phoneNumber, password);
    }

    public static void menu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
    }


}
