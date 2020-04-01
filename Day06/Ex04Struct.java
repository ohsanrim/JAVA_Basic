package Day06;

import java.util.Scanner;

import util.MyScanner;

//구조체의 배열
public class Ex04Struct {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //구조체의 배열을 만들어보자
        //어려워보이지만 속지맙시다.
        //일반 배열처럼 데이터타입[] 배열이름=ㅜㄷㅈ 데이터타입[크기]해주면 된다.
        //그럼 학생 구조체의 데이터타입의 이름은 무엇인가?
        //Student이다
        Student[] student = new Student[3];
        //하지만 우리가 저 배열에 일일이 값을 입력해주려고 하면 
        //모든 요소에 대해 new student를 실행시켜주어야 한다,
        //그러면 입력할 때마다 임시로s라는 student변수 만들어서
        //거기에 값을 넣고 다 넣고나서는 student[i]에 s를 넣어주면 되겠지
        for(int i=0;i<student.length;i++) {
            //연결할 주소를 가진 Student s를 하나 만들어준다
            Student s = new Student();
            System.out.println("이름: ");
            String name = sc.nextLine();
            System.out.print("국어: ");
            int kor=MyScanner.nextInt(sc);
            System.out.print("영어: ");
            int eng=MyScanner.nextInt(sc);
            System.out.print("수학: ");
            int math=MyScanner.nextInt(sc);
            s.name=name;
            s.eng=eng;
            s.kor=kor;
            s.math=math;
            student[i]=s;
        }
        for(Student s : student) {
            System.out.printf("%s:\t %03d점\t %03d점\t %03d점\n",s.name,s.kor, s.eng,s.math);
        }
        sc.close();

    }

}
