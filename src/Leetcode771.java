import java.util.HashSet;

public class Leetcode771 {


    static class Solution {
        public int numJewelsInStones(String J, String S) {
            //"aA" - J //

            // create a set of Jewels
            HashSet<Character> jewelSet = new HashSet<>();

            // O(length(J))
            for(int i=0 ; i< J.length();i++){
                jewelSet.add(J.charAt(i));

            }

            int jCount = 0;
            for(int i=0; i<S.length();i++){
                if(jewelSet.contains(S.charAt(i))) jCount++;
            }
            return jCount;

        }
    }
}
