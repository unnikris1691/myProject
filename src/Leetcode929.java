import java.util.*;

public class Leetcode929 {


    static class Solution {

        public static int numUniqueEmails(String[] emails) {
            HashSet<String> emailSet = new HashSet<>();
            for(String email:emails){
                emailSet.add(postProcessEmailString(email));
            }
            return emailSet.size();
        }

        private static String postProcessEmailString(String email){
            String[] args = email.split("@");
            String emailName = args[0];
            String domain = args[1];


            emailName =emailName.replaceAll("\\+[\\w\\W]*","");
            emailName = emailName.replaceAll("\\.","");
            return emailName+"@"+domain;

        }

    }
}
