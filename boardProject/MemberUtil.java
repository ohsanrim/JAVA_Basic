package boardProject;

import java.util.Scanner;

import util.MyArray;
import util.MyScanner;

//오늘은 ㅡ즐겁게 로그인만들기
//로그인은 사용자가 아이디와 비번을 입력하였을 때
//배열에서 해다앙이디를 찾고
//존재하면 해당비비ㅓ이ㅏㅁㅈ는지 확인을 함
//즉 아이디 체크 후 비번
//두개 다 true가 나오면 null인 member변수와 해당배열의 요소를 연결시켜서 리턴
public class MemberUtil {

    public static String showNickName(Member[] memberArr, int id) {
        for (int i = 0; i < memberArr.length; i++) {
            if (memberArr[i].id == id) {
                return memberArr[i].nickName;
            }
        }
        return null;
    }

    public static Member logIn(Member[] memberArr, Member loginTry) {
        Member m = null;
        // 먼저 인덱스가 존재하는지 찾는다
        int index = MyArray.indexOf(memberArr, loginTry.userName);
        if (index != -1) {
            if (loginTry.password.contentEquals(memberArr[index].password)) {
                m = memberArr[index];
            }
        }
        return m;
    }

    public static Member logInPrint(Scanner sc, Member[] arr) {
        Member login = new Member();
        System.out.println("아이디를 입력해주세요");
        login.userName = sc.nextLine();
        System.out.println("비밀번호를 입력해주세요");
        login.password = sc.nextLine();
        login = MemberUtil.logIn(arr, login);
        while (login == null) {
            System.out.println("잘못입력하셨습니다.");
            login = new Member();
            System.out.println("아이디를 입력해주세요");
            login.userName = sc.nextLine();
            System.out.println("비밀번호를 입력해주세요");
            login.password = sc.nextLine();
            login = MemberUtil.logIn(arr, login);
        }
        return login;
    }

//index라는 메소드를 만들어서 게시판에 오신걸 환연합니다
//1. 로그인 2. 회원가입, 3. 종료
//요렇게 만들어서
//사용자가 아이디 비번, 등등을 입력하여서
//각자가 아이디를 따로 만들 수 있게 만들자
    public static Member[] index(Scanner sc, Member[] memberArr, BoardReplyWrapper wrapper) {
        // while을 통해서 choice가 3일 경우엔 해당 메소드 종료
        // 1.일때는 로그인 실행
        // 2.일 경우에는 회원가입하는 메소드 실행
        while (true) {
            System.out.println("비트게시판");
            System.out.println("1. 로그인 2. 회원가입 3. 종료");
            int choice = MyScanner.nextInt(sc);
            if (choice == 1) {
                // 로그인 실행
                Member logInUser = logInPrint(sc, memberArr);
                showMenu(sc, memberArr, wrapper, logInUser);
                break;
            } else if (choice == 2) {
                // 회원가입 실행
                memberArr = register(sc, memberArr);
            } else if (choice == 3) {
                System.out.println("사용해주셔서 갑사합니다!");
                break;
            }

        }
        return memberArr;
    }

    private static Member[] register(Scanner sc, Member[] arr) {
        Member m = new Member();
        System.out.print("사용할 아이디를 적어주세요: ");
        m.userName = sc.nextLine();
        // 해당 userName이 존재하는지부터 체크한다.
        // 어떻게? indexOf의 결과값이 -1이 아니면 계속 돌아가게 된다.
        while (MyArray.indexOf(arr, m.userName) != -1) {
            System.out.println("이미 존재하는 아이디입니다");
            System.out.print("사용할 아이디를 적어주세요: ");
            m.userName = sc.nextLine();
        }
        System.out.println("사용할 패스워드를 적어주세요");
        m.password = sc.nextLine();
        System.out.println("사용할 닉네임을 적어주세요: ");
        m.nickName = sc.nextLine();
        m.id = 1;
        if (arr.length != 0) {
            m.id = arr[arr.length - 1].id + 1;
        }
        arr = MyArray.add(arr, m);

        return arr;
    }

    private static void showMenu(Scanner sc, Member[] memberArr, BoardReplyWrapper wrapper, Member member) {
        // 파라미터 설명 :
        // Scanner: 입력에 필요
        // Member[] memberArr: 회원 모아놓은 배열
        // Board[] boardArr: 게시글 모아놓은 배열
        // Reply[] repplyArr: 댓글 모아놓은 배열
        // Member member:로그인한 유저
        while (true) {
            System.out.println("================비트게시판=================");
            System.out.println("1.글 목록 2. 새로작성 3. 로그아웃 4. 종료");
            System.out.println(">");
            int userChoice = MyScanner.nextInt(sc);
            if (userChoice == 1) {
                BoardUtil.list(wrapper, memberArr);
                if (wrapper.boardArr.length > 0) {
                    System.out.println("1.글 개별보기 2. 뒤로가기");
                    System.out.println(">");
                    userChoice = MyScanner.nextInt(sc);
                    if (userChoice == 1) {
                        wrapper = BoardUtil.showOne(sc, member, memberArr, wrapper);
                    }
                }

            } else if (userChoice == 2) {
                wrapper.boardArr = BoardUtil.write(wrapper.boardArr, sc, member);
            } else if (userChoice == 4) {
                System.out.println("사용해주셔서 갑사합니다!");
                break;
            } else if (userChoice == 3) {
                member = null;
                while (member == null) {
                    System.out.println("1.회원가입 2. 로그인 3. 종료");
                    userChoice = MyScanner.nextInt(sc);
                    if (userChoice == 1) {
                        // 회원가입 실행
                        memberArr = register(sc, memberArr);
                    } else if (userChoice == 2) {
                        // 로그인
                        member = logInPrint(sc, memberArr);
                    } else if (userChoice == 3) {

                        break;
                    }
                }
            }
            // 여기서 userChoice가 얼마인지 출력해보면 우리가 마지막으로 무엇을 선택했는지의 값이 남아있다
            // 근데 만약 userChoice가 3이라면???
            if (userChoice == 3) {
                System.out.println("로그아웃 후 종료되었습니다.");
                break;
            }
        }
    }
}
