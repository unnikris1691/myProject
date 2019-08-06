public class leetcode28 {


    static class Solution {
        public static int strStr(String haystack, String needle) {

            int windowSize = needle.length();

            if(!haystack.contains(needle)){
                return -1;
            }
            if(haystack.length() == 0){
                return 0;
            }
            for(int i= 0; i<haystack.length(); i ++){

                String substring = haystack.substring(i,i+windowSize);
                if(needle.equals(substring)){
                    return i;
                }

            }
            return -1;

        }
    }

}
