public class Leetcode686 {


    static class Solution {
        public static int repeatedStringMatch(String A, String B) {
            int counter = 1;
            StringBuilder S = new StringBuilder(A);
            for(;S.length() < B.length(); counter++){
                S.append(A);
            }

            if(S.toString().contains(B)) return counter;
            if(S.append(A).toString().contains(B)) return counter +1;
            return  -1;

        }

    }
}
