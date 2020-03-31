package util;

import java.util.Scanner;

public class MyScanner {

    public static int nextInt(Scanner sc) {
        int userNumber = sc.nextInt();
        sc .nextLine();
        return userNumber;
    }

}
