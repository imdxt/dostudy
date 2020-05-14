package test;

/**
 * 反转一个单链表。
 *
 *     示例:
 *
 *     输入: 1->2->3->4->5->NULL
 *     输出: 5->4->3->2->1->NULL
 */
public class ReverseList {


    public static void main(String[] agrs){
        ListNode head = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);
        ListNode node5 = new ListNode(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

//        ListNode result = reverseList(head);
        ListNode result = reverseList1(head);
        while (result != null){
            System.out.println("=== val "+result.val);
            result = result.next;
        }

    }

    public static ListNode reverseList(ListNode head) {

        //前一个节点，这个是关键点，用来反转指向的
        ListNode preNode = null;
        //当前节点
        ListNode curNode = head;
        while (curNode != null){
            System.out.println(" cur "+curNode.val);
            //取出下一个节点
            ListNode next = curNode.next;
            //当前节点指向前一个节点
            curNode.next = preNode;
            //当前节点 作为下次循环的前一个节点
            preNode = curNode;
            //下个节点 作为下次循环的当前节点
            curNode = next;
        }

        return  preNode;
    }
    private  static ListNode reverseList1(ListNode head){

        if(head == null || head.next == null){//最后一个可以跳出
            return head;
        }
        //链表递归到最后最后一个的前一个，最后一个的next指向前一个，前一个的next指向null，循环
        ListNode p = reverseList1(head.next);
            System.out.println(" head "+head.val);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
