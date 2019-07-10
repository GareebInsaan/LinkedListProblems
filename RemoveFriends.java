import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


class Node {
	
	String val ;
	Node next ;
	
	public Node(String val) {
		super();
		this.val = val;
		this.next = null ;
	}
	
	
}

//LinkList Class having the utility functions for working with link list.
class LinkList {
	
	private Node head ;
	
	//Method for adding Node to a link list
	public void add(String val){
		
		Node n = new Node(val);
		
		if(head==null){
			head = n;
		}
		else{
			Node curr = head ;
			
			while(curr.next!=null){
				curr = curr.next ;
			}
			curr.next = n ;
		}
	}
	
	
	//Method for printing the link list elements
	public StringBuilder print(Node head){
		StringBuilder out = new StringBuilder();
		if(head==null){
			//System.out.print("Empty List!");
			return null ;
		}
		else{
			Node curr = head ;
			
				while(curr!=null){
				   // System.out.print(curr.val + " ");
				    out.append(curr.val + " ");
			    	curr = curr.next ;
				}
			}
			return out ;
		}
	
	//Method to reverse link list provided with the head node using recursion
	public Node reverse(Node n) {
		
		if(n==null || n.next==null){
			return n ;
		}
		Node reverseHead = reverse(n.next);
		n.next.next = n ;
		n.next = null ;
		return reverseHead ;
	}

    
    //setter for head node
	public void setHead(Node head) {
		this.head = head;
	}

    //Getter for head node
	public Node getHead() {
		return this.head;
	}

    //method to get the last element of the link list.
	public Node getLastNode(Node head) {
		if(head==null){
			return head ;
		}
		
		while(head.next!=null){
			head = head.next;
		}
		return head ;
	}
	
	//method for removing element from the last
	public void removeFromLast(){
		Node curr = head ;
		if(curr==null || curr.next == null) head = null;
		else{
			while(curr.next.next!=null){
				curr=curr.next ;
			}
			curr.next = null ;
		}
		
	}
	
}

//Runner class 
class TestClass {
    
    
    public static void main(String [] args) throws Exception {
		
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  T = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder("");
        while(T-->0){
            String [] inps = br.readLine().split(" ");
            int K = Integer.parseInt(inps[1]);
            String [] values = br.readLine().split(" ");
            
            LinkList list = new LinkList();
            for(String s : values){
                list.add(s);
            }
           
           //code to remove the nodes whose values are less than next node
           Node prev = null ;
           Node curr = list.getHead();
           
           while(curr.next!=null){
               //checking the condition of popularity value for removing friend
               if(K >0 && (Integer.parseInt(curr.val) < Integer.parseInt(curr.next.val))){
                   if(prev==null) list.setHead(curr.next);
                   else{
                      prev.next = curr.next ;
                   }
                    prev = null ;
                    curr = list.getHead();
                    K-- ;
               }else{
                   prev = curr;
                   curr = curr.next ;
               }
           }
           //removing K elements if the elements are arranged in descending order
           if(K>0){
               while(K-->0) list.removeFromLast();
           }
           StringBuilder sb = list.print(list.getHead());
           sb.append("\n");
           output.append(sb);
        }
          System.out.print(output);
    }
    
}

NOTE : The soultion is partially accepted and gives TLE for most of the Test Cases.Will update the complete accepted code once I get.
