package ListNode;

public class lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode cur = dumy;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;          // 保存第一个节点
            cur.next = cur.next.next;          // cur的下一个节点指向第二个节点
            temp.next = cur.next.next;         // 第一个节点的下一个节点指向第三个节点
            cur.next.next = temp;              // 第二个节点的下一个节点指向第一个节点

            cur = cur.next.next; // 移动cur到下一对节点的前一个节点
        }
        return dumy.next;
    }
}
