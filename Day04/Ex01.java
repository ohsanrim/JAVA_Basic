package Day04;
//메소드란 우리가 어떠한 값을 주고 그리고 그값을 년산해서 해당 메소드가 리턴된 곳으로 그 결과값을 보내주는 기능이다. 

//c에서는 function혹은 함수라고 부리지만 자바에서는 메소드라고 한다.

public class Ex01 {
    
    
//메소드의 선언
    // (접근제한자 static)returnType name(parameter)
    // 접근제한자: access modifier
    // 접근제한자란, 해당 메소드 혹은 필드가 어디서 접근이 가능한 범위를 적어준다.
    // public > protected > defalult > private
    // public: "공공의"
    // 패키지 내, 외부, 다른 클래스 어디서든 호출 가능
    // protected: "보호된"같은 패키지와 상속받는 자식 클래스들은 호출 가능
    // default: "기본의", 같은 패키지 내부에서만 호출 가능
    //          만약 아무것도 안적어주면 default가 적용된다.
    // private: "사적인", 같은 클래스만 접근 가능하다.
    
    
    // static:해당메소드를 메소드 영역에 등록
    // 만약 스태틱 메소드가 다른 메소드를 호출하게 되면 그 다른 메소드를 객체생성해서 호출하는 것이 아니면 그 다른 메소드도 Static이
    // 붙어야 함
    //
    // returnType: 해당 메소드가 끝나도 호출된 곳으로 보내줄 값의 datatype
    //             만약에 우리가 숫자를 줘서 그 숫자의 합을 구하는 메소드가 있다고 가정하면 해당메소드의 리턴타입은 당연히 int가 된다.
    //             하지만 만약 해당 메소드가 아무런 값도 리턴하지 않는다면 "void"라고 적어주면 된다.
    // name: 소문자+동사
    //       nextInt(), NextLine(); 등과 같은 원리
    // parameter: 이 메소드가 호출될 때 외부에서 보내주는 값(datatype name)
    //            만약 해당 메소드가 호출될 ㄷ때 아무런 값도 필요없다면 아무것도 안적어줘도 된다.
    //            또한파라미터는 일종의 변수취급되어서 해당 메소드 내부에서는 우리가 똑같은 이름의 변수를 만들어 줄 수 없다.
    //            그리고 메소드를 호출한 곳에서는 굳이 똑같은 이름으로 값을 보내줄 필요가 없다.
    
    // 사실 여러분들이 어떤ㅁ 무언가를 봤을 때 메소드인지 아닌지는 엄청 쉽게 알아차릴 수 있다
    //어떻게?
    //괄호가 붙어있으면 무조건 메소드!!!!!!!!!!
    //우리가 한번 더하기를 해주는 메소드를 직접 만들어보자
    
    public static void main(String[] args) {
        int userNumber1 =10;
        int userNunber2 =25;
        
        //메소드를 호출할 때는 우리가 파라미터를 메소드에 선언한 그대로 적어주어야 한다. 
        //만약 우리가 add(int a, double b)라고 했는데 
        //add(5,10)이라고 입력하면 에러가 난다. 
        //왜냐면 10은 int이지 double이 아니기 때문
       
        int add = add(userNumber1,userNunber2);
        int subtract = subtract(userNumber1,userNunber2);
        int multiply = multiply(userNumber1,userNunber2);
        int divide = divide(userNumber1,userNunber2);
        //그리고 우리가 설정한 이름은 username,이지만 메소드 내부에서 입력받을 땐 a로 입력받음 
        //때문에 굳이 이름이 안 똑같아도됨
        
        System.out.println(add);
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(divide);
        //ADD를 오버로딩 하는 법
        
        double doubleResult = add (3.14, 6.02);
        System.out.println(doubleResult);
    }
    public static int add(int a, int b) {//메인 메소드에서 호출할 것이므로 static을 붙여준다.
        //리턴은 return이라는 명령어로 한다.
        return a+b;
    }
    //add를 오버로딩해봅시다.
    //파라미터만 다르면 된다. 위의 결과 확인!
    public static double add(double a , double b) {
        return a+b;
    }
    
    
    public static int subtract(int a, int b) {
        return a-b;
    }
    public static int multiply(int a, int b) {
        return a*b;
    } 
    public static int divide(int a, int b) {
        return a/b;
    }
    public static boolean validate(int score) {
       // return의 특징은 만나는 순간 해당 메소드가 곧장 종료가 된다는 것이다. 
        if(score>100||score<0) {
            return true;
        }
        return false;
    }
//파라미터가다르다는건 어떤 의미일까 
    
    //다음중 파라미터가 다르다에 포함되는걸 모두 선택해주세요
    
    //가. 파라미터의 이름
    //나. 파라미터의 개수
    //다. 파라미터의 데이터타입
    //1. 가 2. 나  3. 다  4. 가,나  5. 가,다  6. 나,다
    //답: 6번
    //개수와 데이터 타입이달라야 함
    //만약 이름만 다르다고 메소드가 달라지면 
    //public int add (int num1 ,int num2)
    //public int add (int positivenumber1, int positivenumber2)
    //add(3,5)를 호출할 시에는 무엇이 불러와지는가?
    //오버로딩(overLoading) 개념이 나온 이ㅣ유
    // 한 클래스 안에 비슷한 기능을 하지만 파라미터가 달라지는 경우
    //굳이 이름을 바꿀 필요 없이 똑같은이름으로 해서 모아두기 위함이다.
    //자바에는 오버라이딩이라는개념역시 존재하는데
    //오버라이딩의 경우 부모클래스로부터 상속받은 베소드를 
    //자식이 다시 정의하는것을 오버라이딩이라고 한다. 
    //지금은 우리가 그냥 모든 메소드들을 다 한파일에 몰아넣었짐만
    //실제로 메소드가 하는 역할과 어떤 필들을 공통적으로 가지냐에 따라서
    //클래스 별로 구분을 해야 한다. 
    //예시: 우리가 여기서 만든, ADD, SUBSTRACT 이런 친구들은
    //CALCULATOR 라는 별도의 클래스를 만들어서 그 안에ㅐ 넣고 우리는 필요에 따라서
    //CALCULATOR객체를 만들어서 그 객체의 메소드를 별도의 호출 해야한다
    //잘 만들어진 클래스: 공통분모를 잘 잡는 것
    //pseudocoding
    //pseudo란? 가짜, 유사한 이란 의미
    
    //pseudocoding이란 실제 코드는 아니지만 우리가 어느정도 생각을 정리하면서
    //어떠한 코드가 필요하겠다 하면서 대충 코드적는 것
    //실제 코딩에서 만약 우리가 계산기를 만들면
    //실제로도 실행이 가능한 코드들을 적어줘야 하지만
    //개발 전에 계획단계에서는 
    //그냥 손으로 더하디(정수, 정수), 더하기 (실수, 실수)
    //이런 식으로 적어서 어떤 메소드가 필요하고 그 메소드들이 어떤 알고리즘이 필요한디
    //어떤 데이터를 만들면 편할 지 계획을 짤 때 이용한다. 
    //수도코드의 예시:
    //더하기(정수, 정수){
    //   두개 더한거 리턴;
    //}
    //데이터베이스의 기능은 crud이다
    //c: create(데이터의생성)
    //r: retrieve(데이터의 회수)
    //u: update(데이터의 수정)
    //d: delete(데이터의 삭제)
    
    
    
    
    
    
}
