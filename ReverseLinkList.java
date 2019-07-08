import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


// Node class for creating each Node of LinkList
class Node {
	
	int val ;
	Node next ;
	
	public Node(int val) {
		super();
		this.val = val;
		this.next = null ;
	}
	
	
}

//LinkList Class having the utility functions for implementing the link list.
class LinkList {
	
	private Node head ;
	
	//Method for adding Node to a link list
	public void add(int val){
		
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
	public void print(Node head){
		
		if(head==null){
			System.out.print("Empty List!");
		}
		else{
			Node curr = head ;
			
				while(curr!=null){
				System.out.print(curr.val + " ");
				curr = curr.next ;
				}
			}
		}
	
	//Method to reverse a link list provided with the head node using recursion
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
	
}

//Runner class for testing the link list functionalities.
class TestClass {
    
    
    public static void main(String [] args) throws Exception {
		
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String [] name = br.readLine().split(" "); 
        
        //Created the link list instance
        LinkList list = new LinkList();
        for(String n : name){
            //adding each value to the link list
            list.add(Integer.parseInt(n));
        }
		
		//setting the current node of link list
		Node curr = list.getHead();
		//making previous pointer null ;
		Node prev = null;
		
		while(curr!=null){
		    
		    //temp link list for getting sub link list of even values
			LinkList listTemp = new LinkList();
			//Counter to have the length of the sub link list
			int len = 0 ;
			    
			    //loop for adding continuous even values to the sub link list
				while(curr!= null && curr.val%2==0){
					listTemp.add(curr.val);
					len++;
					curr = curr.next;
				}
			if(len>1){
			    
			    //getting the head node of the reversed sub link list
				Node head = listTemp.reverse(listTemp.getHead());
				//getting the tail node of the reversed sub link list
				Node tail = listTemp.getLastNode(head);
				//setting the next of the prev Node of the curr link list to the head of the sub link list.
				if(prev!=null )prev.next = head ; else list.setHead(head);
				//setting the next of tail node of the sub link list to the current node
				tail.next = curr ;
				//Making the sub link list head null for reuse
				listTemp.setHead(null);
			}
			//incrementing the values of the prev and the current node pointers.
			prev = curr ;
			if(curr!=null)curr = curr.next;
		}
		list.print(list.getHead());
	}
    
    
}
