/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    //utility function for calculating the list length
    static int len(ListNode node){
        int len = 0 ;
        while(node!=null) {
            len++;
            node= node.next;
        }
        return len ;
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head ;
        ListNode newHead = null ;
        int len = len(head);
        //if list is null
        if(head==null) return null;
        //if list is to be rotated 0 or equal to list length
        else if(k%len==0) return head ;
        //main code for rotating the list
        else if(len>1){
            int rotate = len-(k%len)-1;
            // take the head temp pointer to the point before the rotation
            while(rotate-->0){
                temp = temp.next;
            }
            //assign the newHead to the temp.next i.e to the node from which we have to dissect
            newHead = temp.next ;
            //free the next of the temp point to make it the last node
            temp.next = null ;
            temp = newHead;
            //move the new head pointer to the last node so that it could be attached to the actual head now.
            while(temp.next!=null){
                temp = temp.next ;
            }
            temp.next = head;
            return newHead ;
        }else{
            return head;
        }
        
    }
}
