package alexander.sergeev.diverse.tasks;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostCommonElement {

    public static void main(String[] args) {

        List<Integer> data = List.of(1, 2, 3, 4, 4, 3, 4, 6, 8, 10);
        int result = findMostFrequentElement(data);
        System.out.println(result);
    }

    public static int findMostFrequentElement(List<Integer> data) {
        return Collections.max(data, Comparator.comparingInt(n -> Collections.frequency(data, n)));
    }
}
