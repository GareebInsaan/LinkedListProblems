//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

//Level : Medium

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    static int nodeCount(ListNode head){
        int count = 0 ;
        
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = nodeCount(head);
       // System.out.print(count);
        int N = count-n;
        ListNode temp = head;
        ListNode prev = null;
        while(N-->0){
           prev = temp;
           temp = temp.next;
        }
        
        if(prev==null) head=temp.next;
        else{
            if(temp!=null)
                prev.next = temp.next;
            else
                prev.next = null;
        }
        
        return head;
    }
        
}
