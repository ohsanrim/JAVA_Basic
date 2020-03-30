package Day04;

import java.util.Scanner;

//String 배열을 만들어서 사람이 값을 입력하고
//배열에 있는 값을 우리가 메소드를 만들어서 컨트롤해보자
//
public class Ex03Array {
    private static final int SIZE = 5;
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = new String[SIZE];
        // array가 클래스의배열이므로 초기화를 해주자
        // 초기화도 메소드를 시켜서 코드를 분리해보자

        // 그 다음에 사용자가 값을 입력하면
        // 우리가 위치를 지정하지 않고
        // 메소드를 통해서
        // 아무 값도 없는 공간을 자동으로 찾아서
        // 그 위치에 사용자가 입력한 값을 넣는 메소드를 만들어 보자
        init(array);
        printAll(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print("스트링을 입력해주세요: ");
            String userString = sc.nextLine();
            add(array, userString);
        }
        printAll(array);
        System.out.println(indexOf(array, "abc"));
//        System.out.println(indexOf(array, "bcd"));
        
        remove(array, "abc");
        System.out.println(indexOf(array, "abc"));
        sc.close();     
    }

    private static boolean contains(String[] array, String keword) { // 배열 안에 빈 공간이 있는지를 확인하는 boolean
        // 배열을 돌면서 키워드와 일치하는 요소가 있으면 true를 리턴하고
        // 없으면 false를 리턴한다.
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(keword)) {
                return true;
            }
        }
        return false;

    }

    // return이 불리언이 아닌 내가 준 스트링 값이랑 똑같은 곳의 index를 return하는
    // indexOf(String[] array, String input)을 만들어보자
    // 단 array에 사용자가 입력한 input과 같은 String값이 없을 경우 -1
    private static int indexOf(String[] array, String input) {

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(input)) {
                return i;
            }
        }
        return -1;
    }

    private static void printAll(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    private static void init(String[] array) {
        for (int i = 0; i < array.length; i++) {
            // 배열.length는 해당배열의 크기를 리턴해준다.
            array[i] = new String(); // new String을 통해 값 초기화 :""로 나옴
        }
    }

    private static void add(String[] array, String input) { // 배열에 빈공간이 있으면 입력한 값을 넣어줌
        if (contains(array, EMPTY_STRING)) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(EMPTY_STRING)) {

                    // 클래스형 변수에는 무슨 값이 있는가?
                    // 주소값이 있다
                    // 클래스의 배열에는 각 위치에 무슨 값이 있는가?
                    // 주소값이 있다
                    // 그럼클래스형 변수.equals()하던걸
                    // 배열[위치].equals() 할 수도 있다.

                    array[i] = input;
                    break;

                }
            }
        } else {
            System.out.println("빈 공간이 없습니다.");
        }

    }

//그럼 스트링 파라미터를 이용해서
    // 해당 스트링이 존재하면
    // 그 칸에 ㅜnew String을 호출하는 방식으로
    // 해당 스트링을 제거하는
    // remove(String[] array, String keword)를 여러분이 만들어보세요
    private static void remove(String[] array, String keword) {
        int index = indexOf(array, keword);
        if (index != -1) {
            array[index] = new String();
            System.out.println(keword+"가 삭제되었습니다.");
        } else {
            System.out.println("해당 키워드는 존재하지 않습니다.");
        }
    }
}
