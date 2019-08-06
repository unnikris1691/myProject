import java.util.HashMap;

public class Leetcode238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
           int[] ans = new int[nums.length];

           //get the left pointer set up
            ans[0] = 1;

            for(int i=0; i<ans.length;i++){
                ans[i] = nums[i-1] * ans[i-1];
                //1126
            }

            //now set up the Right pointer

            int r =1;
            for(int i = ans.length -1 ; i >=0 ;i --){
                ans[i] = ans[i] * r;
                r *= nums[i];
            }

            return ans;
        }
    }
}
