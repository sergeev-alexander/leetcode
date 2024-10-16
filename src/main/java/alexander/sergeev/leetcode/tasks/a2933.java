package alexander.sergeev.leetcode.tasks;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

// 2933. High-Access Employees
public class a2933 {

    /*
    You are given a 2D 0-indexed array of strings, access_times, with size n.
    For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee,
    and access_times[i][1] represents the access time of that employee. All entries in access_times are within the same day.
    The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".
    An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.
    Times with exactly one hour of difference are not considered part of the same one-hour period.
    For example, "0815" and "0915" are not part of the same one-hour period.
    Access times at the start and end of the day are not counted within the same one-hour period.
    For example, "0005" and "2350" are not part of the same one-hour period.
    Return a list that contains the names of high-access employees with any order you want.
     */

    public static void main(String[] args) {

        List<List<String>> list = List.of(
                List.of("d", "0002")
                , List.of("c", "0808")
                , List.of("c", "0829")
                , List.of("e", "0215")
                , List.of("d", "1508")
                , List.of("d", "1444")
                , List.of("d", "1410")
                , List.of("c", "0809"));
        System.out.println(findHighAccessEmployees(list));
    }

    // BEATS 79%
    public static List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> list : access_times) {
            int num = Integer.parseInt(list.get(1));
            if (!map.containsKey(list.get(0))) {
                List<Integer> times = new ArrayList<>();
                times.add(num / 100 * 60 + num % 100);
                map.put(list.get(0), times);
            } else map.get(list.get(0)).add(num / 100 * 60 + num % 100);
        }

        Set<String> result = new HashSet<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 2) {
                Collections.sort(entry.getValue());
                for (int i = 2; i < entry.getValue().size(); i++) {
                    Integer end = entry.getValue().get(i - 2) + 60;
                    if (entry.getValue().get(i - 1) < end && entry.getValue().get(i) < end) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<String> findHighAccessEmployees_BEATS_10_PERCENT(List<List<String>> access_times) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> list : access_times) {
            int hours = Integer.parseInt(list.get(1).charAt(0) + "" + list.get(1).charAt(1));
            int minutes = Integer.parseInt(list.get(1).charAt(2) + "" + list.get(1).charAt(3));
            if (!map.containsKey(list.get(0))) {
                List<Integer> times = new ArrayList<>();
                times.add(hours * 60 + minutes);
                map.put(list.get(0), times);
            } else map.get(list.get(0)).add(hours * 60 + minutes);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        Set<String> result = new HashSet<>();

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 3) continue;
            for (int i = 2; i < list.size(); i++) {
                Integer end = list.get(i - 2) + 60;
                if (list.get(i - 1) < end && list.get(i) < end) {
                    result.add(entry.getKey());
                }
            }
        }
        return new ArrayList<>(result);

    }

    public static List<String> findHighAccessEmployees_BEATS_8_PESENT(List<List<String>> access_times) {
        return access_times.stream()
                .collect(Collectors.groupingBy(
                        list -> list.get(0),
                        Collectors.mapping(list -> {
                                    int hours = Integer.parseInt(list.get(1).charAt(0) + "" + list.get(1).charAt(1));
                                    int minutes = Integer.parseInt(list.get(1).charAt(2) + "" + list.get(1).charAt(3));
                                    return hours * 60 + minutes;
                                },
                                Collectors.toList())
                ))
                .entrySet().stream()
                .filter(e -> e.getValue().size() > 2)
                .filter(e -> {
                    List<Integer> list = e.getValue();
                    Collections.sort(list);
                    boolean res = false;
                    for (int i = 2; i < list.size(); i++) {
                        Integer end = list.get(i - 2) + 60;
                        if (list.get(i - 1) < end && list.get(i) < end) {
                            res = true;
                            break;
                        }
                    }
                    return res;
                })
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findHighAccessEmployees_BEATS_7_PERCENT(List<List<String>> access_times) {
        Map<String, List<LocalDateTime>> map = access_times.stream()
                .collect(Collectors.groupingBy(
                        list -> list.get(0),
                        mapping(list -> {
                            int hour = Integer.parseInt(list.get(1).charAt(0) + "" + list.get(1).charAt(1));
                            int minute = Integer.parseInt(list.get(1).charAt(2) + "" + list.get(1).charAt(3));
                            return LocalDateTime.of(2025, 1, 1, hour, minute);
                        }, Collectors.toList())
                ));

        for (Map.Entry<String, List<LocalDateTime>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        Set<String> result = new HashSet<>();

        for (Map.Entry<String, List<LocalDateTime>> entry : map.entrySet()) {
            List<LocalDateTime> list = entry.getValue();
            if (list.size() < 3) continue;
            for (int i = 2; i < list.size(); i++) {
                LocalDateTime end = list.get(i - 2).plusMinutes(60);
                if (list.get(i - 1).isBefore(end) && list.get(i).isBefore(end)) {
                    result.add(entry.getKey());
                }
            }
        }
        return new ArrayList<>(result);
    }
}
