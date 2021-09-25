package view.log_in_and_register;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Error {
    public Error() {

    }

    public static void selectionInputError(int choose, int firstChoose, int lastChoose) {
        if (choose < firstChoose || choose > lastChoose) {
            throw new InputMismatchException();
        }
    }

    public static void styleInputError(String regex) {
    }

    public static int inputMismatchError(Scanner scanner) {
        int number = Integer.MIN_VALUE;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Nhập sai định dạng số");
        }
        return number;
    }

}
