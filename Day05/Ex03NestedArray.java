package Day05;

import java.util.Scanner;

import util.MyScanner;

//1. 차량소유주를 가지고 있는 sting배열 한개
//2.소유주의 차량이 뭔지 가지고 있는 스트링 배열 한개
//연식과 가격을 가지고 있는 인트 2차원 배열 1개
//만드셔서 거기에 값을 입력하도록 하자
//단 5명의 정보만 받도록 한다.
//출력은 간단하게 이름 차량 연식 가격
//5줄로 나오게 만들어보자

public class Ex03NestedArray {
private final static int SIZE =5;
private final static int INT_CULUMNS=2;
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String[] owner = new String[SIZE];
        String[] types = new String[SIZE];
        int [][] yearPriceArray = new int[SIZE][INT_CULUMNS]; 
        insert(owner, types, yearPriceArray);
        function(owner,types,yearPriceArray);
            
        }
     //우리가 파라미터로 기본형 데이터타입을 주거나 
       //혹은 참조형 데이터타입을 주게되면
       //어떤 일이 벌어질까?
       //기본형 혹은뭔가 값을 가지는 친구들(ex.스트링, 포장클래스들)
       //파라미터로 보내도
       //이러한 친구들은 굳이 주소갑ㅅ을 보내는 것ㅅ이 아니라 값 자체를 보내서 컨트롤 되기 때문에->call by value
       //원본이 아닌 복사본이 가는 형태이다
       //따라서 메소드 내부에서 수정해도
       ///원본은 바뀌지 않는다.
       //근데 그 자체가 값을 안가지는 경우가
       //2가지가 있다.
       //바로 배열과 collections라는 모음 클래스이다.
       //이 둘은 call by reference가 일어난다.
      //즉 우리가 원본파일을 받아서 수정하면 그 원본파일 자체가 바귀는 것으로 생각하면 편하다.
       
       //입력하는 메소드
      //자바에서 필요한 객체를 즉석에서 만들어서 거기서 쓰면 끝
       private static void insert(String[] owner,
               String[] types, int[][] yearPriceArray) {
           Scanner sc = new Scanner(System.in);
           for(int i=0;i<owner.length;i++) {
               System.out.println("========="+(i+1)+"번째 고객=========");
               System.out.print("차량주 이름을 입력하세요: ");
               owner[i] = sc.nextLine();
               System.out.print("차량 이름을 입력하세요: ");
               types[i] = sc.nextLine();
               System.out.print("차량의 연식을 입력하세요: ");
               yearPriceArray[i][0]=MyScanner.nextInt(sc);
               System.out.print("차량 가격을 입력하세요: ");
               yearPriceArray[i][1]=MyScanner.nextInt(sc);
               System.out.println("=========================");
           }
           sc.close();
       }
       public static void function(String[] owner, String[]types, int[][]yearPriceArray ) {
           for(int i=0;i<SIZE;i++) {
           System.out.println("차량주: "+owner[i]+", 차량이름: "+types[i]+", 연식: "+yearPriceArray[i][0]+", 가격:"+yearPriceArray[i][1]);
           }
       }
       
       //출력하는 메소드

}
