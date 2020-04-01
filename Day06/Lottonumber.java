package Day06;

import java.util.Arrays;
import java.util.Scanner;

import util.MyArray;

//로또번호추첨기
//2-분동안 랜덤객체를이요애서
//1~45까지 랜덤한 숫자를 크기가6인 배열에 랜덤하게 담아보세요

public class Lottonumber {
    private final static int lottoNumber = 6;

    public static void main(String[] args) {
        System.out.print("몇 게임을 진행하시겠습니까?: ");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int j = 0; j < N; j++) {

            System.out.println("======" + (j + 1) + "번째======");
            int[] lotto = new int[lottoNumber];
            for (int i = 0; i < lottoNumber; i++) {
                int temp = (int) (Math.random() * 45) + 1;
                lotto[i] = temp;
            }
            //자 우리가 여기에서 만든 lotto의 문제점은 중복이 존재할 수 있다는 것이다
            //1. 인덱스가 다르지만
            //2. lottoNumber[인덱스]의 값이 같을 때가 중복이다.
            for(int i=0;i<lotto.length;i++) {
                //lotto[i]는 기준점이 된다
                for(int k =0; k<lotto.length;k++) {
                    //lotto[j]는 중복인지 검사할 수가 된다.
                    //자 if문을 만들어서 위치가 다르지만
                    //값이 다른 조건을 만들어보자
                    if(lotto[i]==lotto[k]&&i!=j) {
                        lotto[i]= (int) (Math.random() * 45) + 1;
                        k=-1;
                    }
                }
            }
            //정렬을 해보자
            //정렬의 경우 지금 element가 다음 element보다 크면
            //두개의 위치를 바꿔주면 된다.
            //지금요소: lottoNumber[i]
            //다음요소: lottoNumber[
            for(int i=0;i<lotto.length-1;i++) {
                if(lotto[i]>lotto[i+1]) {
                    int temp=lotto[i];
                    lotto[i]=lotto[i+1];
                    lotto[i+1]=temp;
                    i=-1;
                }
            }
            
            System.out.print("선택된 로또번호: ");
//            for (int i = 0; i < lottonumber; i++) {
//                System.out.print(lotto[i] + ", ");
//            }
//            System.out.println();
            // 향상된 for문, foreach구조
            // 우리가 배열 혹은 collections의 무언가를 쭉 출력할 때
            // 굳이 몇번 째 위치에 있는 무언가를 굳이 지칭해줄 필요가 있을까?
            // 이 for문은 만약 배열에 있는 모든 값을 출력할 때 사용하면 편리하다!

            // 단 foreach구조는 2가지 제약이 있다.
            // 1. 데이터를 바꾸더라도 원본은 바뀌지 않는다. 값만 복사해서 보여주는 용도
            // 2. 원본이 나온 collection의 갯수가 바뀌면 안된다.
            for (int i : lotto) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

    }

}
