package corona_Project;

import java.text.DecimalFormat;
import java.util.Scanner;

import util.MyScanner;

public class NationUtil {
//여러분들이 직접 20분동안 여기에 Nation[]start(Nation[] world)이라는 
    //메소드를 만드ㄹ어서 그 안에 웹사이트의 값을 ㅁ넣어보세요
  
    
    
    
    //배열에 데이터를 넣는 start메소드
    public static Nation[] start(Scanner sc) {  //파라미터(매개변수)를 굳이 외부에서 받아서 출력할 필요없이 내부에서 만들어서 리턴해도 상관이 없음
        System.out.print("입력할 국가의 수: ");
        int size = MyScanner.nextInt(sc);
        Nation[] world = new Nation[size];
        for(int i=0;i<world.length;i++) {
            world[i]=new Nation();  //10개 자리 확보(초기화작업)
        }
        
        for(int i=0;i<world.length;i++) {
            Nation n = new Nation();
            System.out.print("국가의 이름: ");
            n.name= sc.nextLine();
            System.out.print("확진자 수: ");
            n.confirmed=MyScanner.nextInt(sc);
            System.out.print("사망자 수: ");
            n.death=MyScanner.nextInt(sc);
            System.out.print("완치자 수: ");
            n.cured=MyScanner.nextInt(sc);
            System.out.print("총 인구수: ");
            n.population=MyScanner.nextInt(sc);
            world[i]=n;
        }
        return world;
    }
    public static void print(Nation[] world) {
       System.out.println("============================================");
       for(int i=0;i<world.length;i++) {
           System.out.print((i+1)+"번째");
           System.out.print("\t"+world[i].name);
           System.out.print("\t"+world[i].confirmed);
           System.out.print("\t"+world[i].death);
           System.out.print("\t"+world[i].cured);
           System.out.print("\t"+world[i].population);
           System.out.println(showStat(world[i]));
       }
       System.out.println("============================================");
        
        
    }
    public static String showStat(Nation n) {
        //여기서 사망률, 완치율, 인구당 발생률을 각각 계산한 다음 하나의 스트링으로 묶어주자
        //사망률: 사망자수 / 총확진자수 ->결과값은 더블
        //완치율: 완치자수/ 총확진자수->결과값은 더블
        //인구당 발생률: 총 확진자수/총 인구*1000000->결과값은 int
        //근대 100만명 인구 당 발생률 ->총 확진자수/총인구ㅋ부터하면
        //0이나올거기 때문에 총확진자수*1000000/총 인구수로 계산을 진행한다.      
        double deathRate=(double)n.death/n.confirmed*100;
        double curedRate=(double)n.cured/n.confirmed*100;
        int ppp = (int)(((double)n.confirmed/n.population)*1000000);
        new DecimalFormat("##.##").format(deathRate);
        new DecimalFormat("##.##").format(curedRate);
        
        String result ="\t"
        +new DecimalFormat("##.##").format(deathRate)
        +"\t"+new DecimalFormat("##.##").format(curedRate)+
        "\t"+ppp;
        return result;
    }
    public static Nation[] update(Nation[] world, int choice,Scanner sc) {
        
        Nation n = new Nation();
        System.out.print("국가의 이름: ");
        world[choice - 1].name = sc.nextLine();
        System.out.print("확진자의 수: ");
        world[choice - 1].confirmed = MyScanner.nextInt(sc);
        System.out.print("사망자의 수: ");
        world[choice - 1].death = MyScanner.nextInt(sc);
        System.out.print("완치자 수: ");
        world[choice - 1].cured = MyScanner.nextInt(sc);
        System.out.print("총 인구수: ");
        world[choice - 1].population = MyScanner.nextInt(sc);
        return world;
        
    }
}
