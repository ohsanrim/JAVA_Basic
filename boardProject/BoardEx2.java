package boardProject;

import java.util.Scanner;

import util.MyScanner;

public class BoardEx2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board[] boardArr = new Board[0];
        for (int i = 0; i < boardArr.length; i++) {
            boardArr[i] = new Board();
        }
        while (true) {
            System.out.println("================비트게시판=================");
            System.out.println("1.글 목록 2. 새로작성 3. 종료");
            System.out.println(">");
            int userChoice = MyScanner.nextInt(sc);
            if (userChoice == 1) {
                BoardUtil.list(boardArr);
                if (boardArr.length > 0) {
                    System.out.println("1.글 개별보기 2. 글삭제 3. 뒤로가기");
                    System.out.println(">");
                    userChoice = MyScanner.nextInt(sc);
                    if (userChoice == 1) {
                        BoardUtil.showOne(boardArr, sc);
                    } else if(userChoice==2) {
                       BoardUtil.boardRemove(boardArr, sc);
                    }
                }

            } else if (userChoice == 2) {

                boardArr = BoardUtil.write(boardArr, sc);

            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 갑사합니다!");
                break;
            }
        }

        sc.close();
    }

}
