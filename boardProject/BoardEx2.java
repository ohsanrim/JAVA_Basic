package boardProject;

import java.util.Scanner;
import util.MyArray;
import util.MyScanner;

public class BoardEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board[] boardArr = new Board[0];
        Reply[] replyArr = new Reply[0];
        BoardReplyWrapper wrapper = new BoardReplyWrapper();
        wrapper.boardArr = boardArr;
        wrapper.replyArr=replyArr;
        Member member = new Member();
        member.nickName = "운영자";
        member.userName = "admin";
        member.password = "111";
        member.id = 1;

        Board b = new Board();
        
        b.id = 1;
        b.title="테스트 제목";
        b.content="테스트 내용";
        b.writerId=1;
        wrapper.boardArr=MyArray.add(boardArr, b);
//        boardArr = MyArray.add(boardArr,b);
        
        Member[] memberArr = new Member[0];
        memberArr = MyArray.add(memberArr, member);
        
        MemberUtil.index(sc, memberArr, wrapper);
//		Member login = MemberUtil,logInPrint(sc, MemberArr);
        
        sc.close();
    }
}
