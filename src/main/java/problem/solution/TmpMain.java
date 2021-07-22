package problem.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangpeng
 * @since 2020-12-16
 */
public class TmpMain {

    public boolean wordPattern(String pattern, String s) {
        char[] letters = pattern.toCharArray();
        String[] words = s.split(" ");
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        if (words.length != letters.length) {
            return false;
        }
        for (int i = 0; i < letters.length; i++) {
            String word = charMap.get(letters[i]);
            Character ch = wordMap.get(words[i]);
            if (word == null && ch == null) {
                charMap.put(letters[i], words[i]);
                wordMap.put(words[i], letters[i]);
                continue;
            } else if (word == null || ch == null) {
                return false;
            } else if (!word.equals(words[i]) || !ch.equals(letters[i])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
