package corona_Project;

import java.util.Scanner;

import util.MyScanner;

public class CoronaEx {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nation[] world = null;
        Korea[] koreaInfo = null;
        // 화면출력하기
        while (true) {
            // 메뉴를 출력한다.
            // 1.세계현황 보기
            // 2.한국 현황보기
            // 3. 종료
            System.out.println("=======코로나 상황판=======");
            System.out.println("1. 세계 2. 한국 3. 종료");
            System.out.println(">");
            int choice = sc.nextInt();
            if (choice == 1) {
                choice = showMenu(sc);
                // 입력하기를 눌렀을 때 우리 nation[]이 null이면 곧장 입력하기를 누르고
                // 만약 null이ㅣ 아니면
                // 전부다 새로 입력할지 특정국가만 업데이트할지를 물어본다.
                if (choice == 1) {
                    if (world == null) {
                        world = NationUtil.start(sc);
                    } else {
                        System.out.println("1.전부 새로입력, 2. 특정국가만 업데이트");
                        choice = MyScanner.nextInt(sc);
                        if (choice == 1) {
                            world = NationUtil.start(sc);
                        } else if (choice == 2) {
                            // 이때는 현재 상태 전체를 확인하고
                            // 수정할 나라의 번호를 선택하게 한다.
                            NationUtil.print(world);
                            choice = validataIndex(sc, world.length);
                            world = NationUtil.update(world, choice, sc);
                        }
                    }
                } else if (choice == 2) {
                    // 출력하는 메소드를 실행하되
                    // world가 null인지 황인 후 null이 아닐 때 실행
                    if (world != null) {
                        NationUtil.print(world);
                    } else {
                        // 경고메세지만 출력
                        System.out.println("데이터가 입력되지않았습니다.");
                        System.out.println();
                    }
                }
            } else if (choice == 2) {

                choice = showMenu(sc);
                // choice==1이면 새로입력, 2면 출력, 3이면 아무것도안함
                if (choice == 1) {
                    if (koreaInfo == null) {
                        koreaInfo = KoreaCity.start(sc);
                    } else {
                        System.out.print("1.전부 새로입력, 2. 특정지역만 업데이트");
                        choice = MyScanner.nextInt(sc);
                        if (choice == 1) {
                            KoreaCity.start(sc);
                        } else if (choice == 2) {
                            KoreaCity.print(koreaInfo);
                            int index = validataIndex(sc, koreaInfo.length);
                            KoreaCity.update(index, koreaInfo, sc);
                        } else {
                            System.out.println("번호를 잘못입력하셨습니다. 다시한번 입력해주세요!");
                            choice = MyScanner.nextInt(sc);
                        }
                    }
                } else if (choice == 2) {
                    KoreaCity.print(koreaInfo);
                }
                // 한국현황보여주는 메소드 실행
            } else {
                System.out.println("감사합니다.");
                break;
            }

        }
        sc.close();
    }

    public static int validataIndex(Scanner sc, int length) {
        System.out.print("수정할 번호를 입력하세요: ");

        int choice = MyScanner.nextInt(sc);
        while (choice < 0 || choice >= length + 1) {
            System.out.println("잘못입력하셨습니다.");
            choice = MyScanner.nextInt(sc);
        }
        return choice;
    }
    public static int showMenu(Scanner sc) {
        int choice = 0;
        System.out.println("1.입력하기 2.출력하기 3. 뒤로");
        System.out.println(">");
        choice = MyScanner.nextInt(sc);

        return choice;
    }
}