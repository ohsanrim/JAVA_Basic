/*����(1)����(2)��(3) ����
������ ����ؼ� ó���� ����
��ǻ�ʹ� 1���� 3������ ������ �߻���Ų��. 
���� õ���� �⺻���� �ش�.

[������]
while
*********
1. ����
2. ����
3. ��
*********
��ȣ �Է�: 
���ñݾ��� �Է��ϼ���: 200

����� ������ ���͸� ġ����...

��ǻ��: ����	��: ����
you win!! ����� �ݾ��� 1200��

�� �� �������� �� �������� �����(y/n)

*/
import java.util.Scanner;
class Game 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		int money=1000;
		while(true){
			int com = (int)(Math.random()*3)+1;  //1~3������ ���� �߻�(��ǻ���� ����!!!!)
			String comAnswer="";
			if (com==1){
				comAnswer="����";
			} else if(com==2){
				comAnswer = "����";
			} else if(com==3){
				comAnswer="��";
			}
			System.out.println("*************");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ��");
			System.out.println("*************");
			System.out.print("��ȣ �Է�: ");
			int N = sc.nextInt();   //����� �Է°�
			sc.nextLine();
			String userAnswer="";
			if (N==1){
				userAnswer="����";
			} else if(N==2){
				userAnswer = "����";
			} else if(N==3){
				userAnswer="��";
			}
			System.out.println("���ñݾ� �Է�: ");	
			int coin = sc.nextInt();
			sc.nextLine();

			System.out.println("����� ������ Enter�� �Է��ϼ���...");
			
			String a =sc.nextLine();


			System.out.println("��ǻ��:"+comAnswer+"\t�����: "+userAnswer);
			
			
			if(N==com){  //����ڰ� �̰��� �� 
				System.out.println("���º��Դϴ�!");
				System.out.println("���� �ݾ�: "+money);
			} else if(N>com){
				if(N==3&&com==1){
					System.out.println("�ƽ��Ե� �����ҽ��ϴ٤̤�!");
					money-=coin;
					System.out.println("���� �ݾ�: "+money);
				} else {
					System.out.println("���! �¸��ϼ̽��ϴ�!!");
					money+=coin;
					System.out.println("���� �ݾ�: "+money);
				}
			} else {
				if(N==1&&com==3){
					System.out.println("���! �¸��ϼ̽��ϴ�!!");
					money+=coin;
					System.out.println("���� �ݾ�: "+money);
				} else {
					System.out.println("�ƽ��Ե� �����ҽ��ϴ٤̤�!");
					money-=coin;
					System.out.println("���� �ݾ�: "+money);
				}
			}
			
			if(money<=0){
				System.out.println("(coin����)������ �������ϴ�..");
				System.out.println("������ �����Ͻ÷��� y�� �����ּ���(y/n)");
				String userChoice = sc.nextLine();
				if(userChoice.equalsIgnoreCase("y")){
					System.out.println("�÷��� ���ּż� �����մϴ�!");
					break;
				} else {
					System.out.println("�ٽ� ������ �����Ͻ÷��� ���� �Է����ּ���!");
					money=sc.nextInt();
				}
			} else {
				System.out.println("������ ��� �Ͻ÷��� Enter�� �Է��ϼ���...");
				a =sc.nextLine();
			}
		}
		}

}
