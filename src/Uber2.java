import java.util.*;
import java.util.stream.Collectors;

public class Uber2 {

    boolean isCryptSolution(String[] crypt, char[][] solution) {

        HashMap<String,String> encoderSetHashMap = new HashMap();

        for (char[] chars : solution) {
            encoderSetHashMap.put(((Character) chars[0]).toString(), ((Character) chars[1]).toString());
        }

        LinkedList<Integer> x =  updateToNumber(crypt[0],encoderSetHashMap);
        LinkedList<Integer> y =  updateToNumber(crypt[1],encoderSetHashMap);
        LinkedList<Integer> z =  updateToNumber(crypt[2],encoderSetHashMap);


        if((x.get(0) ==0 && x.size() >1) || (y.get(0) ==0 && y.size() > 1)){
            System.out.println(x.get(0));
            System.out.println(y.get(0));
            return false;
        }

        int iteratorSize = x.size();

        if(x.size() < y.size()){
            iteratorSize = y.size();
            for (int i = y.size() - x.size(); i >0;i--){
                x.push(0);
            }

        }else{
            for (int i = x.size() - y.size(); i >0;i--){
                y.push(0);
            }
        }

        x
                .stream()
                .forEach(it-> System.out.print(it));
        System.out.println("------------------2");
        y
                .stream()
                .forEach(it-> System.out.print(it));

        System.out.println("------------------3");



        List<Integer> answer = new ArrayList<>();
        int reminder =0;
        for(int i= iteratorSize -1 ; i >=0 ;i--){
            int result =  x.get(i) + y.get(i) + reminder;


            reminder = result /10;
            result = result%10;


            answer.add(result);
            if(i==0 && reminder >0){
                answer.add(reminder);
            }


        }

        answer
                .stream()
                .forEach(it-> System.out.print(it));

        System.out.println("------------------4");
        LinkedList<Integer> stack  = new LinkedList<>();
        answer.forEach(stack::push);

        stack
                .stream()
                .forEach(it-> System.out.print(it));

        System.out.println("------------------5");

        return isEqual(stack,z);




    }


    private boolean isEqual(List<Integer> sum, List<Integer> z){

        sum
                .stream()
                .forEach(it-> System.out.print(it));
        System.out.println("------------------");
        z
                .stream()
                .forEach(it-> System.out.print(it));

        if(sum.size() != z.size()){
            System.out.println("Failed here");
            return false;
        }
        for(int i=0; i< z.size();i++){
            System.out.println("sum->" + sum.get(i));
            System.out.println("z->" + z.get(i));
            if(!sum.get(i).equals(z.get(i))){
                System.out.println("Failed here2");
                return false;
            }
        }
        return true;
    }

    private LinkedList<Integer> updateToNumber(String word, HashMap<String,String> encoderHashMap){
        LinkedList<Integer> integerList = new LinkedList<>();
        StringBuilder word0Builder  = new StringBuilder();
        word.chars()
                .mapToObj(x -> (char)x)
                .forEach(it -> integerList.add(Integer.parseInt(encoderHashMap.get(it.toString()))));

        return integerList;
    }



}
