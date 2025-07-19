package Stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 */
public class MakeValidParenthesis {

    public String minMoveToMakeValid(String s)
    {
        Stack<int[]> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for(int i = 0; i<s.length(); i++)
        {
            char val = s.charAt(i);
            if(!stack.isEmpty() && stack.peek()[0] == '(' && val == ')')
            {
                stack.pop();
            }
            else if(val == '(' || val == ')'){
                stack.push(new int[]{val, i});
            }
        }

        while(!stack.isEmpty())
        {
            charArray[stack.pop()[1]] = ' ';
        }

        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            if (c != ' ') {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {

    }

}
