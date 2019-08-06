import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Leetcode1002 {
    public  static List<String> commonChars(String[] A) {

        //this should be our base String
        Arrays.sort(A, Comparator.comparingInt(String::length));
        String minString =A[0];
        List<String> stringList = new ArrayList<>();
        for(int i=0;i<minString.length();i++){
            stringList.add(Character.toString(minString.charAt(i)));

        }

        List<String> popString;
        for(int j =1 ; j<A.length;j++){
            popString = new ArrayList<>();
            for(int i=0; i < stringList.size();i++){
                if(A[j].contains(stringList.get(i))){
                    A[j] = A[j].replaceFirst(stringList.get(i),"-");
                    popString.add(stringList.get(i));
                    stringList.remove(stringList.get(i));

                    stringList.add(i,"");
                }

            }
            stringList = popString;
        }

        return stringList;
    }



}