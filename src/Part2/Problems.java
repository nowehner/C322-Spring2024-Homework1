package Part2;
import java.util.*;

public class Problems {

        public static int[] problem1(int[] nums, int target) {
            HashMap<Integer, Integer> numIndices = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (numIndices.containsKey(complement)) {
                    return new int[]{numIndices.get(complement), i};
                }
                numIndices.put(nums[i], i);
            }


            return null;
        }

    public static boolean problem2(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

    public static String problem3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }


        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {

                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static int problem4(String s) {
        if (s == null || s.length() == 0) {
            return 0; // If the input is empty, return 0
        }

        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = romanValues.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {

            if (romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i + 1))) {
                result -= romanValues.get(s.charAt(i));
            } else {
                result += romanValues.get(s.charAt(i));
            }
        }

        return result;
    }

    public static boolean problem5(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char openBracket = stack.pop();
                if ((bracket == ')' && openBracket != '(') ||
                        (bracket == '}' && openBracket != '{') ||
                        (bracket == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode problem6(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If one of the lists is not fully processed, append the remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static int problem7 (int[] digits) {
        int result = 0;

        for (int digit : digits) {
            result = result * 10 + digit;
        }

        return result;
    }



}
