package Day06;

import util.MyArray;

public class Ex01MyArray {

    public static void main(String[] args) {
        
        //배열을 특정값이 들어가게 초기화를 할 때레는
        //{}을 쓰고 그 안에 값을 넣어주면 된다.
        
        int[] arr = {1,2,3,4};
        System.out.println(MyArray.indexOf(arr, 3));
        arr = MyArray.add(arr, 10);
        System.out.println(arr.length);
        System.out.println(MyArray.indexOf(arr, 20));
        arr = MyArray.add(arr, 20);
        System.out.println(MyArray.indexOf(arr, 20));
        arr = MyArray.remove(arr, 20);
        System.out.println(MyArray.indexOf(arr, 20));        
        arr=MyArray.removeByIndex(arr, 0);
        System.out.println(MyArray.indexOf(arr,0));
        System.out.println(arr.length);
        //char, byte,double,long, float은 어떡하지...
        //여러분들이 클래스를 만들면?
        //그 클래스로 배열을 만들 수 있다
        //그럼 그 클래스는 어떡하지
        //예시: 회원클래스(Member.java)
        //상품 클래스(Product.java)
        //게시글 클래스(Board.java)
        //왜 우리가 굳이 이런걸 만들어야 하나
        //하청을 주자
        //누구에게? java의 클래스 ArrayList한테
        //우리가 MyArray를 만든 이유?
        //1.ArrayList가 어떻게 돌아가는지 한번 느껴보자
        //2. 배열의 불편한을 느껴보자
        //배열의 가장 나쁜 점. 처음에 크기를 고정시켜야된다.
        //우리가 만든 MYArray를 이용해서
        //크기가 좀 자유로운 배열을 만들었지만
        //만약 배열의 처음크기가 10000인데 추가로 입력을 하면?
        
        
    }

}
