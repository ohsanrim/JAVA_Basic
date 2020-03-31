package Day05;

import java.util.Scanner;

public class Ex01NestedArray {

    public static void main(String[] args) {
        int[][] nestedArray = new int[2][]; // row가 2개인건 확정
        int[] array01 = new int[3]; // 첫번째 row는 col이 3개
        int[] array02 = new int[4]; // 두번째 row는 col아 2개
        nestedArray[0] = array01;
        nestedArray[1] = array02;
        // 학생 5명의 국영수 점수를 관리하는 2차원 배열
        // +이름을 가지는 스트링 배열
        String[] nameArray = new String[5];
        int[][] scoreArray = new int[5][3];
        // 이걸 보여주려면
        // nameArray[0] 학생
        // 국어: scoreArray[0][0]
        // 영어: scoreArray[0][1]
        // 수학: scoreArray[0][2]
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("=====" + (i + 1) + "번 학생=====");
            System.out.print("이름: ");
            nameArray[i] = sc.nextLine();

            System.out.print(nameArray[i] + "학생의 국어점수: ");
            scoreArray[i][0] = sc.nextInt();
            System.out.print(nameArray[i] + "학생의 영어점수: ");
            scoreArray[i][1] = sc.nextInt();
            System.out.print(nameArray[i] + "학생의 수학점수: ");
            scoreArray[i][2] = sc.nextInt();
            sc.nextLine();
        }
        int[] sum = sumScore(scoreArray);
        double [] avg = average(sum);
        for (int i = 0; i < scoreArray.length; i++) {
            System.out.println("========" + nameArray[i] + "========");
            System.out.println("국어\t영어\t수학\t");
            for (int j = 0; j < scoreArray[i].length; j++) {
                System.out.print(scoreArray[i][j] + "\t");
            }
            System.out.println();
            System.out.println(nameArray[i]+" 학생의 총점: "+sum[i]);
            System.out.println(nameArray[i]+" 학생의 평균: "+avg[i]);
            System.out.println("====================");
        }
        sc.close();
    }
    
    
    
    //학생의 점수배열으 ㄹ주면
    //총점과 평균을 출력하는 메소드를 작성하시오
    private static int[] sumScore (int[][] scoreArray) {  //총점 구하는 함수
        int[] sum=new int[scoreArray.length];
        for(int i=0;i<scoreArray.length;i++) {
            for(int j=0;j<scoreArray[i].length;j++) {
                sum [i]+=scoreArray[i][j];
            }
        }
        return sum;
    }
    private static double[] average (int[] sum) {  //평균 구하는 함수
        double[] avg = new double[sum.length];
        for(int i=0;i<sum.length;i++) {
            avg[i]=(double)sum[i]/3;
        }
        return avg;
    }
    
        
        
    }


