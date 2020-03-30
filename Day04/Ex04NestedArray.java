package Day04;
//이차원 배열
//
public class Ex04NestedArray {

    public static void main(String[] args) {
        //이차원배열이란
        //똑같은 데이터타입의 배열이 또 모여있는 것이다.
        //배열 안의 배열
        int [][] nestedArray = new int[2][4];
        //자,그냥 배열처럼 우리가 인덱스를 주면 해당하는 번호의 무언가가 튀어나온다.
        //근데 우리가 nestedArray[0]이라고 하면 무엇이 튀어나올까요?
        
        //[][][][] ->nestedArray[0]
        //[][][][] ->nestedArray[1]
        //이렇게 생긴 배열이다.
//        System.out.println(nestedArray[0]);
        
        //즉 nestedArray[0]은 int [4]가 나오게 된다.
        //그러면 우리가 int를 집어넣어주려고 하면 어떻게 해야할까?
       for(int i=0;i<nestedArray.length;i++) {
           for(int j=0;j<nestedArray[i].length;j++) {
               System.out.println("nestedArray["+i+"]["+j+"]: "+nestedArray[i][j]);
           }
       }
        
        
        
    }

}
