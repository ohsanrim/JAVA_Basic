package boardProject;

import util.MyArray;

public class ReplyUtil {
//해당 게시글의 댓글을 보여주는 소드
    public static void list(Reply[] arr,int boardId,Member[] memberArr) {
        for(Reply r:arr) {
            if(r.boardId==boardId) {
                System.out.println(r.id+" "+r.content+" "+MemberUtil.showNickName(memberArr, r.memberId));
            }
        }
    }
    public static Reply[] insert(Reply[] arr, Reply r) {
        r.id=arr.length>0?arr[arr.length-1].id+1:1;
        arr=MyArray.add(arr, r);
        return arr;
    }
    public static Reply[] delete(Reply[] arr, Reply r) {
        arr=MyArray.remove(arr,r);
        return arr;
    }
    //해당 글의 갯수를 보여주는 메소드
    public static int countReply(int boardId, Reply[] replyArr) { 
        int count =0;
        
        
        for(Reply r:replyArr) {
            if(r.boardId==boardId) {
                count++;
            }
        }
        return count;
    }
    public static Reply[] upload(Reply[] arr, Reply r) {
        
        
        
        return arr;
    }
}
