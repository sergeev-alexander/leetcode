package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 142. Linked List Cycle II
public class a142 {

    /*
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
    is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    Do not modify the linked list.
     */

    public static void main(String[] args) {

        ListNode l4 = new ListNode(-4, null);
        ListNode l0 = new ListNode(0, l4);
        ListNode l2 = new ListNode(2, l0);
        ListNode head = new ListNode(3, l2);
        l4.next = l2;

        System.out.println(detectCycle(head));
    }

    // Could be faster...
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
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
