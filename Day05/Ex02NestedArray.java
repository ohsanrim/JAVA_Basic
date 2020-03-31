package Day05;

import java.util.Scanner;

//미국 재입시험: sat
//한달에 한번씩 열린다.
//앗 처음꺼 망했다!->준비 좀만 하다가 다다음달 시험봐야지
//sat이란 무슨 느낌일까->한번 보면서 각 봐야겠다.
public class Ex02NestedArray {
//어떤 학생이 sat시허믕 ㄹ3번 봤고
    // 그 중에서 제일 잘나온 점수를 뽑아서 보여주는 프로그램을 만들오보시오
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] scoreArray = new int[3][3];
       
        for (int i = 0; i < scoreArray.length; i++) {
            System.out.println("========="+(i+1)+"번째=========");
            System.out.print("수학: ");
            scoreArray[i][0] = sc.nextInt();
            System.out.print("독해: ");
            scoreArray[i][1] = sc.nextInt();
            System.out.print("문법: ");
            scoreArray[i][2] = sc.nextInt();
        }
        int[] maxScores = calculateMax(scoreArray);
       System.out.println("학생의 각 최고점수: ");
       System.out.println("수학: "+maxScores[0]);
       System.out.println("읽기: "+maxScores[1]);
       System.out.println("쓰기: "+maxScores[2]);
       sc.close();
    }
        
    private static int[] calculateMax (int[][] scoreArray) {  //총점 구하는 함수
        int[] maxScores=new int[scoreArray.length];
        int mathMax=0;
        int readingMax=0;
        int writingMax=0;
        //값복사 vs 주소값복사
        //call by value vs call by reference
        for(int i=0;i<scoreArray.length;i++) {
            
            //삼항연산자
            //우리가 어딘가에 값을 정할 때 사용한다.
            //if문 ,switch문은 
            //조건이 맞으면 특정 메소드가 어떤코드를 실행해라가 가능하지만
            //삼항연산자는 오직값을 결정할 때만 사용된다!
            //사용법:
            //값 결정할 곳= 조건식? true일때 값: false일 때 값
            //readingMax와 writingMax를 삼항연산자로 뽑아보세요
            mathMax=mathMax<scoreArray[i][0]?
                    scoreArray[i][0]:mathMax;
            readingMax = readingMax<scoreArray[i][1]?
                    scoreArray[i][1]:readingMax;
            writingMax = writingMax<scoreArray[i][2]?
                    scoreArray[i][2]:writingMax;
            
        }
        maxScores[0]=mathMax;
        maxScores[1]=readingMax;
        maxScores[2]=writingMax;
        return maxScores;
    }
}
