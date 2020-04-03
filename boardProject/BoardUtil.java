package boardProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import util.MyArray;
import util.MyScanner;

//board구조체와 관련된 메소드를 모아둔 boardUtil

public class BoardUtil {
//긃번호, 제목, 작성자, 작성일을 한 줄에 보여주는 
    //list라는 메소드
    //
    public static void list(Board[] boardArr) {
        //근데 우리가 게시판같은 걸 보면 최근 글이 제일 위로 올라온다.
        //그럼 for문의 i는 무엇으로 초기화 할까>
        for(int i=boardArr.length-1;i>=0;i--) {
            Board b = boardArr[i];
            System.out.println(b.id+" "+b.title+" "+ b.writerId+" "+ b.writtenDate);
        }
    }
    public static Board[] write(Board[] boardArr, Scanner sc) {
        Board b = new Board();
        b.id=1;
        if(boardArr.length !=0) {
            //배열의 가장 마지막 요소의 index는 얼마?
            //length-1
            //그럼 해당 위치에 있는 board 구조체의 id+1한 값이 우리의 입력할 id가 된다.
            b.id=boardArr[boardArr.length-1].id+1;
        }
        //원래대로라면 글 번호는 일단 테스트용으로 b.id=1로 우리가 합시다
        //
        //글번호를 배열을 돌아다니면서 널이 아닌 곳을 찾아서 
        //그 글의 번호를 자동으로 입력하는 코드를 만들어봅시다.
        
        
        
        //이 메소드는 boardArr의 길이가 유동적이기 때문에 우리는 boardArr의 길이가 0이아니면 가장 마지막요소를 찾아서
        //그 요소의 id번호를 가져올 수 있다.
  
        System.out.println("제목: ");
        b.title=sc.nextLine();
        System.out.println("내용: ");
        b.content= sc.nextLine();
        //테스트로써 작성자 회원번호 1로 초기화
        b.writerId=1;
        //날짜를 우리가 원하는 형식으로 자동 입력하기
        Calendar c = Calendar.getInstance();
        //위의 코드는 지금 현재시간을 c에 저장함
        //지금 현재시간은 1970년 01월 10 일 0시0분0초(그리니치 표준시)
        //부터 현재시간을 1/1000초로 나타낸 것이다. 
        //c에 저장된 시간을 우리가 원하는 형식의 String으로 바꿔주는 
        //simpleDateFormat이라는 클래스를 이용해서 시간을 String으로 바꿔준다.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        //위의 주석을 제외한 실제 코드는 여러분들이 
        //현장에서도 현재시간을 특정형식으로 보여줄 때 쓰는 
        //표준과도 같은 코드이니 알아두면 좋다!
        b.writtenDate= sdf.format(c.getTime());
        boardArr= MyArray.add(boardArr, b);
        return boardArr;
    }
    
    //사용자가 int와 board배열을 주면 
    //해당 board배열에서 id와 int가 일치하는 board변수를 리턴하는 메소드
    private static Board selectOne(Board[] boardArr, int id) {
        for(int i=0;i<boardArr.length;i++) {
            if(boardArr[i].id ==id) {
                return boardArr[i];
            }
        }
        
        return null;
    }
    public static void showOne(Board[] boardArr,Scanner sc) {
        System.out.println("개별보기 할 글 번호를 입력해주세요");
        int id = MyScanner.nextInt(sc);
        Board b= selectOne(boardArr,id);
        if(b==null) {
            System.out.println("존재하지 않는 글번호입니다.");
        } else {
            System.out.println("제목: "+b.title);
            System.out.println("작성자: "+b.writerId);
            System.out.println("작성일: "+b.writtenDate);
            System.out.println("내용: "+b.content);
            System.out.println("1.수정 2. 삭제 3. 뒤로");
            //근데 수정, 삭제는 글을 쓴 회원만 해야하지 않을까?
            //그럼 회원정보를 담당할 Member구조체를 우리가 따로 만들어야 한다,.
            
            int userChoice=MyScanner.nextInt(sc);
            
        }
    }
    public static Board[] boardRemove(Board[] boardArr,Scanner sc ) {
        
        System.out.print("삭제하고 싶은 게시글의 번호를 입력해주세요: ");
        int id = MyScanner.nextInt(sc);
        Board b=selectOne(boardArr,id);
        boardArr= MyArray.remove(boardArr, b);
        System.out.println("삭제되었습니다!");
        
        return boardArr;
        
    }

}
