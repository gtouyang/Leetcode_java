/**
    Question:
    Given a singly linked list L: L 0→L 1→…→L n-1→L n,
    reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */

 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 import java.util.*;

public class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;

        merge(head, tail);

    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
        
    }

    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public void merge(ListNode head1, ListNode head2){
        Boolean addHead1 = true;
        ListNode dummy = new ListNode(0);
        while(head1 != null && head2 != null){
            if(addHead1){
                dummy.next = head1;
                head1 = head1.next;
                addHead1 = false;
            }else{
                dummy.next = head2;
                head2 = head2.next;
                addHead1 = true;
            }
            dummy = dummy.next;
        }
        if(head1 != null){
            dummy.next = head1;
        }else{
            dummy.next = head2;
        }

    }

}