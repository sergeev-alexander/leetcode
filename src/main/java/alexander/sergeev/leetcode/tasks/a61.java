package alexander.sergeev.leetcode.tasks;

// 61. Rotate List
public class a61 {

    /*
    Given the head of a linked list, rotate the list to the right by k places.
    Example:
    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]
     */

    public static void main(String[] args) {

        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)))));

        int k = 2;

        ListNode result = rotateRight(head, k);

        while (result != null) {
            System.out.println(result);
            result = result.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode oldTail = head;
        int listLength;

        for (listLength = 1; oldTail.next != null; listLength++) {
            oldTail = oldTail.next;
        }

        oldTail.next = head;

        ListNode newTail = head;

        for (int i = 0; i < listLength - (k % listLength) - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }

    public static ListNode rotateRightSLOW(ListNode head, int k) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode first = head;
        ListNode last;

        for (int i = 0; i < k; i++) {

            ListNode temp = first;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            last = temp.next;
            last.next = first;
            first = last;
            temp.next = null;
        }
        return first;
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
            String result = String.valueOf(this.val);
            ListNode next = this.next;
            if (next == null) {
                result += " => null";
            } else {
                result += " => ";
                result += String.valueOf(next.val);
            }
            return result;
        }
    }
}


