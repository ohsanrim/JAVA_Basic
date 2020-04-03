package boardProject;

public class MemberUtil {

        public static String showNickName(Member[] memberArr,int id) {
            for(int i=0;i<memberArr.length;i++) {
                if(memberArr[i].id ==id) {
                    return memberArr[i].nickName;
                }
            }
            return null;
        }


}
