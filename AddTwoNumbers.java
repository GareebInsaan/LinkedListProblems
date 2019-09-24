/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = new ListNode((l1.val + l2.val)%10) ;
         int carry = (l1.val + l2.val)>9 ? 1 : 0;
	    	 l1=l1.next ;
         l2=l2.next ;
	       ListNode temp = head ;
         // Adding the sum of both values from each linked list
	         while(l1!=null && l2!=null){
	             int sum = l1.val + l2.val ;
	             if(carry == 1) sum+=1;
	             int currVal = sum%10;
	             temp.next = (new ListNode(currVal));
	             temp = temp.next ;
	             carry = sum>9 ? 1 : 0 ;
	                 l1=l1.next ;
	                 l2=l2.next ;
	         }
           //If lists are unequal adding the values of the larger numbers
	         if(l1!=null){
                 while(l1!=null){
                    int val = (l1.val+carry)%10 ;
                    temp.next= new ListNode(val); 
                    carry = (l1.val + carry) > 9 ? 1 : 0 ;
                    l1 = l1.next ;
                    temp = temp.next;
                 }
             }else {
                 while(l2!=null){
                     int val = (l2.val+carry)%10 ;
                     temp.next= new ListNode(val); 
                     carry = (l2.val + carry) > 9 ? 1 : 0 ;
                     l2 = l2.next ;
                     temp = temp.next;
                 }
             } 
            //if two lists are equal and the last two digits give a sum greater than 10 
            //then we need to add extra carry value in the result linked list
            if(carry==1) temp.next= new ListNode(1);
	         
	       return head ;
    }
}
