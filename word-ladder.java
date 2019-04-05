/*
题目描述

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]

As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int count = 0;
        ArrayList<String> queue = new ArrayList<String>();


        HashSet<String> d = new HashSet<String>(dict);
        d.add(end);

        queue.add(start);

        Iterator iterator;

        boolean changeable = true;

        while (changeable) {

            changeable = false;
            ArrayList<String> newQueue = new ArrayList<String>();
            for (String word:queue){
                if(word.equals(end)){
                    return count + 1;
                }

                iterator = d.iterator();

                while (iterator.hasNext()) {
                    String s = iterator.next().toString();
                    if (diff(word, s) == 1) {
                        changeable = true;
                        newQueue.add(s);
                    }
                }

                for (String s : newQueue){
                    d.remove(s);
                }

            }
            queue = newQueue;
            count++;

        }

        return 0;
    }

    public int diff(String s1, String s2) {

        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}