package alexander.sergeev.leetcode.tasks;

import java.util.ArrayDeque;
import java.util.Deque;

// 20. Valid Parentheses
public class a20 {

    /*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
     */

    public static void main(String[] args) {

        System.out.println(isValid("{[()]}"));

    }

    public static boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (ch == '(')
                deque.push(')');
            else if (ch == '{')
                deque.push('}');
            else if (ch == '[')
                deque.push(']');
            else if (deque.isEmpty() || ch != deque.pop())
                return false;
        }
        return deque.isEmpty();
    }

}
