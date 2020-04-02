package corona_Project;

import java.util.Scanner;

import util.MyScanner;

public class KoreaCity{//메소드를 만들 클래스

    public static Korea[] start(Scanner sc) {
       
        System.out.print("입력할 지역의 수: ");
        int N = MyScanner.nextInt(sc); 
        Korea[] koreaInfo=new Korea[N];   //"korea가 4개가 들어가는 배열 koreaInfo를 만든다"
        for(int i=0;i<koreaInfo.length;i++) {
            koreaInfo[i]=new Korea();  //10개 자리 확보(초기화작업)
        }
        for(int i=0;i<N;i++) {
            Korea k = new Korea();
            System.out.print("지역이름을 입력하세요: ");
            k.name=sc.nextLine();
            System.out.print("확진자수를 입력하세요: ");
            k.confirmed=MyScanner.nextInt(sc);
      
            System.out.print("사망자수를 입력하세요: ");
            k.death=MyScanner.nextInt(sc);
            System.out.print("격리해제 수를 입력하세요: ");
            k.cured=MyScanner.nextInt(sc);
            System.out.print("발생률을 입력하세요: ");
            k.deathRate=sc.nextDouble();
            koreaInfo[i]=k;
        }
        return koreaInfo;
    }
    
    public static Korea[] update(int index, Korea[] koreaInfo,Scanner sc) {
        Korea k = new Korea();
        System.out.print("지역이름을 입력하세요: ");
        k.name=sc.nextLine();
        System.out.print("확진자수를 입력하세요: ");
        k.confirmed=MyScanner.nextInt(sc);
  
        System.out.print("사망자수를 입력하세요: ");
        k.death=MyScanner.nextInt(sc);
        System.out.print("격리해제 수를 입력하세요: ");
        k.cured=MyScanner.nextInt(sc);
        System.out.print("발생률을 입력하세요: ");
        k.deathRate=sc.nextDouble();
        koreaInfo[index-1]=k;
        return koreaInfo;
        
    }
    public static void print(Korea[] koreaInfo) {
        System.out.println("============================================");
        for(int i=0;i<koreaInfo.length;i++) {
            System.out.print((i+1)+"번째");
            System.out.print("\t"+koreaInfo[i].name);
            System.out.print("\t"+koreaInfo[i].confirmed);
            System.out.print("\t"+koreaInfo[i].death);
            System.out.print("\t"+koreaInfo[i].cured);
            System.out.println("\t"+koreaInfo[i].deathRate);
        }
        System.out.println("============================================");
    }
   
  
}
