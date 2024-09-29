public class PalindromeService {
    static boolean isPalindrome(String input) {
        int l = input.length();
        for (int i = 0; i < l / 2; i++) {
            if (input.charAt(i) != input.charAt(l - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
