package alexander.sergeev.hh.tasks;

import java.util.*;
import java.util.stream.Collectors;

public class Journey {

    public static void main(String[] args) {

        List<Integer> islands = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        final int n = islands.size();

        List<List<Integer>> graph = new ArrayList<>();

        for (int j = 0; j < 2 * n - 1; ++j) {
            graph.add(new ArrayList<>());
        }

        System.out.println(graph);

        for (int j = 0; j < 2 * n - 2; ++j) {
            graph.get(j).add(j + 1);
            graph.get(j + 1).add(j);
        }

        System.out.println(graph);

        Map<Integer, Integer> continents = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int c = islands.get(i);
            if (!continents.containsKey(c)) {
                continents.put(c, graph.size());
                graph.add(new ArrayList<>());
            }
            graph.get(i * 2).add(continents.get(c));
            graph.get(continents.get(c)).add(i * 2);
        }

        System.out.println("Continents " + continents);

        System.out.println("Graph " + graph);

        int[] distance = new int[graph.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int j = queue.remove();
            if (j == 2 * n - 2) {
                break;
            }
            for (int k : graph.get(j)) {
                if (distance[k] == 0) {
                    distance[k] = distance[j] + 1;
                    queue.add(k);
                }
            }
        }

        System.out.println(distance[2 * n - 2] / 2);
    }
}
