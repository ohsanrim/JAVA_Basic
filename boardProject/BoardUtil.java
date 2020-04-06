package boardProject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import util.MyArray;
import util.MyScanner;

//board구조체와 관련된 메소드를 모아둔 boardUtil

public class BoardUtil {
    // 긃번호, 제목, 작성자, 작성일을 한 줄에 보여주는
    // list라는 메소드
    public static void list(BoardReplyWrapper wrapper, Member[] memberArr) {
        for (int i = wrapper.boardArr.length - 1; i >= 0; i--) {
            Board b = wrapper.boardArr[i];
            int count = ReplyUtil.countReply(b.id,  wrapper.replyArr);
            String message=b.id + " " + b.title + " ";
            
            if(count!=0) {
                message+="["+count+"]";
            }
            message +=MemberUtil.showNickName(memberArr, b.writerId)+" "+ b.writerId + " " + b.writtenDate;
            System.out.println(message);
        }
    }
    
    public static Board[] write(Board[] boardArr, Scanner sc, Member member) {
        Board b = new Board();
        b.id = 1;
        if (boardArr.length != 0) {
            b.id = boardArr[boardArr.length - 1].id + 1;
        }

        System.out.println("제목: ");
        b.title = sc.nextLine();
        System.out.println("내용: ");
        b.content = sc.nextLine();
        // 테스트로써 작성자 회원번호 1로 초기화
        b.writerId = member.id;
        Calendar c = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        b.writtenDate = sdf.format(c.getTime());
        boardArr = MyArray.add(boardArr, b);
        return boardArr;
    }

    private static Board selectOne(Board[] boardArr, int id) {
        for (int i = 0; i < boardArr.length; i++) {
            if (boardArr[i].id == id) {
                return boardArr[i];
            }
        }

        return null;
    }

