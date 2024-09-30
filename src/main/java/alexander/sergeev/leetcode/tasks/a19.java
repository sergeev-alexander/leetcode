package alexander.sergeev.leetcode.tasks;

// 19. Remove Nth Node From End of List
public class a19 {

    /*
    Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */


    public static void main(String[] args) {

        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5, null)))));
        System.out.println(removeNthFromEnd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0, head);
        ListNode fast = preHead;
        ListNode slow = preHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
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

