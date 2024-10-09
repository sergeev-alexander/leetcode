package alexander.sergeev.leetcode.tasks;

import java.util.List;

// 1773. Count Items Matching a Rule
public class a1773 {

    /*
    You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color,
    and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
    The ith item is said to match the rule if one of the following is true:
    ruleKey == "type" and ruleValue == type'i.
    ruleKey == "color" and ruleValue == color'i.
    ruleKey == "name" and ruleValue == name'i.
    Return the number of items that match the given rule.
     */

    public static void main(String[] args) {

        List<List<String>> list = List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "phone"),
                List.of("phone", "gold", "iphone"));
        String rule = "type";
        String val = "phone";
        System.out.println(countMatches(list, rule, val));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int pos = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> 4;
        };
        return items.stream()
                .mapToInt(list -> {
                    if (list.get(pos).equals(ruleValue)) return 1;
                    else return 0;
                })
                .sum();
    }

    public static int countMatches_1(List<List<String>> items, String ruleKey, String ruleValue) {
        int pos = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> 4;
        };
        int sum = 0;
        for (List<String> list : items) {
            if (list.get(pos).equals(ruleValue)) {
                sum += 1;
            }
        }
        return sum;
    }
}