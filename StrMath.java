import java.util.Map;

public class StrMath {
    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "1";
        String sum = strAdd(num1, num2);
        System.out.println("Sum: " + sum);
    }

    /**
     * adds two numeric strings and returns their sum as string
     * non numeric characters are treated as zero
     * @param num1 the first numeric string
     * @param num2 the second numeric string
     * @return the sum of num1 and num2 as a string
     */
    public static String strAdd(String num1, String num2) {
        StringBuilder result = new StringBuilder(); // builds the result string
        String carry = "0"; // carry for addition
        int maxLength = Math.max(num1.length(), num2.length()); // finds longest number

        // replaces non numeric characters with zero
        num1 = num1.replaceAll("[^0-9]", "0");
        num2 = num2.replaceAll("[^0-9]", "0");

        // makes both numbers = length
        num1 = String.format("%" + maxLength + "s", num1).replace(' ', '0');
        num2 = String.format("%" + maxLength + "s", num2).replace(' ', '0');

        // adds digits from right to left
        for (int i = maxLength - 1; i >= 0; i--) {
            int digit1 = charToInt(num1.charAt(i)); // converts char to int
            int digit2 = charToInt(num2.charAt(i)); // converts char to int

            String sum = sumTable.get(digit1 + "," + digit2); // gets sum from lookup table
            String newNum = String.valueOf(sum.charAt(sum.length() - 1)); // last digit of sum

            // carry handler
            if (carry.equals("1")) { 
                String withCarry = sumTable.get(charToInt(newNum.charAt(0)) + ",1"); // adds carry to the sum
                newNum = String.valueOf(withCarry.charAt(withCarry.length() - 1)); // last digit + carry

                // handles carry for next iteration
                carry = withCarry.length() > 1 ? "1" : "0";
            } else {
                carry = sum.length() > 1 ? "1" : "0";
            }

            result.append(newNum);
        }

        // adds final carry if exists
        if (charToInt(carry.charAt(0)) > 0) { result.append(carry); }
        

        return result.reverse().toString();
    }


    /**
     * a lookup table for the sum of two single digit numbers
     */
    private static final Map<String, String> sumTable = initSumTable();

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
     * converts a character to an integer without using built in functions
     * @param c the character to convert
     * @return the integer value of the character, or 0 if it's not a numeric character
     */
    private static int charToInt(char c) {
        if (c == '0') return 0;
        if (c == '1') return 1;
        if (c == '2') return 2;
        if (c == '3') return 3;
        if (c == '4') return 4;
        if (c == '5') return 5;
        if (c == '6') return 6;
        if (c == '7') return 7;
        if (c == '8') return 8;
        if (c == '9') return 9;
        return 0; // default for non numeric characters
    }
}