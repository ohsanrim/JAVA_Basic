package gameProject;

import java.util.Scanner;

import util.MyScanner;

public class gameUtil {

    public static Character userCharacter(Scanner sc) {  //캐릭터 정보 저장
        Character c = new Character();
        System.out.print("사용자 이름을 입력하세요: ");
        c.name = sc.nextLine();
        System.out.print("직업을  선택하세요");
        System.out.println("1. 전사 2. 마법사 3. 궁수");
        System.out.print("> ");
        c.job = MyScanner.nextInt(sc);
        return c;
    }
    public static Character userComputer(Scanner sc) {
        Character c = new Character();
        c.name="computer1";
        c.job=(int) (Math.random()*3+1);
        return c;
    }
    public static boolean roundgame(Scanner sc, Character[] round, int roundCount) {   //사용자가 이기면 true, 지면 false출력
        System.out.println("=========="+roundCount+"==========");
        
        
         return true;
    }
   
    

}
