package alexander.sergeev.leetcode.tasks;

// 86. Partition List
public class a86 {

    /*
    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
    greater than or equal to x.
    You should preserve the original relative order of the nodes in each of the two partitions.
     */

    public static void main(String[] args) {

        ListNode head =
                new ListNode(1,
                        new ListNode(4,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(5,
                                                        new ListNode(2, null))))));

        System.out.println(head);
        System.out.println(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode firstLeft = new ListNode(0, null);
        ListNode left = firstLeft;
        ListNode firstRight = new ListNode(0, null);
        ListNode right = firstRight;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = firstRight.next;
        return firstLeft.next;
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
            return val + " => " + next;
        }
    }
}