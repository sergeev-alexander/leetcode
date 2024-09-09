package alexander.sergeev.leetcode.tasks;

// 82. Remove Duplicates from Sorted List II
public class a82 {

    /*
    Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
    leaving only distinct numbers from the original list. Return the linked list sorted as well.
     */

    public static void main(String[] args) {

        ListNode head =
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(1,
                                        new ListNode(2,
                                                new ListNode(3, null)))));

        System.out.println(head);
        System.out.println(deleteDuplicates(head));

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode headPrevious = new ListNode(0, head);
        ListNode current = headPrevious;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                current.next = head.next;
            } else {
                current = current.next;
            }
            head = head.next;
        }
        return headPrevious.next;
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
            return this.val + " -> " + this.next;
        }
    }
}
