/*class Node{
	int data;
	Node next;
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}
	class Main
	{
		public static void main(String[]args)
		{
			Node n1 = new Node(10);
			Node n2 = new Node(20);
			 n1.next = n2;
			System.out.println(n1.next.data);
			System.out.println(n2.data);
		}
	}
	*/
	
	
	import java.util.*;
	
	
	class Main
	{
		Node head, tail;
		int size;
		public Main()
		{
			head = tail= null;
			size =0;
			
		}
		class Node{
	int data;
	Node next;
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

public void addLast (int data)
{
	Node n = new Node(data);
	if(head == null)
	{
		head = tail=n;
	}
	
	else
	{
		tail.next=n;
		tail=n;
	}
	size++;
	
}

public void addFirst(int data)
{
	Node newNode = new Node(data);
	
	newNode.next = head;
	head= newNode;
	size++;
}

public void count()
{
	
	System.out.println("total no of node->" +size);
}

public void insertAnyPos(int data)
{
	int pos;
	Scanner sc = new Scanner(System.in);
	
	
	
	System.out.println("Enter pos to insert");
	 pos = sc.nextInt(); 
	  if (pos < 1 || pos > size + 1) {
        System.out.println("Invalid position!");
        return;
    }
	Node newNode = new Node(data);
	  if (pos == 1) {  // Inserting at the head (position 1)
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;  // If list was empty, the new node is both head and tail
        }
    } 
	else{
		Node tmp = head;
	for(int i=1;i<pos-1; i++)
	{
		tmp= tmp.next;
		
	}
	
	newNode.next = tmp.next;
	tmp.next= newNode;
	
	  if (newNode.next == null) {
            tail = newNode;  // Update tail if the new node is inserted at the end
        }
    }
size++;	
}

public void deleteFirst()
{
	  if (head == null) {  // If the list is empty, there's nothing to delete
        System.out.println("The list is empty!");
        return;
    }
	head = head.next;
	size--;
}

public void deleteLast()
{
	  if (head == null) {  // If the list is empty, there's nothing to delete
        System.out.println("The list is empty!");
        return;
    }
	else
	{
		Node tmp = head;
	while(tmp.next!=null && tmp.next.next!=null)
	{
		tmp = tmp.next;
		
	}
	tmp.next=null;
	tail= tmp;
	}
	size--;

}

public void deleteAnyPos()
{
	int pos;
	Scanner sc = new Scanner(System.in);
	
	
	
	System.out.println("Enter pos to insert");
	 pos = sc.nextInt(); 
	  if (pos < 1 || pos > size) {
        System.out.println("Invalid position!");
        return;
    }
	
	  if (pos == 1) {  // delete at the head (position 1)
        head = head.next;
	
    } 
	else{
		Node tmp = head;
	for(int i=1;i<pos-1; i++)
	{
		tmp= tmp.next;
		
	}
	tmp.next=tmp.next.next;
	
	
	
	  if (tmp.next == null) {
           tail=tmp;
	  }
	}
size--;	
}

public void reverse()
{
	 if (head == null) {
        System.out.println("List is empty!");
        return;
    }

    // Case 1: Only one element
    if (head != null && head.next == null) {
        System.out.println("Only one element, no need to reverse.");
        return;
    }

    // Case 2: Only two elements
    if (head.next.next == null) {
        Node second = head.next;
        second.next = head;
        head.next = null;
        tail = head;
        head = second;
        System.out.println("Reversed list with two elements.");
        return;
    }


	 Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
        next = current.next;   // Store next node
        current.next = prev;   // Reverse current node's pointer
        prev = current;        // Move prev and current one step forward
        current = next;
    }

    tail = head;   // After reversal, head becomes tail
    head = prev;   // prev is the new head
}


public void print()
{
	Node tmp = head;
	 if (tmp == null) {
         System.out.println("List is empty.");
            return;
        }
	while(tmp!=null)
	{
		System.out.println(tmp.data);
		tmp = tmp.next;
	}
	
}
		public static void main(String[]args)
		{
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("--------Singly LinkedList Menu-----");
			System.out.println("press 1-> for addLast");
			System.out.println("press 2-> for addFirst");
			System.out.println("press 3-> for count the no of node");
		   System.out.println("press 4-> for insertanypos");
		    System.out.println("press 5-> for delfirst");
			System.out.println("press 6-> for dellast");
			System.out.println("press 7-> for delanypos");
			System.out.println("press 8-> for reverse");
		   System.out.println("press 9-> for print");
		    System.out.println("press 10-> for Exit");
		   System.out.println("Enter your choice->");
		   int choice=sc.nextInt();
		   switch(choice)
		   {
			   case 1:
			   int lastData = sc.nextInt();
			    m.addLast(lastData);
		        
				  break;
				  
				  case 2:
				   int FirstData = sc.nextInt();
			    m.addFirst(FirstData);
				 
				  break;
				  case 3:
				  m.count();
				  break;
				  case 4:
				  
				  int Data = sc.nextInt();
			    m.insertAnyPos(Data);
	 
				  break;
				   case 5:
				  m.deleteFirst();
	 
				  break;
				   case 6:
				  m.deleteLast();
	 
				  break;
				   case 7:
				  m.deleteAnyPos();
	 
				  break;
	               case 8:
				  m.reverse();
	 
				  break;
				   case 9:
				  m.print();
	 
				  break;
				   case 10:
				 System.exit(0);
	 
				  break;
				  default:
				  System.out.println("invalid choice please enter valid");
		   }
		}
			   
		
		
		
			
	 
	 
		}
	}