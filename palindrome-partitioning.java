/*
Question:

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

*/


import java.util.*;

public class Solution {


    private HashMap<String, ArrayList<String>> map;

    private boolean[][] isPalindrome;

    //获取一个字符串中哪里有回文
    private boolean[][] getIsPalindrome(String s) {
        int len_s = s.length();

        //如果isPalindrome[i][j] = true，就说明s的i到j处是回文
        boolean[][] isPalindrome = new boolean[len_s][len_s];

        //所有单字母都是回文
        for (int i = 0; i < len_s; i++){
            isPalindrome[i][i] = true;
        }

        //如果两个相同的字母相邻，这两个字母组成的字符串是回文
        for (int i = 0; i < len_s -1; i++){
            isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
        }

        //如果一个字符串头尾相同，且去头去尾后是回文，那么它也是回文
        for (int length = 2; length < len_s; length++){
            for (int start = 0; start+length < len_s; start++){
                isPalindrome[start][start+length] = (isPalindrome[start+1][start+length-1] && s.charAt(start) == s.charAt(start+length));
            }
        }

        return isPalindrome;
    }

    private ArrayList<ArrayList<String>> partitionHelper(String s, int start, int end) {

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();;

        if(start == end){
            ArrayList<String> t = new ArrayList<String>();
            t.add(s.substring(start, end+1));
            res.add(t);
            return res;
        }

        if(start > end){
            ArrayList<String> t = new ArrayList<String>();
            res.add(t);
            return res;
        }

        for (int i = end; i >= start; i--){
            if(isPalindrome[start][i]){
                ArrayList<ArrayList<String>> partitions = partitionHelper(s, i+1, end);
                for (ArrayList<String> a : partitions){
                    a.add(0, s.substring(start, i+1));
                    res.add(a);
                }
                
            }
        }
        return res;
    }


    public ArrayList<ArrayList<String>> partition(String s) {
        map = new HashMap<String, ArrayList<String>>();

        isPalindrome = getIsPalindrome(s);

        ArrayList<ArrayList<String>> res = partitionHelper(s, 0, s.length()-1);

        return res;
    }
}




