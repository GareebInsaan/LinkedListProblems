//Url : https://leetcode.com/problems/merge-two-sorted-lists/
//level : easy

class Solution {
    
    //Method to add a node in given linked list
    static ListNode add(ListNode n,int val){
        ListNode temp = n ;
        ListNode newNode = new ListNode(val);
        if(temp==null){
            return newNode ;
        }else{
            
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = newNode ;
            return  n ;
        }
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        
        //comparing two lists till the time any one of the two becomes empty       
            while(l1!=null && l2!=null)
            {
                if(l1.val < l2.val){
                   head = add(head ,l1.val);
                    l1 = l1.next ;
                }else{
                   head = add(head ,l2.val);
                    l2 = l2.next ;
                }
            }
        // if l1 list becomes empty add rest elements of l2 to final list
        if(l1==null) {
            while(l2!=null) {
                head = add(head,l2.val);
                l2 = l2.next ;
            }
        }else{
         // if l2 list becomes empty add rest elements of l1 to final list
            while(l1!=null) {
                head = add(head,l1.val);
                l1 = l1.next ;
            }
        }
        
        return head;
    }
}
