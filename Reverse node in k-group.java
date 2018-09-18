/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while (head != null) {
            head = reverseK(head, k);
        }
        
        return dummy.next;
    }
    
    ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk != null) {
                nk = nk.next;
            } else {
                return null;
            }
        }
        if (nk == null) {
            return null;
        }
        
        ListNode n1 = head.next;
        ListNode nkplus = nk.next;
        
        ListNode pre = null;
        ListNode cur = n1;
        while (cur != nkplus) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        
        head.next = nk;
        n1.next = nkplus;
        return n1;
        
    }
}