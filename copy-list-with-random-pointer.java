/*Question:
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    Return a deep copy of the list.

*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        
        RandomListNode p = head;
        RandomListNode copy;

        //复制新链表，将新链表插入到原链表中，新节点在原节点下一个
        while(p != null){
            copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        //回到起点
        p = head;

        //以新链表的第一个结点作为头
        RandomListNode newHead = p.next;

        //将新结点的random指向原节点的random.next，要注意原节点的random是不是null
        while(p != null){
            copy = p.next;
            if (p.random == null){
                copy.random = null;
            }else{
                copy.random = p.random.next;
            }
            p = copy.next;
        }

        //回到起点
        p = head;

        //分离两个链表
        while(p != null){
            copy = p.next;
            p.next = copy.next;

            //注意链表最后一个结点时如果访问p.next.next会出错相当于null.next
            if(copy.next != null){
                copy.next = p.next.next;
            }
            p = p.next;
        }

        return newHead;
        
    }
}