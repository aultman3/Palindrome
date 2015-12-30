import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Determines if a given string is a palindrome.
 * 
 * @author Erik Aultman
 * 
 */
public final class Palindrome {

    /**
     * 
     */
    private Palindrome() {
    }

    /**
     * Determines if the inputed string is a palindrome and returns true if it
     * is and false if it is not a palindrome.
     * 
     * NOTE: Empty String returns true
     * 
     * @param palStr
     *            - string to be tested if it is a palindrome
     * @return - true if string(@palStr) is a palindrome and false otherwise
     */
    private static boolean isPalindrome(String palStr) {

        boolean result = true; //return value
        /*
         * if string is less than 2 characters return true otherwise check
         */
        if (palStr.length() > 1) {
            char first = palStr.charAt(0); //first character from string
            char last = palStr.charAt(palStr.length() - 1); //last character from string
            /*
             * if first character and last character are the same check rest of
             * string otherwise result is false
             */
            if (first == last) {
                isPalindrome(palStr.substring(1, palStr.length() - 2));
            } else {
                result = false;
            }
        }

        return result;
    }

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        //input stream for user defined ranges
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String palStr = ""; //user input string for palindrome check
        System.out.println("Enter the string to be checked.");
        /**
         * read console line in
         */

        try {
            palStr = in.readLine();
        } catch (IOException e) {
            System.err.println("Error reading input.");
            e.printStackTrace();
        }

        /**
         * check if input string is a palindrome
         */
        boolean isPal = false;
        try {
            isPal = isPalindrome(palStr.toLowerCase().replace(" ", ""));
        } catch (NullPointerException n) {
            System.err.println("Error: Null Pointer Exception.");
            n.printStackTrace();
        }
        if (isPal) {
            System.out.println(palStr + " is a palindrome!");
        } else {
            System.out.println(palStr + " is not a palindrome.");
        }
        try {
            in.close();
        } catch (IOException e) {
            System.err.println("Error closing input stream");
            e.printStackTrace();
        }
    }

}
