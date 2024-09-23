package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 141. Linked List Cycle
public class a141 {

    /*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.
    There is a cycle in a linked list if there is some node in the list that can be reached again by
    continuously following the next pointer. Internally, pos is used to denote the index of the node
    that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    Return true if there is a cycle in the linked list. Otherwise, return false.
     */

    public static void main(String[] args) {

        ListNode l4 = new ListNode(-4, null);
        ListNode l0 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l0);
        ListNode head = new ListNode(3, l2);
        l4.next = l2;

        System.out.println(hasCycle(head));
    }

    // Could be faster...
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + val + ") => " + next;
        }
    }
}
