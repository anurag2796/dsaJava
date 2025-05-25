package strings;

class StringToAtoi {
    public int myAtoi(String s) {
        s= s.trim();
        int result = 0, sign = 1;
        for(int i = 0; i < s.length(); i++){
            if( i == 0 && s.charAt(i) == '-'){
                sign = -1;
                continue;
            }
            if( i == 0 && s.charAt(i) == '+'){
                continue;
            }


            int digit;
            try{
                digit = Integer.parseInt(String.valueOf(s.charAt(i)));
                // Check overflow condition
                //result*10 +digit > Integer.MAX_VALUE

                if(result > (Integer.MAX_VALUE - digit) / 10) {
                    return sign ==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                }
                result= result*10 + digit;
            }
            catch(Exception e){
                return result*sign;
            }
        }
        return result*sign;
    }
    public static void main(String[] args) {
        StringToAtoi solution = new StringToAtoi();

        // ✅ Standard positive number
        System.out.println("Test 1: " + solution.myAtoi("42")); // Expected: 42

        // ✅ Standard negative number
        System.out.println("Test 2: " + solution.myAtoi("-42")); // Expected: -42

        // ✅ Edge case: Leading whitespace
        System.out.println("Test 3: " + solution.myAtoi("   123")); // Expected: 123

        // ✅ Edge case: Trailing characters
        System.out.println("Test 4: " + solution.myAtoi("4193 with words")); // Expected: 4193

        // ✅ Edge case: Non-numeric at start
        System.out.println("Test 5: " + solution.myAtoi("words and 987")); // Expected: 0

        // ✅ Edge case: Only sign
        System.out.println("Test 6: " + solution.myAtoi("+")); // Expected: 0

        // ✅ Edge case: Empty string
        System.out.println("Test 7: " + solution.myAtoi("")); // Expected: 0

        // ✅ Edge case: Integer overflow
        System.out.println("Test 8: " + solution.myAtoi("91283472332")); // Expected: 2147483647

        // ✅ Edge case: Integer underflow
        System.out.println("Test 9: " + solution.myAtoi("-91283472332")); // Expected: -2147483648

        // ✅ Edge case: Plus sign
        System.out.println("Test 10: " + solution.myAtoi("+123")); // Expected: 123

        // ✅ Edge case: Multiple signs
        System.out.println("Test 11: " + solution.myAtoi("+-12")); // Expected: 0

        // ✅ Edge case: Number with leading zeros
        System.out.println("Test 12: " + solution.myAtoi("00000123")); // Expected: 123

        // ✅ Edge case: Only whitespace
        System.out.println("Test 13: " + solution.myAtoi("    ")); // Expected: 0

        // ✅ Edge case: Negative zero
        System.out.println("Test 14: " + solution.myAtoi("-0")); // Expected: 0
    }
}
