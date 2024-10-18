package alexander.sergeev.leetcode.tasks;

import alexander.sergeev.Temp;

// 2816. Double a Number Represented as a Linked List
public class a2816 {

    /*
    You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
    Return the head of the linked list after doubling it.
     */

    public static void main(String[] args) {
        ListNode head =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9)));
        System.out.println(doubleIt(head)); // (1) => (9) => (9) => (8) => null
    }

    // BEATS 84%
    public static ListNode doubleIt(ListNode head) {
        boolean needReturnDummy = head.val * 2 > 9;
        ListNode dummy = new ListNode(1, head);
        while (head != null) {
            int rest = 0;
            if (head.next != null && head.next.val * 2 > 9) {
                rest = 1;
            }
            head.val = head.val * 2 % 10 + rest;
            head = head.next;
        }
        return needReturnDummy ? dummy : dummy.next;
    }

    public static ListNode doubleIt_BEATS_13_PERCENT(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        StringBuilder result = new StringBuilder();
        int rest = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int temp = Integer.parseInt(String.valueOf(sb.charAt(i))) * 2 + rest;
            if (temp < 10) {
                result.append(temp);
                rest = 0;
            } else {
                result.append(temp % 10);
                rest = 1;
            }
        }
        if (rest > 0) result.append(rest);
        ListNode dummy = new ListNode(0);
        ListNode first = new ListNode(Integer.parseInt(String.valueOf(result.charAt(result.length() - 1))));
        dummy.next = first;
        for (int i = result.length() - 2; i >= 0; i--) {
            first.next = new ListNode(Integer.parseInt(String.valueOf(result.charAt(i))));
            first = first.next;
        }
        return dummy.next;
    }

    public static ListNode doubleIt_BEATS_10_PERCENT(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        StringBuilder result = new StringBuilder();
        String[] arr = sb.reverse().toString().split("");
        int rest = 0;
        for (int i = 0; i < sb.length(); i++) {
            int temp = Integer.parseInt(arr[i]) * 2 + rest;
            if (temp < 10) {
                result.append(temp);
                rest = 0;
            } else {
                result.append(temp % 10);
                rest = 1;
            }
        }
        if (rest > 0) result.append(rest);
        String[] resultArr = result.reverse().toString().split("");
        ListNode dummy = new ListNode(0);
        ListNode first = new ListNode(Integer.parseInt(resultArr[0]));
        dummy.next = first;
        for (int i = 1; i < resultArr.length; i++) {
            first.next = new ListNode(Integer.parseInt(resultArr[i]));
            first = first.next;
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