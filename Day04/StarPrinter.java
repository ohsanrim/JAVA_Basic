package Day04;

public class StarPrinter {
    // 접근제한자를 활용해ㅗ보자
    // 다른곳에서 사용되는 메소드가 아니라면
    // 무조건 private으로 만들어 주는 것이 좋다.
    public void selectNumber(int choice, int lineNumber) {
        // 외부에서는 얘ㄴ만 호출하고
        // 얘는 내부에서 private로 되어있는 메소드를 호출한다.
        switch (choice) {
        case 1:
            starPrint1(lineNumber);
            break;
        case 2:
            starPrint2(lineNumber);
            break;
        case 3:
            starPrint3(lineNumber);
            break;
        case 4:
            starPrint4(lineNumber);
            break;
        case 5:
            starPrint5(lineNumber);
            break;
        case 6:
            starPrint6(lineNumber);
            break;
        case 7:
            starPrint7(lineNumber);
            break;
        case 8:
            starPrint8(lineNumber);
            break;
        case 9:
            starPrint9(lineNumber);
            break;
        case 10:
            starPrint10(lineNumber);
            break;
    }
    }

    private void starPrint1(int lineNumber) {
//별찍기 1번 코드를 여기에 적어준다.
        for(int i=1;i<=lineNumber;i++) {
            String stars="";
            for(int j=1;j<=i;j++) {
                stars+="*";
            }
            System.out.println(stars);
        }
    }
    private void starPrint2(int lineNumber) {
        for (int i = 1;i <= lineNumber; i++) {
            for (int j = 1; j <= lineNumber-i+1; j++) {
               System.out.print("*");
            }
            System.out.println();
        }
    }
    private void starPrint3(int lineNumber) {
        for (int i = 1; i <= lineNumber; i++) {
            String stars = "";
            for (int width = 1; width <= lineNumber - i; width++) {
                
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                stars += "*";
                System.out.print("*");
            }
            System.out.println();

        }
    }
    private void starPrint4(int lineNumber) {
for (int i = 1;i <= lineNumber; i++) {
            
            for (int j = 0; j <= i-1; j++) {

                System.out.print(" ");
            }
            for (int j = 0; j <= lineNumber-i; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
        
    }
    private void starPrint5(int lineNumber) {
        for(int i=1;i<=lineNumber;i++) {
            for(int j=1;j<=lineNumber-i;j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private void starPrint6(int lineNumber) {
        for(int i=1;i<=lineNumber;i++) {
            for(int j=1;j<=i-1;j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=2*(lineNumber-i+1)-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }  
    }
    private void starPrint7(int lineNumber) {
        for(int i=1;i<=lineNumber*2-1;i++) {
            if(i>lineNumber) {
                for(int j = 0;j<2*lineNumber-i;j++) {
                    System.out.print("*");
                }
                
            } else {
                for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            }
            System.out.println();
        }
    }
    private void starPrint8(int lineNumber) {
        
        //number가 아닌 number-1이 되느ㅡㄴ 메소드가 제대로 안나오니
        //둘 중 하나를 number 메소드를 선택하고
        //다른하나는 여기에 직접 구현하자
        
        for(int i=1;i<=lineNumber*2-1;i++) {
            if(i>lineNumber) {  //height=6
                for(int j = 0; j<=i-lineNumber-1;j++ ) {
                    System.out.print(" ");
                }
                for(int j = 0;j<2*lineNumber-i;j++) {
                    System.out.print("*");
                }   
            } else {
                for(int j =0;j<=lineNumber-i-1;j++ ) {
                   System.out.print(" ");
               }
                 for(int j = 1;j<i+1;j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    private void starPrint9(int lineNumber) {
        for(int i=1;i<=lineNumber*2-1;i++) {
            if(i>lineNumber) {
                for(int j=1;j<=i-lineNumber;j++) {
                    System.out.print(" ");
                }
                for(int j=1; j<=2*(2*lineNumber-i)-1;j++) {
                    System.out.print("*");
                }
            } else {
                for(int j=1;j<=lineNumber-i;j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=2*i-1;j++) {
                System.out.print("*");
            }
            
            }
           System.out.println();
            
        }
    }
    private void starPrint10(int lineNumber) {
        for (int i = 0; i < 2 * lineNumber - 1; i++) { // 첫번쨰 줄
            System.out.print("*");
            //줄 번호가 1이거나 2*number-1일 때
            //별을 2*number-1개 찍어준다. 
        }
        System.out.println();
        for (int i = 1; i <= 2 * lineNumber - 3; i++) {
            if (i > lineNumber - 1) {
                for (int j = 1; j <= i- lineNumber + 2; j++) {
                    System.out.print("*");
                }
                for (int j = 1; j <= (2 * lineNumber - 1) - (2 + i - lineNumber) * 2; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i - lineNumber + 2; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 1; j <=lineNumber - i;j++) {
                    System.out.print("*");
                }
                //가운데 공백의 갯수를 생각해봅시다.
                //7,5,3,1,,,,
                //그런데 총 너비는 고정이니깐
                //그 줄의 별의 갯수들만 빼주면 나머지는 다 공백
                //따라서 별의 갯수는 얼마?
                
                for (int j = 1; j<= 2 * i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= lineNumber - i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * lineNumber - 1; i++) { // 마지막 줄
            System.out.print("*");
    }
}
}
