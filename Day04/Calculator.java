package Day04;

public class Calculator {
        //계산을 하는 메소드를 모아둔 클래스
        //우리가 메인 메소드에서 
        //객체를 마ㄴ들엇 호출할 것이디 ㅉ때문에 
        //static 키워드는 생략 가능하다
        //만약 객체를 안만들고 메소드를 호출할 것이면 
        //static을 붙여야한다.
    
        //더하기, 곱하기, 나누기,빼기 기능을 
        //(정수, 정수), (실수, 실수), (실수, 정수)로 해서 만드세요
    
    //더하기
    public static int add(int num1, int num2) {
        return num1+num2;
    }
    public static double add(double num1, int num2) {
        return num1+num2;
    }
    public static double add (double num1, double num2) {
        return num1+num2;
    }
    //빼기
    public static int subtract(int num1, int num2) {
        return num1-num2;
    }
    public static double subtract(double num1, int num2) {
        return num1-num2;
    }
    public static double subtract (double num1, double num2) {
        return num1-num2;
    }
    //곱하기
    public static int multiply(int num1, int num2) {
        return num1*num2;
    }
    public static double multiply(double num1, int num2) {
        return num1*num2;
    }
    public static double multiply(double num1, double num2) {
        return num1*num2;
    }
    //나누기
    
    
    public static int divide(int num1, int num2) {
        return num1/num2;
    }
    public static double divide(double num1,int num2) {
        return num1/num2;
    }
    public static double divide(double num1, double num2) {
        return num1/num2;
    }
    
    
    public static void main(String[] args) {     
        
    }

}