    public static BoardReplyWrapper showOne( Scanner sc, Member member, Member[] memberArr, BoardReplyWrapper wrapper) {
        System.out.println("개별보기 할 글 번호를 입력해주세요");
        int id = MyScanner.nextInt(sc);
        Board b = selectOne(wrapper.boardArr, id);
        if (b == null) {
            System.out.println("존재하지 않는 글번호입니다.");
        } else {
            System.out.println("제목: " + b.title);
            System.out.println("작성자: " + MemberUtil.showNickName(memberArr, b.writerId));
            System.out.println("작성일: " + b.writtenDate);
            System.out.println("내용: " + b.content);
            System.out.println("=======================================================");
            ReplyUtil.list(wrapper.replyArr, b.id, memberArr);
            
            if (member.id == b.writerId) {
                System.out.println("1.수정 2. 삭제 3. 뒤로");
                // 근데 수정, 삭제는 글을 쓴 회원만 해야하지 않을까?
                // 그럼 회원정보를 담당할 Member구조체를 우리가 따로 만들어야 한다,.

                int userChoice = MyScanner.nextInt(sc);
                if (userChoice == 1) {
                    // 수정하는 메소드를 호출
                    //Scanner, boardArr, board를 보내서
                    ///수정한 거를 해당 위치와 교환한다.
                    //수정에 필요한 재료: 현재 보여지는 글
                    System.out.println("=======글 수정=======");
                    System.out.print("수정할 제목: ");
                    b.title=sc.nextLine();
                    System.out.print("수정할 내용: ");
                    b.content=sc.nextLine();
                    //이 b가 위치한 index를 찾는다.
                    //앗 마침 MyScanner에 indexOf가 있지?
                    int index = MyArray.indexOf(wrapper.boardArr, b);
                    wrapper.boardArr[index]=b;
                    
                } else if (userChoice == 2) {
                    // 삭제하는 메소드 호출
                    // MyArray를 이용해서 boardArr에서 //board삭제!
                    wrapper.boardArr = MyArray.remove(wrapper.boardArr, b);
                    System.out.println("삭제가 완료되었습니다!");
                } else if (userChoice == 3) {
                    // 목록보기로 돌아간다.
                    list(wrapper, memberArr);
                }

            } else {
                //현재 문제 : 댓글 입력, 수정, 삭제권한
                //이 글을 벗어나면 사라진다
                //그럼 어떻게 해결할 수 있을까?
                //그러면 2가지 배열(boardArr와 replyArr를 통채로 가지고 있는 친구가 하나 있으면 걔로 왔다갔다 할 수 있지 않을까?
                
                
                System.out.println("1. 댓글달기 2.댓글 수정 3. 댓글 삭제  4.뒤로");
                System.out.println("> ");
                int userChoice = MyScanner.nextInt(sc);
                if (userChoice == 1) {
                    //댓글다는 메소드 실행
                    Reply r = new Reply();
                    r.memberId=member.id;
                    r.boardId=b.id;
                    System.out.print("댓글내용을 입력해주세요: ");
                    r.content=sc.nextLine();
                    wrapper.replyArr = ReplyUtil.insert(wrapper.replyArr, r);
                    showOne(sc, member, memberArr, wrapper);
                    
                } else if (userChoice == 2) {
                    //댓글 수정하는 메소드 실행
                    System.out.print("수정할 댓글의 번호를 입력해주세요: ");
                    Reply r = new Reply();
                    r.id = MyScanner.nextInt(sc);
                    int index = MyArray.indexOf(wrapper.replyArr, r);
                    
                  if(index!=-1) {
                      //해당 댓글릉 쓴 사람과 로그인을 한 유저가 동이ㄹ유저인지 확인
                      r=wrapper.replyArr[index];
                      if(r.memberId==member.id) {
                          //동일인물이므로 댓글수정 시작
                          System.out.print("내용: ");
                          r.content=sc.nextLine();
                          wrapper.replyArr[index]=r;
                      } else {
                          //다른 사람이므로 경고메세지 출력
                          System.out.println("권한이 없습니다!");
                      }
                  }else {
                      //조재하지 않는 번호
                      System.out.println("존재하지 않는 번호입니다.");
                  }

//                        if(r.memberId==member.id) {
//                            //마지막으로 한번 더 물어보고 사용자가 y라고 입력하면 삭제실행
//                            System.out.println("수정하시겠습니까(y/n)?");
//                            String agree = sc.nextLine();
//                            if(agree.equalsIgnoreCase("y")) {  //대문자든 소문자든 상관없이 y만 넣으면
//                                
//                                r.memberId=member.id;
//                                r.boardId=b.id;
//                                System.out.print("댓글내용을 입력해주세요: ");
//                                r.content=sc.nextLine();
//                                wrapper.replyArr[r.id-1] = r;
//                                showOne( sc, member, memberArr, wrapper);

                } else if (userChoice == 3) {
                    //댓글 삭제하는 메소드 실행
                    //먼저 댓글의 id를 선택하고
                    //해당 댓글을 쓴 사람이 로그인을 했는지 체크하고
                    //둘다에 해당하면 삭제
                    System.out.println("삭제할 댓글의 번호를 입력해주세요");
                    Reply r=new Reply();
                    r.id = MyScanner.nextInt(sc);
                    if(MyArray.indexOf(wrapper.replyArr,r)!=-1) {
                        r=wrapper.replyArr[MyArray.indexOf(wrapper.replyArr, r)];
                        if(r.memberId==member.id) {
                            //마지막으로 한번 더 물어보고 사용자가 y라고 입력하면 삭제실행
                            System.out.println("삭제하시겠습니까(y/n)?");
                            String agree = sc.nextLine();
                            if(agree.equalsIgnoreCase("y")) {  //대문자든 소문자든 상관없이 y만 넣으면
                                wrapper.replyArr = ReplyUtil.delete(wrapper.replyArr, r);
                                System.out.println("댓글이 삭제되었습니다!");
                            }
                        } else {
                            System.out.println("권한이 없습니다!");
                        }
                        //해당하는 id를 가진 reply가 존재
                        //이제 그 친구를 배열에서ㅜ 가져오자
                        //memberId와 member.id를 비교해서
                        //같으면 마지막으로 정말 삭제할지물어보고
                        //아니면 그냥 끝
                    } else {
                        System.out.println("없는 댓글번호입니다!");
                    }
                    
                } else if (userChoice == 4) {
                    list(wrapper, memberArr);
                }
            }
        }
        return wrapper;
    }
}
