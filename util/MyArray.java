package util;

import boardProject.Board;
import boardProject.Member;
import boardProject.Reply;

//배열에 필요한 메소드들을 구현해놓은 클래스
public class MyArray {
    // 1. contains
    public static boolean contains(String[] array, String keyword) {
        for (int i = 0; i < array.length; i++) {
            if (keyword.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    // 그럼 여러분들이 오버로딩을 이용해서 인트배열의 contains메소드르를 구혆보세요
    public static boolean contains(int[] array, int keword) {
        for (int i = 0; i < array.length; i++) {
            if (keword == array[i]) {
                return true;
            }
        }
        return false;
    }

    // 우리가 원하는요소의 위치를 알려주는 메소드
    // indexOf
    public static int indexOf(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (key.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    // 여러분들은 int 배열에 대한 오버로딩을 하세요
    public static int indexOf(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // 위의 메소드들을 보고
    // 가장 마지막에 나오는 요소의 번호를 리턴하는 메소드를 만드세요
    // 메소드 이름은 lastIndexOf
    public static int lastIndexOf(String[] arr, String key) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (key.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int lastIndexOf(int[] arr, int key) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // 배열의 크기를 구하는 메소드
    public static int size(String[] arr, String keword) {
        return arr.length;
    }

    public static int size(int[] arr, int keword) {
        return arr.length;
    }

    // 배열의 크기를 1 늘려주는 메소드
    private static int[] expend(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = new int[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

    private static String[] expend(String[] arr) {
        String[] temp = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = new String[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
    
    
    //우리가 만든 게시글을 자동으로 add하는 메소드   
private static Board[] expand(Board[] arr) {
        Board[] temp = new Board[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = new Board[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }
public static Board[] add(Board[] arr, Board element) {
    int index = arr.length;
    arr = expand(arr);
    arr[index] = element;
    return arr;
}

//board를 제거하는 메소드
public static int indexOf(Board[] boardArr, Board key) {
    for (int i = 0; i < boardArr.length; i++) {
        if (key == boardArr[i]) {
            return i;
        }
    }
    return -1;
}

public static Board[] remove(Board[] boardArr, Board element) {
    int index =indexOf(boardArr,element) ;
    if (index != -1) {
        Board[] front = new Board[index];
        Board[] back = new Board[boardArr.length - front.length - 1];
        for (int i = 0; i < front.length; i++) {
            front[i] = boardArr[i];  //프론트 배열에 값 넣어주기
        }
        int backIndex=0;
        for (int i = index + 1; i < boardArr.length; i++) {
            back[backIndex] = boardArr[i];  //백 배열에 값 넣어주기
            backIndex++;
        }
        boardArr = new Board[front.length + back.length];
        for (int i = 0; i < front.length; i++) {
            boardArr[i] = front[i];
        }
       
        backIndex=0;
        for (int i = front.length; i < boardArr.length; i++) {
            boardArr[i] = back[backIndex];
            backIndex++;
        }
    }
    return boardArr;
}
//멤버가 추가 되면 저절로 배열이 늘어나는 expend와 add메소드 구현
private static Member[] expand(Member[] arr) {
    Member[] temp = new Member[arr.length];
    for (int i = 0; i < arr.length; i++) {
        temp[i] = arr[i];
    }
    arr = new Member[temp.length + 1];
    for (int i = 0; i < temp.length; i++) {
        arr[i] = temp[i];
    }
    return arr;
}
public static Member[] add(Member[] arr, Member element) {
int index = arr.length;
arr = expand(arr);
arr[index] = element;
return arr;
}

//댓글 구조체를 활용하여 배열을 추가해주는 작업
private static Reply[] expand(Reply[] arr) {
    Reply[] temp = new Reply[arr.length];
    for (int i = 0; i < arr.length; i++) {
        temp[i] = arr[i];
    }
    arr = new Reply[temp.length + 1];
    for (int i = 0; i < temp.length; i++) {
        arr[i] = temp[i];
    }
    return arr;
}
public static Reply[] add(Reply[] arr, Reply element) {
int index = arr.length;
arr = expand(arr);
arr[index] = element;
return arr;
}

//배열에 추가해주는 메소드
    // 단 추가하는 위치는 무조건 제일 마지막의 뒤에 추가한다.
    // 즉 크기가 자동으로 변하는 배열로 우리가 꾸미는 것이다.
    // 이걸 통해서 우리가 추가를 하게 되면
    // 배열자체를 아예 처음에 0으로 만들어도 상관이 없어진다
    public static int[] add(int[] arr, int element) {
        int index = arr.length;
        arr = expend(arr);
        arr[index] = element;
        return arr;
    }

    public static String[] add(String[] arr, String element) {
        int index = arr.length;
        arr = expend(arr);
        arr[index] = element;
        return arr;
    }
    // 삭제를 해봅시다.
    // 삭제의 경우 크기도 줄어듭니다.
    // 크기 줄어드는 메소드
    // 먼저 해당하는 번호를 찾아서 그 번호 전후로 배열을 분리한다.
    // 그리고 해당 번호를 빼고
    // 그 앞배열 뒷배열을 연결한다.
    
    
    
    public static int[] remove(int[] arr, int element) {
        int index = indexOf(arr, element);
        if (index != -1) {
            int[] front = new int[index];
            int[] back = new int[arr.length - front.length - 1];
            for (int i = 0; i < front.length; i++) {
                front[i] = arr[i];
            }
            int backIndex=0;
            for (int i = index + 1; i < arr.length; i++) {
                back[backIndex] = arr[i];
                backIndex++;
            }
            //arr에서 3,4를 가지고 옺먼
            //back은 0에서부터 우라거 겂을 넣어야한다.
            //그럼 우리가 back을 위한 위치를 따로 만들어서 0에서1씩 증가하면서 위치를 직접 지정해줘야한다.
            arr = new int[front.length + back.length];
            //우리가 arr[i]번째에 차례대로 front와 back을 넣어주면 된다.
            //arr[i]에 front[i]는 문제가 없지만 
            //arr[i]=back은?
            //만약 front의길이가 3이고 back의 길이가 2면
            ///그럼 i는 몇번 반복되느느가?
            //5번 반복이 된다.
            //그럼 ㅇ우리가 for문을 통해서
            //arr[i]=front[i]->
            //i가 0일때->문제 없다
            //1일때 문제없다
            //2일때 문제없음
            //3일때 문제생김->front의 길이가 3이먄? 인덱스는 0~2까지밖에 없다.
            //4일때 문제생김
            //if문을 써서 front의 길이만 가자
            //arr[i]=back[i]에서 다시 문제가 생김
            //3일때 : 문제생김-> back에는 index가 3이 없다
            //즉 우리가 fornt와 back의 값을 
            //새로만든 arr에 복사할 때
            //for문을 생각해봐야 한다는 것이다.
            //위에 back배열을 만들 때 처럼 back인뎃ㄱ스를 통해서 우리가 컨트롤 해야한다는 것이다.
            //두개의 for문을 통해서 첫번째 for문으로 front의 배열을 arr에 복사해주고
            //그리고 두번째 for문을 이용해서
            //back의 배열을 복사해야 한다!
            
            //앞을 복사하는 for문
            
            
            for (int i = 0; i < front.length; i++) {
                arr[i] = front[i];
            }
            //뒤를 복사하는for문
            //아까 만들어둔 backindex를 0으로 초기화하자
            //우리가 만드른 for문은 back을 기준으로ㅗ 한다.
            //즉 back의 크기가 3이면?
            //i는 0 1 2 가 된다.
            //근데 arr[0] arr[1] arr[3]에는 무엇이 있을까
           //이미 우리가 front의 값을 입력한게 있기때문에 값이 덮여진다
            //그러면 backIndex=0이 아닌 다른 것으로 초기화해야한다.
            //그 다른 것은 front가 아닌 index가 되어야한다
            //그럼 얼마로 초기화해야할까?
            //front.length로 초기화해주면 된다.
            //왜냐?
            //front의 맨 마지막 index는 front.length-1이니깐
            //그럼 front가 긑난 다음번index는 front.length가된다.
            backIndex=0;
            for (int i = front.length; i < arr.length; i++) {
                arr[i] = back[backIndex];
                backIndex++;
            }
        }
        return arr;
    }
    public static String[] remove(String[] arr, String element) {
        int index =indexOf(arr,element) ;
        if (index != -1) {
            String[] front = new String[index];
            String[] back = new String[arr.length - front.length - 1];
            for (int i = 0; i < front.length; i++) {
                front[i] = arr[i];  //프론트 배열에 값 넣어주기
            }
            int backIndex=0;
            for (int i = index + 1; i < arr.length; i++) {
                back[backIndex] = arr[i];  //백 배열에 값 넣어주기
                backIndex++;
            }
            arr = new String[front.length + back.length];
            for (int i = 0; i < front.length; i++) {
                arr[i] = front[i];
            }
           
            backIndex=0;
            for (int i = front.length; i < arr.length; i++) {
                arr[i] = back[backIndex];
                backIndex++;
            }
        }
        return arr;
    }
    //arr:{1,23m5m7m9}
    //MyArray.remove(arr,3);
    
    public static int[] removeByIndex(int[] arr, int index) {
        if(index>=0 && index<(arr.length)) {
            arr=remove(arr,arr[index]);
        }
        return arr;
    }
    public static String[] removeByIndex(String[] arr, int index) {
        return (index>=0&&index<(arr.length))?  //올바른 인덱스 번호인지 확인 
                remove(arr,arr[index]):arr;
        
    }
    //테스트를 해봅시다
}