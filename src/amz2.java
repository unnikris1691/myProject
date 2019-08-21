import java.util.*;

public class amz2 {

    public static void main (String[] args){
        int[] array = new int[]{1,2};
        System.out.println(Leetcode121.Solution.maxProfit(array));
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
             int i=0,j,ans=0;
             HashMap<Character,Integer> hashMap = new HashMap<>();

             for(j=0; j< s.length();j++){
                 if(hashMap.containsKey(s.charAt(j))){
                     i = hashMap.get(s.charAt(j));
                 }
                 ans = Math.max(ans, j-i +1);
                 hashMap.put(s.charAt(j),j+1);
             }
            return ans;
        }
    }
}
