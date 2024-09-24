package alexander.sergeev.leetcode.tasks;

import alexander.sergeev.Temp;

// 147. Insertion Sort List
public class a147 {

    /*
    Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
     */

    public static void main(String[] args) {

        ListNode head = new ListNode(4,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(3, null))));

        System.out.println(insertionSortList(head));
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode begin = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode prev = begin;
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return begin.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "(" + val + ") => " + next;
        }
    }
}
