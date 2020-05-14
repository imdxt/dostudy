package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 解题思路
 *      hash表，重复则有环
 *      双指针：快慢指针
 *
 * 注意事项：
 *      会有重复数据
 *      不能用值判重，但可以用节点判重
 *      异常方式
 *      递归，可以不管原对象
 */
public class CycleList {

    public static void main(String[] agrs){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

//        System.out.println("=== hasCycel  "+hasCycel(head));
        System.out.println("=== hasCycel  "+hasCycel2(head));

    }
    //使用hash存储已经访问过的节点，已经存在节点，说明是环形链表
    private static boolean hasCycel(ListNode head){
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            System.out.println(" cur "+head.val);
            if(nodeSet.contains(head)){
                return true;
            }
            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }

    //=============================START=======================================
    private static ListNode detectCycel(ListNode head){
        //存储链表的节点
        Set<ListNode> nodeSet = new HashSet<>();
        //记录当前的节点
        ListNode cur = head;
        while (cur != null){
            if(nodeSet.contains(cur)){
                return cur;
            }
            nodeSet.add(cur);
            //指向下一个节点
            cur = cur.next;
        }
        return null;
    }
    //获取相遇节点
    private static ListNode getIntersect(ListNode head){
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise){
                return tortoise;
            }
        }
        return null;
    }
    private static ListNode detectCycel1(ListNode head){
        ListNode intersect = getIntersect(head);
        if(intersect == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = intersect;
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    //============================END========================================

    //使用快慢指针的方式，如果两个指针相等则，快指针追上了慢指针，出现了环形链表
    private static boolean hasCycel2(ListNode head){
        if(head == null || head.next == null){
            return  false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast ==  null || fast.next == null){
                return  false;
            }
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("----"+slow.val +" /"+fast.val);

        }

        return true;
    }


}
