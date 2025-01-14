package ListNode;

public class lc142 {
    public ListNode detectCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;

        //寻找相遇节点
        while (fast!=slow){
          fast=fast.next;
          slow=slow.next;
          if (fast==slow){
              ListNode index1=fast;
              ListNode index2=head;
              while (index1!=index2){
                  index1=index1.next;
                  index2=index2.next;
              }
              return index1;
          }
        }
        return  null;

    }
}
