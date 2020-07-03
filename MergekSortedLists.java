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
    
    public ListNode mergeList(ListNode list1 ,ListNode list2){
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        
        ListNode out = new ListNode();
        ListNode mergeList = out;
        
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                if(mergeList==null) mergeList = temp1;
                else mergeList.next = temp1;
                temp1 = temp1.next;
            }else {
                if(mergeList==null) mergeList = temp2;
                else mergeList.next = temp2;
                temp2 = temp2.next;
            }
            mergeList = mergeList.next;
        }
        if(temp1==null) mergeList.next=temp2;
            else mergeList.next = temp1;
        
        return out;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = new ListNode();
        if(lists.length == 0) return new ListNode().next;
        output = lists[0];
        for(int i = 1 ; i<lists.length ; i++){
            if(output==null && lists[i]==null) output=output;
             
            if(output!=null || lists[i]!=null) {
                output = mergeList(output,lists[i]); 
                output = output.next;
            }
        }
        return output;
    }
}
