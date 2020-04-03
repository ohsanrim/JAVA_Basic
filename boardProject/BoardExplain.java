package boardProject;


//-글쓴이:이것도 String을 쓰는 게 아니라 int를 쓴다.
//왜냐하면 우리가 읾을 보여주는게 아니라 이름을 곧장 가지고 있는 것이 아니라 글쓴 사람의 회원번호를 가지고 있고 보여줄 때는 그 회원번호를 통해서 보여줘야 한다.

//-내용: String 
//-제목: String
//-글 번호: int + database로 만들었으면 우리가 자동으로 글을 입력하면 database가 알아서 마지막 글 번호보다 1 큰 글번호를 지정해주지만, 우리는 아직까지도 
//데이터베이스가 없어서-> 아니다 우리가 메소드로 구현을 하면 된다.






//<댓글과 관련된 구조체>
//댓글번호->int 글 번호처럼 자동으로 1씩 올라간다. 
//글번호->이 댓글이 어느 글에 붙어있나
//제목,내용, 글쓴이 같이 중복이 가능한 곳과 댓글을 연결시킨다면?
//내가 댓글을 달지않은 경우에도 자동으로 같이 달리거나
//내가 단 댓글이 다른곳에 적힐 수도 있다.
///->즉 하나에 고유한 것과 연결시켜줘야 한다.
//회원번호-> int 
//댓글의 내용-> String
//int memberId
//eotrmfdml sodyd->String
//String content


//<회원정보와 관련된 구조체>
//회원번호
//회원유저네임->아이디
//회원비밀번호
//회원닉네임


public class BoardExplain {
//1. member배열에 대한 add, expend 등의 배열메소드를 myArray.java에 만들기
//2. reply구조체를 만들어 주시고 reply배열에 대한 add, expend등의 메소드를 MyArray.java에 만들기
//3. board, member, reply에 재한 remove를 MyArray.java에 만들기

}
