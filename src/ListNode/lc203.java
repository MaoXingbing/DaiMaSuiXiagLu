package ListNode;

public class lc203 {
    //不使用虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        //判断头结点
        while(head!=null&&head.val==val){
                head=head.next;
        }
        ListNode cur=head;
        while(cur!=null){
            //判断下一个节点与val相同  执行的删除操作
            while(cur.next!=null && cur.next.val==val){
                cur.next=cur.next.next;
            }
            //节点不与val相同  执行的下一个操作
            cur=cur.next;
        }
        return head;
    }


    //使用虚拟头结点
    public ListNode removeElements02(ListNode head, int val) {
        ListNode dummynode=new ListNode();
        //虚拟头结点
        dummynode.next=head;
        ListNode cur=dummynode;
        while (cur.next!=null){
            if (cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }

        }
      return dummynode.next;
    }
}
