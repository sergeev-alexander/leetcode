package alexander.sergeev.leetcode.tasks;

import java.util.HashSet;
import java.util.Set;

// 160. Intersection of Two Linked Lists
public class a160 {

    /*
    Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
    If the two linked lists have no intersection at all, return null.
     */

    public static void main(String[] args) {

        ListNode headA = new ListNode(4,
                new ListNode(1,
                        new ListNode(8,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        ListNode headB = new ListNode(5,
                new ListNode(6,
                        new ListNode(1,
                                headA.next.next)));

        System.out.println(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode_A_BIT_SLOWER(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode firstB = headB;
        while (headA != null) {
            while (headB != null) {
                if (headB == headA) {
                    return headA;
                }
                headB = headB.next;
            }
            headA = headA.next;
            headB = firstB;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + val + ")" + " => " + next;
        }
    }
}
