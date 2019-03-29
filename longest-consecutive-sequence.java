/*
Question:

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

*/

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }

        HashSet<Integer> s = new HashSet<Integer>();

        for(int n : num){
            s.add(n);
        }

        int res = 0;

        for(int n : num){
            if(s.remove(n)){
                int pre = n - 1;
                int next = n + 1;
                while(s.remove(pre)){
                    pre --;
                }
                while(s.remove(next)){
                    next ++;
                }
                res = Math.max(res, next-pre-1);
            }
        }

        return res;
    }
}