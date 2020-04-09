/*가위(1)바위(2)보(3) 게임
난수를 밸생해서 처리할 예정
컴퓨터는 1부터 3사이의 난수를 발생시킨다. 
돈은 천원을 기본으로 준다.

[실행결과]
while
*********
1. 가위
2. 바위
3. 보
*********
번호 입력: 
배팅금액을 입력하세요: 200

결과를 보려면 엔터를 치세요...

컴퓨터: 가위	나: 바위
you win!! 당신의 금액은 1200원

돈 다 떨어지면 돈 더넣을지 물어보고(y/n)

*/
import java.util.Scanner;
class Game 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		int money=1000;
		while(true){
			int com = (int)(Math.random()*3)+1;  //1~3까지의 난수 발생(컴퓨터의 선택!!!!)
			String comAnswer="";
			if (com==1){
				comAnswer="가위";
			} else if(com==2){
				comAnswer = "바위";
			} else if(com==3){
				comAnswer="보";
			}
			System.out.println("*************");
			System.out.println("1. 가위");
			System.out.println("2. 바위");
			System.out.println("3. 보");
			System.out.println("*************");
			System.out.print("번호 입력: ");
			int N = sc.nextInt();   //사용자 입력값
			sc.nextLine();
			String userAnswer="";
			if (N==1){
				userAnswer="가위";
			} else if(N==2){
				userAnswer = "바위";
			} else if(N==3){
				userAnswer="보";
			}
			System.out.println("배팅금액 입력: ");	
			int coin = sc.nextInt();
			sc.nextLine();

			System.out.println("결과를 보려면 Enter를 입력하세요...");
			
			String a =sc.nextLine();


			System.out.println("컴퓨터:"+comAnswer+"\t사용자: "+userAnswer);
			
			
			if(N==com){  //사용자가 이겼을 때 
				System.out.println("무승부입니다!");
				System.out.println("남은 금액: "+money);
			} else if(N>com){
				if(N==3&&com==1){
					System.out.println("아쉽게도 지고말았습니다ㅜㅜ!");
					money-=coin;
					System.out.println("남은 금액: "+money);
				} else {
					System.out.println("우와! 승리하셨습니다!!");
					money+=coin;
					System.out.println("남은 금액: "+money);
				}
			} else {
				if(N==1&&com==3){
					System.out.println("우와! 승리하셨습니다!!");
					money+=coin;
					System.out.println("남은 금액: "+money);
				} else {
					System.out.println("아쉽게도 지고말았습니다ㅜㅜ!");
					money-=coin;
					System.out.println("남은 금액: "+money);
				}
			}
			
			if(money<=0){
				System.out.println("(coin부족)게임이 끝났습니다..");
				System.out.println("게임을 종료하시려면 y를 눌러주세요(y/n)");
				String userChoice = sc.nextLine();
				if(userChoice.equalsIgnoreCase("y")){
					System.out.println("플레이 해주셔서 감사합니다!");
					break;
				} else {
					System.out.println("다시 게임을 진행하시려면 돈을 입력해주세요!");
					money=sc.nextInt();
				}
			} else {
				System.out.println("게임을 계속 하시려면 Enter를 입력하세요...");
				a =sc.nextLine();
			}
		}
		}

}
