package maths;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Returns 0 if the reversed integer overflows.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int temp = Math.abs(x), rev = 0;
        while (temp > 0) {
            int digit = temp % 10;

            // Check for overflow before appending the digit
            if (rev > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }

            rev = rev * 10 + digit;
            temp = temp / 10;
        }

        return x < 0 ? -rev : rev;
    }

public static void main(String[] args) {
    ReverseInteger solution = new ReverseInteger();

    // ✅ Standard positive number
    System.out.println("Test 1: " + solution.reverse(123)); // Expected: 321

    // ✅ Standard negative number
    System.out.println("Test 2: " + solution.reverse(-456)); // Expected: -654

    // ✅ Edge case: Zero
    System.out.println("Test 3: " + solution.reverse(0)); // Expected: 0

    // ✅ Edge case: Single digit positive
    System.out.println("Test 4: " + solution.reverse(7)); // Expected: 7

    // ✅ Edge case: Single digit negative
    System.out.println("Test 5: " + solution.reverse(-8)); // Expected: -8

    // ✅ Edge case: Number ending with zeros
    System.out.println("Test 6: " + solution.reverse(1200)); // Expected: 21

    // ✅ Edge case: Negative number ending with zeros
    System.out.println("Test 7: " + solution.reverse(-9000)); // Expected: -9

    // ✅ Edge case: Overflow positive
    System.out.println("Test 8: " + solution.reverse(1534236469)); // Expected: 0

    // ✅ Edge case: Overflow negative
    System.out.println("Test 9: " + solution.reverse(-1563847412)); // Expected: 0

    // ✅ Edge case: Integer.MIN_VALUE
    System.out.println("Test 10: " + solution.reverse(Integer.MIN_VALUE)); // Expected: 0

    // ✅ Edge case: Integer.MAX_VALUE
    System.out.println("Test 11: " + solution.reverse(Integer.MAX_VALUE)); // Expected: 0
}
}