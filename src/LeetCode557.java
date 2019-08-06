import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class LeetCode557 {
    class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder finalString = new StringBuilder();
            for(String w: words){
                StringBuilder builder = new StringBuilder(w).reverse();
                builder.append(" ");
                finalString.append(builder);
            }
            return  finalString.toString().trim();
        }
    }


}