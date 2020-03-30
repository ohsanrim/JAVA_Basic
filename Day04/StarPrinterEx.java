package Day04;

import java.util.Scanner;

//q별 찍어주는 프로그램
//사용자가 몇번을 선택하냐에 따라서
//실행되는 메소드가 틀려지게 만들어보자
public class StarPrinterEx {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("별 찍어주는 프로그램!");
        System.out.print("출려할 별의 번호를 입력해주세요: ");
        int choice = sc.nextInt();
        System.out.print("출력할 별의 수를 입력해주세요: ");
        int lineNumber = sc.nextInt();
        StarPrinter s = new StarPrinter();
        s.selectNumber(choice, lineNumber);
        sc.close();
    }
}
