import java.util.*;
import java.util.stream.Collectors;

public class amz1 {

    public static void main(String[] args){
        int[] nums = {3,2,4};
        twoSum(nums,6);
    }
    private static int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        Map<Integer ,Integer> integerMap = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            int nUC = nums[i];


            nums[i] = Integer.MIN_VALUE;

            if(integerMap.containsKey(target - nUC)){
                    return new int[] { i , integerMap.get(target-nUC)};
            }
            integerMap.put(nUC,i);
        }

        return returnArray;


    }
}
