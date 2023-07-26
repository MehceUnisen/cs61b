package Project1B;

public class Palindrome {
    private static Deque<Character> wordToDeque(String word) {
        int len = word.length();
        double x = Math.floor((double) (len) / 2);

        Deque<Character> deq = new ArrayDeque();
        for (int i = 0; i < x; i++) {
            deq.addFirst(word.charAt((int) x - i - 1));
            deq.addLast(word.charAt(len - (int) x + i));
        }
        return deq;
    }

    public static boolean isPalindrome(String word) {
        Deque<Character> deqWord = wordToDeque(word);

        while (deqWord.size() > 0) {
            if (!deqWord.removeFirst().equals(deqWord.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
