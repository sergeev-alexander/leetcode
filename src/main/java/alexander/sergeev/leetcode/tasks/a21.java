package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 21. Merge Two Sorted Lists
public class a21 {

    /*
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists into one sorted list. The list should be made by splicing
    together the nodes of the first two lists.
    Return the head of the merged linked list.
     */

    public static void main(String[] args) {

        ListNode head1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4, null)));
        ListNode head2 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4, null)));

        System.out.println(mergeTwoLists(head1, head2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = new ListNode(0, null);
        ListNode result = first;
        List<ListNode> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2);
            list2 = list2.next;
        }
        list.sort(Comparator.comparingInt(l -> l.val));
        for (int i = 0; i < list.size(); i++) {
            first.next = list.get(i);
            if (i == list.size() - 1) {
                list.get(list.size() - 1).next = null;
            }
            first = first.next;
        }
        return result.next;
    }

    public static ListNode mergeTwoLists_WITH_RECURSION(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) return list2;
        return list1;
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
