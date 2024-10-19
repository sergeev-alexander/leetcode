package alexander.sergeev.leetcode.tasks;

// 2807. Insert Greatest Common Divisors in Linked List
public class a2807 {

    /*
    Given the head of a linked list head, in which each node contains an integer value.
    Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
    Return the linked list after insertion.
    The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
     */

    public static void main(String[] args) {
        ListNode head =
                new ListNode(18,
                        new ListNode(6,
                                new ListNode(10,
                                        new ListNode(3))));

        System.out.println(insertGreatestCommonDivisors(head));
    }

    // BEATS 100%
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        while (head != null) {
            if (head.next != null) {
                ListNode second = head.next;
                int x = head.val;
                int y = second.val;
                while (x != 0 && y != 0) {
                    if (x > y) x = x % y;
                    else y = y % x;
                }
                int min = x + y;
                head.next = new ListNode(min, second);
                head = head.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode insertGreatestCommonDivisors_BEATS_14_PERCENT(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        while (head != null) {
            if (head.next != null) {
                ListNode second = head.next;
                int min = Math.min(head.val, second.val);
                for (int i = min; i > 0 ; i--) {
                    if (head.val % i == 0 && second.val % i == 0) {
                        min = i;
                        break;
                    }
                }
                head.next = new ListNode(min, second);
                head = head.next;
            }
            head = head.next;
        }
        return dummy.next;
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
            return "(" + val + ") => " + next;
        }
    }
}