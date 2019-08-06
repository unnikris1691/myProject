import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode8 {

    public static void main(String[] args) {

        int[] a = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(a));
    }


    public static int lastStoneWeightII(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();

        for (int stone : stones) {
            stoneList.add(stone);
        }
        List<Integer> sortedList = stoneList.stream().sorted().collect(Collectors.toList());

        return domagic(sortedList);


    }

    private static int domagic(List<Integer> sortedList) {

         if(sortedList.size() == 1){
             return  sortedList.get(0);
         }

         if(sortedList.isEmpty()){
             return 0;
         }

        int midIndex = (int)(Math.ceil((double) (sortedList.size() / 2)));
        int leftIndex = midIndex -1;
        int rightIndex = midIndex +1;

        if(sortedList.get(midIndex) - sortedList.get(leftIndex) <= sortedList.get(rightIndex) - sortedList.get(midIndex) ){

        }

        if (sortedList.size() > 0) {
            return sortedList.get(0);
        }
        return 0;

    }


}
