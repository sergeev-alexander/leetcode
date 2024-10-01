package alexander.sergeev.leetcode.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class a23 {

    public static void main(String[] args) {

        ListNode head1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4, null)));
        ListNode head2 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4, null)));
        ListNode head3 =
                new ListNode(-1,
                        new ListNode(1,
                                new ListNode(5, null)));
        ListNode head4 =
                new ListNode(-4,
                        new ListNode(2,
                                new ListNode(6, null)));

        ListNode[] arr = {head1, head2, head3, head4};

        System.out.println(mergeKLists(arr));

    }

    // A bit faster, but beats only 18%
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            ListNode temp = lists[i];
            while (temp != null) {
                list.add(temp);
                temp = temp.next;
            }
        }
        if (list.isEmpty()) return null;
        list.sort(Comparator.comparing(l -> l.val));
        ListNode first = list.get(0);
        ListNode result = first;
        for (int i = 1; i < list.size(); i++) {
            if (i == list.size() - 1) {
                first.next = null;
            }
            first.next = list.get(i);
            first = first.next;
        }
        return result;
    }

    public static ListNode mergeKLists_SLOW(ListNode[] lists) {
        ListNode first;
        ListNode result;
        List<ListNode> list = Arrays.stream(lists)
                .flatMap(l -> {
                    List<ListNode> list1 = new ArrayList<>();
                    while (l != null) {
                        list1.add(l);
                        l = l.next;
                    }
                    return list1.stream();
                })
                .sorted(Comparator.comparingInt(l -> l.val))
                .toList();
        if (list.isEmpty()) return null;
        first = result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (i == list.size() - 1) {
                first.next = null;
            }
            first.next = list.get(i);
            first = first.next;
        }
        return result;
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
