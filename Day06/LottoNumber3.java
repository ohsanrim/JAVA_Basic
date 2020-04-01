package Day06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import util.MyArray;

//여러 게임을 관리해야 한다
//"로또 자동 만원어치요~"
//사용자가 금액 입력->100단위로 몇게임인지 볂환
//그 횟수만큼 배열을 만들어서 콩째로 보여준다.
public class LottoNumber3 {
    private static final int SIZE=6;
    private static final int MAX=45;
    private static final int PRICE_PER_GAME=1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Random random = new Random();
        System.out.println("로또판매기");
        System.out.print("돈을 넣어주세요(천 단위): ");
        int money = sc .nextInt();
        //투입한금액을 1000으로 나눠서 몇게임인지를 int game에 저장
        int game = money/1000;
        //국민 여러분! 로또당첨금을 3배로 띄우는 대신
        //번호와 한게임의 금액을 늘리겠습니다.
        int[][] totalGames=new int[game][SIZE];
        for(int i=0;i<game;i++) {
            int[] temp = new int[SIZE];
            for(int j=0;j<SIZE;j++) {
                int randomNumber = (int) (Math.random() * 45) + 1;
                if (!MyArray.contains(temp, randomNumber)) {
                    temp[j] =randomNumber ;
                } else {
                    j--;
                }
            }
            Arrays.sort(temp);
            for(int j=0;j<SIZE;j++) {
                 totalGames[i][j]=temp[j];
            } 
        }
        
//        for(int i=0;i<totalGames.length;i++) {
//            for(int j=0;j<totalGames[i].length;j++) {
//                
//                if(j==totalGames[i].length-1) {
//                    System.out.println(totalGames[i][j]);
//                } else {
//                    System.out.print(totalGames[i][j]+", ");
//                }
//                
//            }
//            System.out.println();
//        }
        int gameNumber=1;
        for(int[] arr :totalGames) {
            System.out.println("======="+gameNumber+"번 게임=======");
            for(int i:arr) {
                System.out.println(i);
            }
            System.out.print("====================");
            System.out.println();
            gameNumber++;
        }
        sc.close();
    }

}
