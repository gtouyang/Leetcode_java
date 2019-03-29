/*
Question:

Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
*/

import java.util.*;

public class Solution {

    //判断start到end处是不是回文
    private boolean isPalindrome(String s, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

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

    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        boolean[][] isPalindrome = getIsPalindrome(s);

        int len_s = s.length();

        //f[i]记录前i个字母的最少分割次数
        int[] f = new int[len_s + 1];
        for (int i = 0; i <= len_s; i++){
            f[i] = i - 1;
        }

        for (int i = 1; i <= len_s; i++){
            for (int j = 0; j < i; j++){
                if (isPalindrome[j][i-1]){

                    //如果j到i-1是回文，那么如果前j个字母的最少分割次数+1少于当前前i个字母最少分割次数，则更新
                    f[i] = Math.min(f[i], f[j]+1);
                }
            }
        }

        return f[len_s];
    }
}