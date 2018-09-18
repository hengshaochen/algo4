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
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            map.put(cur, newNode);
            cur = cur.next;
        }
        
        cur = head;
        while (cur != null) {
            RandomListNode curNewNode = map.get(cur);
            curNewNode.random = map.get(cur.random);
            curNewNode.next = map.get(cur.next);
            cur = cur.next;
        }
        
        return map.get(head);
    }
}