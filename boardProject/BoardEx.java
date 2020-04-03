package boardProject;

import java.util.Scanner;

import util.MyScanner;

public class BoardEx {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Board[] boardArr=new Board[0];
        for(int i=0;i<boardArr.length;i++) {
           boardArr[i]= new Board();
        }
        while(true) {
            System.out.println("================비트게시판=================");
            System.out.println("1.글 목록 2. 새로작성 3. 종료");
            System.out.println(">");
            int userChoice=MyScanner.nextInt(sc);
            if(userChoice==1) {
               
                //글목록 보여주기
                //글목록을 보여주려면
                //여러글이 들어간 배열이 필요하다.
                //board배열을 위에서 만들어봅시다.

                //배열을 주면 거기서 출력해주는 메소드를 분리해보자
                BoardUtil.list(boardArr);
                System.out.println("1.글 개별보기 2. 뒤로가기");
                System.out.println(">");
                userChoice=MyScanner.nextInt(sc);
                if(userChoice ==1) {
                    BoardUtil.showOne(boardArr, sc);
                }
                //리스트를 보여주고나서
                //해당 글에 들어가게 선택을 받는다
                System.out.println("1.글선택 2.뒤로");
                userChoice=MyScanner.nextInt(sc);
                if(userChoice==1) {
                 System.out.print("보실 글의 번호를 입력해주세요: ");
                userChoice=MyScanner.nextInt(sc);
                
                //먼저 헤딩히는 번호가 우리 배열의 각 요소들의 id로 존재하는지 체크하고 존재하면 
                //해당글보기로 이동
                //없으면 없는 글이라고 해주자
                //글 정보를 불러올 Board구조체 변수 b
                //초기화는 null로해서
                //만약 불러오기를 못한다면(글번호가 존재하지 않는다면)
                //null인지 체크해서 글 보여주기 or 존재하지않는 글번호
                //를 보여준다
                Board b = null;
                for(int i=0;i<boardArr.length;i++) {
                    if(boardArr[i].id==userChoice) {
                        b=boardArr[i];
                    }
                }
                 if(b==null) {  
                     System.out.println("존재하지 않는 글 번호입니다.");
                 } else {
                     System.out.println("제목: "+b.title);
                     System.out.println("작성자: "+b.writerId);
                     System.out.println("작성일: "+b.writtenDate);
                     System.out.println("내용: "+b.content);
                     System.out.println("1.수정 2. 삭제 3. 뒤로");
                     userChoice=MyScanner.nextInt(sc);
                     
                 }
                } else if(userChoice==2) {
                    
                }
            } else if(userChoice==2) {
                //글 작성하기
                //우리가 실제로 입력하는 것은 글 제목과 내용밖에 없다.
                //왜? 글쓴 회원번호는 로그인하면서 우리가 따로 갖고오란 말 안해도 자기가 알아서 관리를 해주고
                //작성날짜? 이것도 어디선가 자동으로 넣어줘야 되고
                //글번호? 맨마지막 글번호+1
                //자동으로 들어가야한다.
                //입력한데이터를 담아줄 board구조체의 변수를 하나 만들어준다.
                boardArr=BoardUtil.write(boardArr, sc);
                
                //boardArr의 요소와 비교해서 만약 시간이 null인 친구가 있으면? 그 친구 자리에도 넣어주자
//                for(int i=0;i<boardArr.length;i++) {
//                    if(boardArr[i].writtenDate==null) {
//                        boardArr[i]=b;
//                        break;
//                    }
//                }
                
                
            } else if(userChoice==3) {
                System.out.println("사용해주셔서 갑사합니다!");
                break;
            }
        }
        
        
        
        
        
        sc.close();
    }
    

}
