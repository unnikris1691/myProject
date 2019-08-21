import java.util.HashSet;

public class Leetcode575 {

    class Solution {
        public int distributeCandies(int[] candies) {
            HashSet<Integer> candySet = new HashSet<>();
            for(int candy : candies){
                    candySet.add(candy);
            }

            int numOfCandies = candies.length/2;
            int distinctCandies = candySet.size();

            int diff = Math.abs(distinctCandies - numOfCandies);
            if(numOfCandies >= distinctCandies) return distinctCandies;
            return distinctCandies - diff;

        }
    }
}
