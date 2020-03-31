package Day05;

public class Ex04Array {
    //call by value vs call by reference
    //값 호출과 참조호출
    //우리가 파라미터로 무언가를 넘겨주면 도대체 무엇이 가는걸까?
    //기본형데이터타입의 경우 변수엑밧이 있으니깐 그 값이 넘어간다
    //=변수 자체가 아니라 값만 넘어간다.
    //그러면 변수의 이름과 파라미터의 이름이 같더라도
    //같은 존재일까?
    //./굳이 주소값 자체가 넘어갈 필요 없이 값만 넘겨주고 리턴 타입으로 똑같은 데이터를 받아와서
    //그 값으로 초기화해주면?
    //call by value의 장점: 원존에 손을 안대기 땜누에 안전하다
    //그에 반해서 콜 바이 레퍼런스의 경우 주소값을 가지고 있는 참ㄷ조형 데이터중에서도
    //특변하게 배열, collections가 콜 바이 레퍼런스가 가능하다.
    //왜냐?
    //이 친구들은 스택 영역에 힙 메모리로 향하는 주소값을가지고 있다.
    //힙 메모리 안에는?
    //다시 힙영역 안의 다른 곳으로 향하는 메모리 주소값을 가지고 있기 때문에
    //콜바이레퍼런스가 일어나게 된다
    //이 주소값에 의한 참조의 경우
    //자바가 힘역역을 봤을 때 "어 또 주소값이네"하도 일어나게 되는 것
    //근데 기본형 데이터타입의 배열은?
    
    
    
    //데이터를 추가하고 나서 변경할 때 조심하기->ArrayList스포
    
    
    
    public static void main(String[] args) {
        //만약에 우리가 자리가 없으면 자동으로 자리가 늘어나는 
        //배열이 필요하다면 어떻게해야할까?
        //우리가 메소드를 만들어서 준비를 해주어야함
        //근데 배열의 크기를 늘리려면 어떻게 해야할까?
        int[] arr = new int [3];
        //이 arr사이즈는 3이다.
        //그러면 우리ㅣ가 3개까지밖에 입력받지못하는데
        //자동으로 늘어나게 하려면?
        
        arr[0]=100;
        
        System.out.println(arr[0]);
        arr=new int[4];
        System.out.println(arr[0]);
        //정말 안타깝게도 배열에서 크기를 늘리려면
        //데이터를 포기하고 늘리던지
        //아니면 귀찮은 과정을 통과해야 한다.
        //귀찮은 과정이란 
        //기존의 데이터를 입시보관할 곳에 복사하고
        //늘리고
        //임시보관한 데이터에서 다시 데이터를 보가해오는 것을 뜻한다.
        System.out.println(arr.length);
        arr[0]=21;
        arr=expend(arr);
        System.out.println(arr.length);
        
    }

    //만약 사용지기 요청을 하면 배열을 늘려주는 메소드
    public static int[] expend(int[] array) {
        //전통적으로 입시로 무언가 보관하는 변수는 
        //다 temp라는단어가 들어간다.
        //(temporary)의 줄임말
        int [] temp = new int[array.length];
        for(int i=0;i<array.length;i++) {
            temp[i]=array[i];
        }
        array= new int[temp.length+1];
        for(int i=0;i<temp.length;i++) {
            array[i]=temp[i];
        }
        return array;
    //크기가 늘어난 배열을 보내서 원본에 덮어쓴다.
    }
    

}
