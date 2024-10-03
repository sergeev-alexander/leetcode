package alexander.sergeev.leetcode.tasks;

// 24. Swap Nodes in Pairs
public class a24 {

    /*
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's nodes
    (i.e., only nodes themselves may be changed.)
     */
    public static void main(String[] args) {

        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4))));
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode second = head.next;
        ListNode pr = swapPairs(second.next);
        second.next = head;
        head.next = pr;
        return second;
    }

    public static ListNode swapPairs_ITERATIVE(ListNode head) {
        // The dummy node is used to simplify the edge case where the list might contain only one node.
        ListNode dummyNode = new ListNode(0, head);
        // 'previousNode' always points to the node before the pair that needs to be swapped.
        ListNode previousNode = dummyNode;
        // 'currentNode' is the first node in the pair that needs to be swapped.
        ListNode currentNode = head;
        // Iterate over the list in steps of two nodes at a time.
        while (currentNode != null && currentNode.next != null) {
            // 'nextNode' is the second node in the pair that needs to be swapped.
            ListNode nextNode = currentNode.next;
            // Swap the pair by adjusting the pointers.
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;
            previousNode.next = nextNode;
            // Move 'previousNode' pointer two nodes ahead to the last node of the swapped pair.
            previousNode = currentNode;
            // Advance 'currentNode' to the next pair of nodes to swap.
            currentNode = currentNode.next;
        }
        // The 'next' of dummy node points to the new head after swapping pairs.
        return dummyNode.next;
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