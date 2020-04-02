package corona_Project;
//세계현황에서 쓸 데이터타입을 미리 구현해놓는 구조체 클래스
//id-> 해당 나라에 고유적으로 부여된 숫자값
///데이터베이스에서의 primary 키/거의 전부 int

//나라이름->String->String Name
//확진자수->int ->int confirmed
//사망자수->int->int death
//완치자수->int->int cured
//총인구->int->int population
//이름응지을떄 우리가 굳이 필드의 이름에 nation아이디 이런식으로 지을 필요가 없다
//왜냐하면 nation안에는 id가 하나밖에 없고
//다른데서호출할 때에는 nation아이디로 접근하는것이 아니라
//굳이 별도로 이름을 지정해줄 필요없다
public class Nation {
    
    public int id;
    public String name;
    public int confirmed;
    public int cured;
    public int death;
    public int population;
    
    

        
        

}
