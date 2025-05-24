package strings;

/**
 * Question: Zigzag Conversion
 *
 * Given a string `s` and an integer `numRows`, write a function that arranges the characters
 * of the string in a zigzag pattern across the given number of rows and then reads line by line.
 *
 * Example:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Zigzag pattern:
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */

public class ZigzagConversion {

    /**
     * Converts the input string into a zigzag pattern and reads it line-by-line.
     *
     * @param s       The input string
     * @param numRows Number of rows in the zigzag pattern
     * @return        The zigzag converted string read row by row
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int flag = 1; // 1 = down, -1 = up
        int rowCount = 0;

        for (char ch : s.toCharArray()) {
            rows[rowCount].append(ch);
            rowCount += flag;

            if (rowCount == 0 || rowCount == numRows - 1) {
                flag = -flag; // Reverse direction
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();

        // ✅ Standard case
        System.out.println("Test 1: " + solution.convert("PAYPALISHIRING", 3));
        // Expected: "PAHNAPLSIIGYIR"

        // ✅ Standard case with 4 rows
        System.out.println("Test 2: " + solution.convert("PAYPALISHIRING", 4));
        // Expected: "PINALSIGYAHRPI"

        // ✅ Edge case: Single row
        System.out.println("Test 3: " + solution.convert("HELLO", 1));
        // Expected: "HELLO"

        // ✅ Edge case: numRows >= s.length()
        System.out.println("Test 4: " + solution.convert("SHORT", 10));
        // Expected: "SHORT"

        // ✅ Edge case: Empty string
        System.out.println("Test 5: " + solution.convert("", 3));
        // Expected: ""

        // ✅ Edge case: numRows = 0 (should ideally be handled)
        System.out.println("Test 6: " + solution.convert("TEST", 0));
        // Expected: "TEST" (fallback behavior since numRows >= s.length())
    }
}
