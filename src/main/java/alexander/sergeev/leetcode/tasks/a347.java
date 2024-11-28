package alexander.sergeev.leetcode.tasks;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// 347. Top K Frequent Elements
public class a347 {

    /*
    Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.
     */

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    // BEATS 92%
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] arr = new int[k];
        int pos = 0;
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            arr[pos++] = entry.getKey();
        }
        return arr;
    }

    // BEATS 21%
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Queue<Map.Entry<Integer, Long>> minHeap = new PriorityQueue<>(Comparator.comparingLong(Map.Entry::getValue));
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    // BEATS 38%
    public static int[] topKFrequent1(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> 1, (o, n) -> o + 1))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}