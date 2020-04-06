package gameProject;

import java.util.Random;
import java.util.Scanner;

import util.MyScanner;

public class gameMain {

    public static void main(String[] args) {
        // 먼저 랜덤 변수 하나 만들어준다

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        Character myCharacter = new Character();
        int kill = 0;
        
        System.out.print("이름을 넣어주세요: ");
        myCharacter.name = sc.nextLine();
        System.out.print("직업을 선택해주세요(1. 전사 2. 마법사 3. 궁수): ");
        myCharacter.job = MyScanner.nextInt(sc);
        myCharacter.hp = 10;
        Character enemy = new Character();
        enemy.hp = 10;
        enemy.name = "적1";
//        enemy.job = random.nextInt(3) + 1;
        enemy.job=myCharacter.job;
        while (myCharacter.hp > 0) {
            //자 여기서 내 직업==적 집업
            //75%짜리 서로 데미지
            if(myCharacter.job ==enemy.job) {
                System.out.println("주사위 굴려주세요 y/n");
                String attack = sc.nextLine();
                if(attack.equalsIgnoreCase("y")) {
                    int chance=random.nextInt(100);
                    if(chance>=75) {
                        System.out.println("공격실패!!");
                    } else {
                        System.out.println("공격성공!!!");
                        System.out.println("적의 남은 hp: "+--enemy.hp);
                    }
                }
                int chance=random.nextInt(100);
                if(chance>=75) {
                    System.out.println("공격실패!!");
                } else {
                    System.out.println("공격성공!!!");
                    System.out.println("나의 남은 피"+--myCharacter.hp);
                }
            } 
            if (enemy.hp == 0) {
                kill++;
                System.out.println("회복하시겠습니까?  y/n");
                String agree = sc.nextLine();
                if(agree.equalsIgnoreCase("y")) {
                    enemy.hp=10;
//                    enemy.job=random.nextInt(3)+1;
                    enemy.job=myCharacter.job;
                    myCharacter.hp=10;
                }
            } else if (myCharacter.hp==0) {
                System.out.println("game over!!!");
                System.out.print("쓰러뜨린 적의 수: "+kill);
            }
            

        }

        sc.close();
    }

}
