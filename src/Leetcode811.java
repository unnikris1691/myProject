import java.util.*;

public class Leetcode811 {


    static class Solution {
        public static List<String> subdomainVisits(String[] cpdomains) {
            HashMap<String, Integer> subDomainVisitMap = new HashMap<>();

            for (String s : cpdomains) {
                // parse the count out
                int num = Integer.parseInt(s.split(" ")[0]);

                String domains = s.split(" ")[1];

                while (!domains.equals("")) {
                    String word2remove = domains.split("\\.")[0];
                    String prefix=".";
                    if(domains.equals(word2remove)){
                        prefix ="";
                    }
                    word2remove+=prefix;
                    subDomainVisitMap.put(domains, subDomainVisitMap.getOrDefault(domains,0)+num);
                    domains = domains.replace(word2remove, "");
                }
            }
            return reconstructMap(subDomainVisitMap);

        }

        private static List<String> reconstructMap(HashMap<String, Integer> map) {
            List<String> returnString = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                returnString.add(entry.getValue().toString() + " " + entry.getKey());
            }
            return returnString;
        }
    }
}
