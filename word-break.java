/*Question:Given a string s and a dictionary of words dict, 
            determine if s can be segmented into a space-separated 
            sequence of one or more dictionary words.

*/
import java.util.*;
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();

        //记录字符串中的前n位能否被分词
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        for (int i = 1; i <= len; i++){
            for (int j = 0; j < i; j++){

                //如果j之前的字符串能分词且j到i的字符组成新的单词，那么记录i之前的字符串能分词
                if(arrays[j] && dict.contains(s.substring(j,i))){
                    arrays[i] = true;
                    break;
                }
            }
        }
        return arrays[len];
    }
}