package util;

//배열에 필요한 메소드들을 구현해놓은 클래스
public class MyArray {
    // 1. contains
    public static boolean contains(String[] array, String keword) {
        for (int i = 0; i < array.length; i++) {
            if (keword.equals(array[i])) {
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

    private static int[] remove(int[] arr, int element) {
        int index = indexOf(arr, element);
        if (index != -1) {
            int[] front = new int[index];
            int[] back = new int[arr.length - front.length - 1];
            for (int i = 0; i < index; i++) {
                front[i] = arr[i];
            }
            for (int i = index + 1; i < arr.length; i++) {
                back[i] = arr[i];
            }
            arr = new int[front.length + back.length];
            for (int i = 0; i < front.length; i++) {
                arr[i] = front[i];
            }
            for (int i = front.length; i < arr.length; i++) {
                arr[i] = front[i];
            }
        }
        return arr;
    }

}