package test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode result = reverseKGroup1(head,2);
        while (result != null){
            System.out.println("=== result val "+result.val);
            result = result.next;
        }
    }

    /**
     * 步骤分解:
     *
     * 链表分区为已翻转部分+待翻转部分+未翻转部分
     * 每次翻转前，要确定翻转链表的范围，这个必须通过 k 此循环来确定
     * 需记录翻转链表前驱和后继，方便翻转完成后把已翻转部分和未翻转部分连接起来
     * 初始需要两个变量 pre 和 end，pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
     * 经过k此循环，end 到达末尾，记录待翻转链表的后继 next = end.next
     * 翻转链表，然后将三部分链表连接起来，然后重置 pre 和 end 指针，然后进入下一次循环
     * 特殊情况，当翻转部分长度不足 k 时，在定位 end 完成后，end==null，已经到达末尾，说明题目已完成，直接返回即可
     *
     * @param head
     * @param k
     * @return
     */
    private static ListNode reverseKGroup(ListNode head,int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            System.out.println("===end "+end.val);
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            System.out.println("===pre  "+pre.val);

            start.next = next;
            pre = start;
            end = pre;
            System.out.println("===end pre "+pre.val);
        }

        return dummy.next;
    }
    private static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    /**
     * 使用入栈模式，出栈自动翻转
     * @param head
     * @param k
     * @return
     */
    private static  ListNode reverseKGroup1(ListNode head,int k){
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (true){
            ListNode tem = head;
            int count = 0;
            while (tem != null && count < k){
                System.out.println("  tem = "+tem.val);
                stack.push(tem);
                count++;
                tem = tem.next;
            }
            if(count != k){
                pre.next = head;
                break;
            }
            while (!stack.isEmpty()){
                pre.next = stack.pop();
                System.out.println("  pre.next = "+pre.next.val);
                pre = pre.next;
            }
            pre.next = tem;
            head = tem;
        }

        return dummy.next;
    }
}
