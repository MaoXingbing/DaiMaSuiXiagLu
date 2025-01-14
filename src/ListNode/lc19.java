package ListNode;

public class lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode c=head;
        while (c!=null){
            c=c.next;
            size++;
        }
        ListNode dum=new ListNode();
        dum.next=head;
        ListNode cur=dum;
        int num=size-n+1;
        for (int i = 1; i < num; i++) {
            cur=cur.next;
        }
        cur.next = cur.next.next;
        return dum.next;
    }
}
