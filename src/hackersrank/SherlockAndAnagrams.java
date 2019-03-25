package hackersrank;


import java.util.ArrayList;
import java.util.List;


public class SherlockAndAnagrams {
    public static void main(String[] args) {
        String s = "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel";
        List<String> subStrings = new ArrayList<>();
        int sol = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String str = s.substring(i,j+1);
                subStrings.add(str);

            }
        }
        for(int i=0;i<subStrings.size();i++){
            for(int j=i+1;j<subStrings.size();j++) {
                if(checkAnagram(subStrings.get(i),subStrings.get(j))){
                    sol++;
                }
            }
        }

        System.out.println(sol);


    }

    private static boolean checkAnagram(String s1,String s2){
        boolean isAnagram = true;
        if(s1.length()!=s2.length()) return false;
        int[] count = new int[1000];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for(int i=0;i<1000;i++){
            if(count[i]!=0)return false;
        }
        return isAnagram;
    }
}



