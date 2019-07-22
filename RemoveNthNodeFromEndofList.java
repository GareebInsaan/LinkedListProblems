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
    
    //function to count the number of nodes in the list
    static int nodeCount(ListNode head){
        int count = 0 ;
        
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //getting the noOfNodes in the list
        int count = nodeCount(head);
        
        /*getting the position just before from the begining at 
        which deletion is to be performed.*/
        int N = count-n;
        ListNode temp = head;
        ListNode prev = null;
        while(N-->0){
           prev = temp;
           temp = temp.next;
        }
        //if prev is not null then node is in between somewhere in list
        if(prev==null) head=temp.next;
        else{
            //if temp node is not null then Node to be deleted is not the last Node
            if(temp!=null)
                prev.next = temp.next;
            else
                prev.next = null;
        }
        
        return head;
    }
        
}
