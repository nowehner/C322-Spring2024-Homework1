package Part2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;





public class ProblemsTest {

    @Test
    public void testProblem1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = Problems.problem1(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testProblem2() {
        assertTrue(Problems.problem2(121));
        assertFalse(Problems.problem2(-121));
        assertFalse(Problems.problem2(10));
    }

    @Test
    public void testProblem3() {
        String[] strs = {"flower", "flow", "flight"};
        assertEquals("fl", Problems.problem3(strs));
    }

    @Test
    public void testProblem4() {
        assertEquals(9, Problems.problem4("IX"));
        assertEquals(58, Problems.problem4("LVIII"));
    }

    @Test
    public void testProblem5() {
        assertTrue(Problems.problem5("{[()]}"));
        assertFalse(Problems.problem5("([)]"));
    }

    @Test
    public void testProblem6() {
        Problems.ListNode l1 = new Problems.ListNode(1);
        l1.next = new Problems.ListNode(3);
        l1.next.next = new Problems.ListNode(5);

        Problems.ListNode l2 = new Problems.ListNode(2);
        l2.next = new Problems.ListNode(4);
        l2.next.next = new Problems.ListNode(6);

        Problems.ListNode mergedList = Problems.problem6(l1, l2);

        // Add your assertions for the mergedList here
    }

    @Test
    public void testProblem7() {
        int[] digits = {1, 2, 3, 4, 5};
        assertEquals(12345, Problems.problem7(digits));
    }
}

