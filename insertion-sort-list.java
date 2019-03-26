//Question: Sort a linked list using insertion sort.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        //TODO 插入排序

        //创建一个临时的链头
        ListNode dummy = new ListNode(0);

        //若链表中还有节点
        while(head != null){
            ListNode node = dummy;

            //找到临时链表中节点的值比当前head的值大
            while(node.next != null && node.next.val < head.val){
                node = node.next;
            }

            //找到了就在比head大的节点的前一个节点处插入，找不到就插末尾
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}