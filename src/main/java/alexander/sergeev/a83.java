package alexander.sergeev;

// 83. Remove Duplicates from Sorted List
public class a83 {

    /*
    Given the head of a sorted linked list,
    delete all duplicates such that each element appears only once.
    Return the linked list sorted as well.
     */

    public static void main(String[] args) {

        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(3,
                                        new ListNode(4, null)))));

        head = deleteDuplicates(head);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode first = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return first;
    }

    public static class ListNode {
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
