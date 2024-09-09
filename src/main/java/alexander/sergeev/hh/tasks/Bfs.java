package alexander.sergeev.hh.tasks;

import java.util.*;


public class Bfs {

    public static void main(String[] args) {

        int[] arr = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) {
                list.add(arr[i]);
            } else {
                if (arr[i] != arr[i + 1]) {
                    list.add(arr[i]);
                }
            }
        }

        if (list.size() == 1) {
            System.out.println(0);
            return;
        }
        if (list.size() == 2) {
            System.out.println(1);
            return;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            Set<Integer> set = new HashSet<>();
            if (i == 0) {
                set.add(i + 1);
            } else if (i == list.size() - 1) {
                set.add(i - 1);
            } else {
                set.add(i - 1);
                set.add(i + 1);
            }
            for (int j = 0; j < list.size(); j++) {
                if (j != i && list.get(i).equals(list.get(j))) {
                    set.add(j);
                }
            }
            map.put(i, set);
        }

        Map<Integer, Integer> distances = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        distances.put(0, 0);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (current == list.size() - 1) break;
            for (Integer neighbor : map.get(current)) {
                Integer newDist = distances.get(current) + 1;
                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println(distances.get(list.size() - 1));

    }
}
