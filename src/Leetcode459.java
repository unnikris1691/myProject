import java.util.HashSet;

public class Leetcode459 {


    static class Solution {
        public static boolean repeatedSubstringPattern(String s) {
            String s2 = s + s;
            return s2.substring(1,s2.length() -1).contains(s);

        }

    }
}
