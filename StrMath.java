import java.util.Map;

public class StrMath {
    private static final Map<String, String> sumTable = initSumTable(); // init lookup table for single digit sums
    private static final Map<String, String> multTable = initMultTable(); // init lookup table for single digit products

    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "1111";
        String sum = StrAdd(num1, num2);
        System.out.println("Sum of " + num1 + " + " + num2 + ": " + sum);

        num1 = "9999";
        num2 = "1111";
        String mult = StrMult(num1, num2);
        System.out.println("Product of " + num1 + " * " + num2 + ": " + mult);


        String num = "5";
        String fact = StrFact(num);
        System.out.println("Factorial of " + num + ": " + fact);
    }

    /**
     * adds two numeric strings and returns their sum as string
     * iterates through each digit of both strings
     * makes use of sumTable to get the sum of two digits 
     * carries are handled by checking the length of the sum and adding the first digit to the next sum if necessary
     * @param num1 the first numeric string
     * @param num2 the second numeric string
     * @return the sum of num1 and num2 as a string
     */
    public static String StrAdd(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        String carry = "0";
        int maxLength = Math.max(num1.length(), num2.length());

        num1 = stringToInt(num1);
        num2 = stringToInt(num2);

        // makes both numbers = length
        num1 = String.format("%" + maxLength + "s", num1).replace(' ', '0');
        num2 = String.format("%" + maxLength + "s", num2).replace(' ', '0');

        // adds digits from right to left
        for (int i = maxLength - 1; i >= 0; i--) {
            int digit1 = charToInt(num1.charAt(i));
            int digit2 = charToInt(num2.charAt(i));

            String sum = sumTable.get(digit1 + "," + digit2);
            String newNum = String.valueOf(sum.charAt(sum.length() - 1));

            // carry handler
            if (carry.equals("1")) { 
                String withCarry = sumTable.get(charToInt(newNum.charAt(0)) + ",1"); // adds carry to the sum
                newNum = String.valueOf(withCarry.charAt(withCarry.length() - 1)); // last digit + carry

                // handles carry for next iteration
                carry = (sum.length() > 1 || withCarry.length() > 1) ? "1" : "0";
            } else {
                carry = sum.length() > 1 ? "1" : "0";
            }

            result.append(newNum);
        }

        // adds final carry if exists
        if (carry.equals("1")) result.append(carry);
        

        return result.reverse().toString();
    }


    /**
     * multiplies two numeric strings and returns their product as string
     * iterates through each digit of num1 and multiplies it with each digit of num2
     * multTable is used to acquire the product of single digits, and StrAdd is used to handle sums and carries
     * @param num1 the first numeric string
     * @param num2 the second numeric string
     * @return the product of num1 and num2 as a string
     */
    public static String StrMult(String num1, String num2) {
        String result = "0";
        String carry = "0";
        
        num1 = stringToInt(num1);
        num2 = stringToInt(num2);

        // multiplies both numbers from right to left
        for (int i = num1.length() - 1; i >= 0; i--) {
            int digit1 = charToInt(num1.charAt(i));
            StringBuilder temp = new StringBuilder();

            // multiplies digit1 with each digit of num2
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit2 = charToInt(num2.charAt(j));

                String product = multTable.get(digit1 + "," + digit2);
                String withCarry = StrAdd(product, carry);
                
                // adds last digit of product to temp and updates carry
                temp.append(withCarry.charAt(withCarry.length() - 1));
                carry = (withCarry.length() > 1) ? String.valueOf(withCarry.charAt(0)) : "0";
            }

            // adds carry if exists
            if (!carry.equals("0")) temp.append(carry);

            // pads temp with zeros based on position on num1
            temp = temp.reverse();
            int shift = num1.length() - 1 - i;
            for (int k = 0; k < shift; k++) { temp.append("0"); }

            // updates the current result by adding new product
            result = StrAdd(result, temp.toString());
        }

        return result;
    }

    public static String StrFact(String num) {
        String result = "1";
        int n = 1;
        boolean iterate = true;

        while (iterate) {
            String temp = String.valueOf(n);

            // checks if n has exceeded num
            if (temp.equals(StrAdd(num, "1"))) {
                iterate = false;
                break;
            }

            result = StrMult(result, temp);
            n = Integer.parseInt(StrAdd(String.valueOf(n), "1"));
        }


        return result;
    }

    /**
     * init the lookup table for sums of single digits
     * @return the lookup table
     */
    private static Map<String, String> initSumTable() {
        Map<String, String> table = new java.util.HashMap<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int sum = i + j;
                table.put(i + "," + j, String.valueOf(sum));
            }
        }
        return table;
    }

    /**
     * init the lookup table for products of single digits
     * @return the lookup table
     */
    private static Map<String, String> initMultTable() {
        Map<String, String> table = new java.util.HashMap<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int product = i * j;
                table.put(i + "," + j, String.valueOf(product));
            }
        }
        return table;
    }

    /**
     * converts a character to an integer without using built in functions
     * @param c the character to convert
     * @return the integer value of the character, or 0 by default
     */
    private static int charToInt(char c) {
        if (c == '1') return 1;
        if (c == '2') return 2;
        if (c == '3') return 3;
        if (c == '4') return 4;
        if (c == '5') return 5;
        if (c == '6') return 6;
        if (c == '7') return 7;
        if (c == '8') return 8;
        if (c == '9') return 9;
        return 0;
    }

    /**
     * checks each character in a string is numeric
     * replaces all non numeric chars with a '0'
     */
    private static String stringToInt(String s) {
        return s.replaceAll("[^0-9]", "0");
    }
}