import java.util.*;

import com.sun.javafx.application.ParametersImpl;
import javafx.util.Pair;

public class LadderLength {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {


            // src -> hot
            // dest -> cog
            //list = [dog,hit, log,lot,cog]

            HashMap<String, ArrayList<String>> charDict = new HashMap<String, ArrayList<String>>();

            wordList.forEach(
                    word -> {
                        for (int i = 0; i < beginWord.length() - 1; i++) {
                            String newKey = word.substring(0, i) + "*" + word.substring(i + 1);
                            ArrayList charList = charDict.getOrDefault(newKey, new ArrayList<String>());
                            charList.add(word);
                            charDict.put(newKey, charList);
                        }
                    }
            );


            //once the dict is up now get ready to build the bfs graph - bfs graphs come with a queue to keep
            // track of the current node . Also define a visited Hashmap to keep track of the visited ndoes.

            Queue<Pair<String, Integer>> Q = new LinkedList<>();
            HashMap<String, Boolean> visitedBool = new HashMap<>();
            int level = 0;
            Q.add(new Pair<>(beginWord, level + 1));
            visitedBool.put(beginWord, true);

            while (!Q.isEmpty()) {
                Pair<String, Integer> qP = Q.remove();
                String currentWord = qP.getKey();
                for (int i = 0; i < currentWord.length() - 1; i++) {
                    String key = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);
                    for (String word : charDict.getOrDefault(key, new ArrayList<>())) {

                        if (word.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visitedBool.get(word)) {
                            visitedBool.put(word,true);
                            Q.add(new Pair<>(word, level++));

                        }
                    }
                }
            }

        return level;
        }

    }
}