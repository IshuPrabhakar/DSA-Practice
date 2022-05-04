package Java;

/**
 * MultiplyStrings
 * Description =>
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * 49 - 48 = 1;
 * 48 - 48 = 0;
 * x 56 ,carry = 3
 * x 45
 * -----
 * +280
 * 224x
 * -----
 * 2520
 */

public class MultiplyStrings {

    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 4, 5 };
        int reteval = 0;
        for (int i : nums) {
            reteval *= 10;
            reteval += i;
        }
        System.out.println(reteval);
    }

    public String multiply(String num1, String num2) {
        String product = "";
        char num1_charArr[] = num1.toCharArray(); // 45
        char num2_charArr[] = num2.toCharArray(); // 65
        int length_of_digits = Integer.max(num1_charArr.length, num2_charArr.length);
        int a = 0, b = 0, carry = 0;
        int sum[] = new int[length_of_digits];

        // HAVE TO REVERSE final_product IN ORDER TO GET ORIGINAL
        // NUMBER BACK
        //
        int i = 0;
        for (char c1 : num1_charArr) {
            int final_product = 0;
            for (char c2 : num1_charArr) {
                int temp_product = (c1 - 48) * (c2 - 48) + carry;
                carry = temp_product / 10;
                int last_digit = temp_product % 10;

                final_product = (last_digit != 0) ? final_product * 10 + last_digit : final_product;
                if (carry > 0) {
                    final_product = final_product * 10 + carry;
                }
            }
        }

        return product;
    }
}