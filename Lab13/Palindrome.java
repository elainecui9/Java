import java.util.LinkedList;
import java.util.Queue;
public class Palindrome {
    public static void main(String[] args) {
        String[] words = new String[] {"racecar", "banana", "tacocat",
                "java", "dad", "mom", "reckless", "alskhfuailhf", "level", "radar"};
        for(String s : words)
        {
            System.out.println(isPalindrome(s));
            //Expected output is true, false, true, false, true, true,
            false, false, true, true
        }
    }
    public static boolean isPalindrome(String str) {
        int mid = str.length() / 2;
        for (int x = 0; x <= mid; x++) {
            enqueue(str.charAt(x));
        }
        for (int y = str.length() - 1; y > mid; y - -) {
            char last = dequeue();
            if (str.charAt(y) != last) {
                return false;
            }
        }
        return true;
    }
}

