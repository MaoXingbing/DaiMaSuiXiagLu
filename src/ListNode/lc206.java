package ListNode;

public class lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode j=head;
        ListNode i = null;
        while (j!=null){
            //指针翻转操作
            temp=j.next;
            j.next=i;
            //向后移动
            j=temp;
            i=j;
        }
        return i;
    }
    public ListNode reverseList02(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
       if (cur==null){
           return prev;
       }
       ListNode temp;
       temp=cur.next;
       cur.next=prev;
       return reverse(cur,temp);
    }
}
