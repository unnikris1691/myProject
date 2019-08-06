import java.util.*;
import java.util.stream.Collectors;

public class Leetcode5 {

    public static  void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static  List<List<String>> groupAnagrams(String[] strs) {

        LinkedHashMap<Integer,List<String>> gramSet = new LinkedHashMap<>();
        for(String s : strs){
            char[] sortArray = s.toCharArray();
            Arrays.sort(sortArray);
            String a = new String(sortArray);
            if(!gramSet.containsKey(a.hashCode())){
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                gramSet.put(a.hashCode(),stringList);
            }else{
                List<String> stringList =  gramSet.get(a.hashCode());
                stringList.add(s);
            }
        }

        return new ArrayList<>(gramSet.values());

    }

}
