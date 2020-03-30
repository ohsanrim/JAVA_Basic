package Day04;

import java.util.Scanner;

//배열
//배열이란 한 종류의 데이터타입이
//우리가 지정한 크기만큼 모여있는 것을 배열이라고 한다
//배열은 근데 나온지 오래된 개념이다.
//2세대 언어에서부터 배열은 이미 쓰여졌고
//3세대에서는 오히려 잘 안맞는 개념이 되었다.
//그래서 우리가 배열을 어떻게 쓰는지 왜 잘 안쓰는지 한번 알아봅시다.

public class Ex02Array {

    public static void main(String[] args) {
        //배열 선언 방법:
        //데이타입[] 배열이름= new 데이터타입[크기];
        //만약 크기가 5인 int배열을 선언한다면?
        int[] array = new int[5];
        //이 array는 지금 int가 5개 모여있고, 
        //각각의 int를 하나씩 호출하려면 위치번호를 주어야 한다, 
        //앞으로 위치번호는 index라고 부르게 된다. 
        //그럼 0번째에는 무슨값이 들어가있는지 보고 0번째에 새로운 값을 넣어 다시한번 찍어봅시다.
//        System.out.println(array[0]);//배열의 각 인덱스 번호에 있는 요소들으
        //우리가 따로 초기화를 하지 않아도 기본형 데이터타입인 경우 0으로 초기화된다.
        //우리가 값을 넣을 때에는 array[0]을 커다란 변수의 이름처럼 쓰면 된다
        array[0]=5;
        //배열 등 요렇게 모여있는 collection의 경우에는 
        //시작하는 인덱스가 0에서 시작한다.
        //즉 가장 마지막 인덱스 번호는 몇번일까?
        //크기 -1이 가장 마지막 인덱스 번호가 된다.
        //즉 for문에서 이제는 더이산 
        //종료조건 식이 =이 안 붙는다.
//        for (int i=0;i<=5;i++) {
//            System.out.println(array[i]);
//        }
        //만약에 이러한 인덱스가 가능한 범위를 넘어서면 
        //java.lang.ArrayIndexOutOfBoundsException
        ///이 발생한다
        //즉 만약 여러분이 코딩을 하시다가 도중에 이런 에러를 보게된다면
        //인덱스가 잘못 잡혀있는거니 
        //인덱스와 관련된 코드를 다시 점검하면 된다.
        //즉 위의 for loop에서 i의 끝 지점이 5를 포함하는 것이 아닌 
        //5보다 작다라고 설정해야 한다.
        
        //자 그럼 우리가 사용자로부터 입력을 받아서
        //그 숫자들을 차례대로 나열하는 프로그램을 만들어보자
        //팁: inport는 클래스 이름을 찍고 ctrl+space 눌러주면 자동으로 이클립스가 해준다.
        Scanner sc = new Scanner (System.in);
        for (int i=0;i<5;i++) {
            System.out.print((i+1)+"번째 숫자를 입력해주세요: ");
            array[i]=sc.nextInt();
           
        }
        for (int i =0;i<5;i++) {
             System.out.println("array["+i+"] = "+array[i]);
        }
        String[] stringArray = new String[5];
        //클래스 배열의 경우에는 
        //배열 자체에 대한 초기화도 해 줘야 하지만 
        //각 위치에도 초기화를 해 줘야 한다.
        
        for(int i=0;i<5;i++) {
            System.out.println("================");
            System.out.println(stringArray[i]);
            stringArray[i]=new String();
            
            System.out.println(stringArray[i]);
            System.out.println("================");
            //null과 ""은 다른 개념이다
            //null: 주소가 배정은 되었지만 아직 초기화가 안되어있는 상태로 아무런 작업도 할 수 없다
            //"": 주소가 배정되었고, 초기화도 되어있는 상태여서 아무런 값이 없을 뿐 정상인 상태이다. 
            
        }
        sc.close();
        
        
    }

}
