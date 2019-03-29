/*
Question:

Given an array of integers, every element appears three times except for one. Find that single one.
Note: 
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class Solution {
    public int singleNumber(int[] A) {
        int one = 0;
        int two = 0;
        for(int a:A){
            one = (one ^ a) & ~two;
            two = (two ^ a) & ~one;
        }
        return one;
    }
}

/*假设其中一个a为0010
那么：

1.
    one = (0000 ^ 0010) & ~0000
        = 1101 & 1111
        = 1101

    two = (0000 ^ 0010) & ~1101
        = 1101 & 0010
        = 0000

2.
    one = (1101 ^ 0010) & ~0000
        = 0000 & 1111
        = 0000

    two = (0000 ^ 0010) & ~0000
        = 1101 & 1111
        = 1101

3. 
    one = (0000 ^ 0010) & ~ 1101
        = 1101 & 0010
        = 0000

    two = (1101 ^ 0010) & ~0000
        = 0000 & 1111
        = 0000

显然当与只出现一次的数运算时，one会变成那个数，而如果那个数出现三次或两次，那么就会变回0

*/