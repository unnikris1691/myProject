import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class EPI16_1 {

    public static void main (String[] args){
        System.out.println(numCombinationsForFinalScore(12, new ArrayList<Integer>(List.of(2,3,7))));
    }

    public static int numCombinationsForFinalScore(int finalScore,
                                                   List<Integer> individualPlayerScores) {

        int[][] combinationsForScore = new int[individualPlayerScores.size()][finalScore + 1];


        for (int i = 0; i < individualPlayerScores.size(); i++) {
            combinationsForScore[i][0] = 1; //no possible combinations

            for (int j = 1; j <= finalScore; j++) {

                int withoutPlay = (i - 1 >= 0) ? combinationsForScore[i - 1][j] : 0;

                int withPlay = (j >= individualPlayerScores.get(i)) ? combinationsForScore[i][j - individualPlayerScores.get(i)] : 0;

                combinationsForScore[i][j] = withoutPlay+withPlay;
            }

        }
        return  combinationsForScore[individualPlayerScores.size() -1][finalScore];

    }


}