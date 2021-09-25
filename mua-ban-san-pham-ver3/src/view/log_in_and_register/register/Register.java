package view.log_in_and_register;

import view.error.Error;

public class Register {
    public static void run() {
        int choose;
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
            }
        } while (choose != 3);
    }

    public static void menu() {
        System.out.println("------------ĐĂNG KÝ------------");
        System.out.println("1. Đăng ký người mua hàng");
        System.out.println("2. Đăng ký người bán hàng");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }
}
