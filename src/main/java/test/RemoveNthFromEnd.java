package test;

/**
 *         删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 注意：需要一个假的节点来处理复杂情况，比如只有一个是时候
 */
public class RemoveNthFromEnd {
    public static void main(String[] args){

    }

    //两次遍历，第一次遍历链表长度，第二次找到需要删除节点的前一个节点，next = next.next
    private static ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int len = 0;
        while (first != null){
           first = first.next;
           len++;
        }
        System.out.println("  len =="+len+"/ n= "+n);
        len -= n;
        first = dummy;//dummy 是头节点的前一个节点，所有遍历完成之后first是删除的前一个节点
        while (len > 0){
            len--;
            first = first.next;
        }
        System.out.println("  node "+first.val);
        first.next = first.next.next;
        return dummy.next;
    }

    //快慢指针，快指针移动到n + 1的位置，然后两个指针同时移动，快指针next == null的时候到达链表结尾，此时慢指针到了删除节点的，执行删除操作
    private static ListNode removeNthFromEnd1(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (n >= 0){
            n--;
            fast = fast.next;
        }
        while (fast != null){
            System.out.println("===fast "+fast.val);
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println("===slow "+slow.val);
        slow.next = slow.next.next;

        return dummy.next;
    }

    //递归计数方式,链表到达末尾返回1，往前一个+1，到达倒数n的时候执行删除操作
    private static ListNode removeNthFromEnd2(ListNode head,int n){
        if(removeNode(head,n) == n){//如果删除的是第一个，则计数和n相等
            return head.next;
        }else {
            return head;
        }
    }
    private static int removeNode(ListNode node,int n){
        if(node == null || node.next == null)return 1;
        int m = removeNode(node.next,n);
        System.out.println("remove ---end node "+node.val+"/ m "+m);
        if(m == n){
            if( m == 1){
                node.next = null;
            }else {
                node.next = node.next.next;
            }
        }
        return m + 1;
    }
}
