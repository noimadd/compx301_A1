public class StrMath {
    public static void main(String[] args) {
        String num1 = "515";
        String num2 = "12h3";
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
        int carry = 0; // carry for addition
        int maxLength = Math.max(num1.length(), num2.length()); // finds longest number

        // replaces non numeric characters with zero
        num1 = num1.replaceAll("[^0-9]", "0");
        num2 = num2.replaceAll("[^0-9]", "0");

        // makes both numbers = length
        num1 = String.format("%" + maxLength + "s", num1).replace(' ', '0');
        num2 = String.format("%" + maxLength + "s", num2).replace(' ', '0');

        System.out.println("Padded num1: " + num1);
        System.out.println("Padded num2: " + num2);

        
        

        return result.reverse().toString();
    }


    /**
     * a lookup table for the sum of two single digit numbers
     */
    private static final String[][] sumTable = {
        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
        {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
        {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11"},
        {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12"},
        {"4", "5", "6", "7", "8", "9", "10", "11", "12", "13"},
        {"5", "6", "7", "8", "9", "10", "11", "12", "13", "14"},
        {"6", "7", "8", "9", "10", "11", "12", "13", "14", "15"},
        {"7", "8", "9", "10", "11", "12", "13", "14", "15", "16"},
        {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17"},
        {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18"}
    };


    /**
     * converts a character to an integer without using built in functions
     * @param c the character to convert
     * @return the integer value of the character, or 0 if it's not a numeric character
     */
    private static final int charToInt(char c) {
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