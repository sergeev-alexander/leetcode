package alexander.sergeev.leetcode.tasks;

import java.util.Stack;

// 32. Longest Valid Parentheses
public class a32 {

    /*
    Given a string containing just the characters '(' and ')',
    return the length of the longest valid (well-formed) parentheses substring.
     */

    public static void main(String[] args) {

        String str = "()(()";

        System.out.println(longestValidParentheses(str));

    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    length = Math.max(length, i - stack.peek());
                }
            }
        }
        return length;
    }

}
