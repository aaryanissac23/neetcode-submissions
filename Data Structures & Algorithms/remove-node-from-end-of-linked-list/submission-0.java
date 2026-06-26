/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        int k = len - n;
        if(k == 0) return head.next;
        curr= head;
        for(int i = 0 ; i < k-1 ; i++){
            curr = curr.next;
        }
        ListNode node = curr.next;
        ListNode next = node.next;
        node.next = null;
        curr.next = next;
        return head;
    }
}
