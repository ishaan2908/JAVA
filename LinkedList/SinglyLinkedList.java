import java.util.Scanner;

public class SinglyLinkedList
{
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	void insertAtEnd(int d)
	{
		Node n = new Node(d);
		if(head == null)
		{
			head = n;
		}
		else
		{
			Node current = head;
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = n;
		}
	}

	void insertAtStart(int d)
	{
		Node n = new Node(d);
		n.next = head;
		head = n;	
	}

	void insertAt(int position, int d)                                                                                                                                                
	{
		Node n = new Node(d);
		Node current = head;
		int count = 0;
		if(head == null && position != 1)
		{
			System.out.println("Cannot insert. List is empty.");
		}
		else if(position == 1)
		{
			n.next = current;
			head = n;
		}
		else
		{
			while(current.next != null && count < position-2)
			{
				current = current.next;		
				count += 1;
			}
			if(position-2 == count)
			{
				n.next = current.next;
				current.next = n;			
			}
			else
			{
				System.out.println("Cannot insert at " + position + " position");
			} 
		}   
	}

	void insertAfter(int value, int d)
	{
		Node n = new Node(d);
		Node current = head;
		if(head == null)
		{
			System.out.println("Cannot insert. List is empty.");
		}
		else
		{
			while(current.next != null && current.data != value)
			{
				current = current.next;							
			}
			if(current.data != value)
				System.out.println("Value " + value + " does not exist");
			else
			{
				n.next = current.next;
				current.next = n;
			}
		}
	}
	
	void insertBefore(int value, int d)
	{
		Node n = new Node(d);
		Node current = head;
		if(head == null)
		{
			System.out.println("Cannot insert. List is empty.");
		}
		else if(current.data == value)
		{		
			n.next = current;
			head = n;
		}
		else
		{
			while(current.next.next != null && current.next.data != value)
			{
				current = current.next;							
			}
			if(current.next.data != value)
				System.out.println("Value " + value + " does not exist");
			else
			{
				n.next = current.next;
				current.next = n;
			}
		}
	}
	
	void deleteEnd()
	{
		Node current = head;
		if(head == null)
		{
			System.out.println("Cannot delete. List is empty.");
		}
		else if(current.next == null)
		{
			current.next = null;
		}
		else
		{
			while(current.next.next != null)
				current = current.next;
			current.next = null;
		}
	}

	void deleteStart()
	{
		if(head == null)
		{
			System.out.println("Cannot delete. List is empty.");
		}
		else
		{
			Node current = head;
			current = current.next;
			head = current;
		}
	}
	
	void deleteAt(int position)
	{
		int count = 0;
		Node current = head;
		if(head == null)
		{
			System.out.println("Cannot delete. List is empty.");
		}
		else if(position == 1)
		{
			current = current.next;
			head = current;		
		}	
		else
		{
			while(current.next.next != null && count < position-2)
			{
				current = current.next;
				count += 1;	
			}
			if(current.next.next == null && count == position-2)
			{
				current.next = null;
			}
			else if(count == position-2)
			{
				current.next = current.next.next;
				current = current.next;		
			}
			else
			{
				System.out.println("Cannot delete at position " + position);
			}	
		}
	}

	void deleteValue(int d)
	{
		Node current = head;
		if(head == null)
		{
			System.out.println("Cannot delete. List is empty.");
		}
		else if(current.data == d)
		{
			current = current.next;
			head = current;
		}
		else
		{
			while(current.next.next != null && current.next.data != d)
			{
				current = current.next;	
			}
			if(current.next.next == null && current.next.data == d)
			{
				current.next = null;	
			}
			else if(current.next.data == d)
			{
				current.next = current.next.next;
				current = current.next;
			}
			else
			{
				System.out.println("Cannot delete value " + d);
			}
		}	
	}	
	void display()
	{
		Node current = head;	
		while(current != null)
		{
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	void sort()
	{
		int s = size();
		for(int rounds = 1; rounds <= s-1; rounds++)
		{
			for(Node current = head; current.next != null; current = current.next)
			{
				if(current.data > current.next.data)
				{
					int t = current.data;
					current.data = current.next.data;
					current.next.data = t;
 				}	
			}
		}
		display();
	}
	
	int size()
	{
		Node current = head;
		int s = 0;
		while(current.next != null)
		{
			current = current.next;
			s += 1;
		}
		return s+1;
	}		
	
	void reverse()
	{
		Node prev = null;
		Node current = head;
		Node nextNode;
		while(current != null)
		{	
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
		display();
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		SinglyLinkedList ls = new SinglyLinkedList();
		
		int n;

		System.out.println("Press 0 to Insert at End");
		System.out.println("Press 1 to Insert at Start");		
		System.out.println("Press 2 to Insert at Position");
		System.out.println("Press 3 to Insert before a Value");
		System.out.println("Press 4 to Insert after a Value");
		System.out.println("Press 5 to Delete End Element");
		System.out.println("Press 6 to Delete First Element");
		System.out.println("Press 7 to Delete a Position");
		System.out.println("Press 8 to Delete a Value");
		System.out.println("Press 9 to Display");
		System.out.println("Press 10 to Sort and Display");
		System.out.println("Press 11 to Reverse and Display");
		System.out.println("Press -1 to EXIT");
		
		while((n = scan.nextInt()) != -1)
		{
			switch(n)
			{
				case 0:
					System.out.println("Please enter value");
					int a = scan.nextInt();
					ls.insertAtEnd(a);
					break;
				case 1:
					System.out.println("Please enter value");
					int b = scan.nextInt();
					ls.insertAtStart(b);
					break;
				case 2:
					System.out.println("Please enter position");
					int position1 = scan.nextInt();
					System.out.println("Please enter value");
					int value1 = scan.nextInt();
					ls.insertAt(position1, value1);
					break;
				case 3:
					System.out.println("Insert Before? Please enter value");
					int value2 = scan.nextInt();
					System.out.println("Please enter value to be inserted before " + value2);
					int c = scan.nextInt();
					ls.insertBefore(value2,c);
					break;
				case 4:
					System.out.println("Insert After? Please enter value");
					int value3 = scan.nextInt();
					System.out.println("Please enter value to be inserted after " + value3);
					int d = scan.nextInt();
					ls.insertAfter(value3,d);
					break;
				case 5:
					ls.deleteEnd();
					break;	
				case 6:
					ls.deleteStart();
					break;
				case 7:
					System.out.println("Please enter position to be deleted");
					int position = scan.nextInt();
					ls.deleteAt(position);
					break;
				case 8:
					System.out.println("Please enter value to be deleted");
					int value = scan.nextInt();
					ls.deleteValue(value);
					break;
				case 9:
					ls.display();
					break;
				case 10:
					ls.sort();
					break;
				case 11:
					ls.reverse();
					break;
				default:
					System.out.println("please enter a valid option");
					break;
					
			}
		
			System.out.println("Press 0 to Insert at End");
			System.out.println("Press 1 to Insert at Starting");		
			System.out.println("Press 2 to Insert at Position");
			System.out.println("Press 3 to Insert Before a Value");
			System.out.println("Press 4 to Insert After a Value");
			System.out.println("Press 5 to Delete End Element");
			System.out.println("Press 6 to Delete First Element");
			System.out.println("Press 7 to Delete a Position");
			System.out.println("Press 8 to Delete a Value");
			System.out.println("Press 9 to Display");
			System.out.println("Press 10 to Sort and Display");
			System.out.println("Press 11 to Reverse and Display");
			System.out.println("Press -1 to EXIT");
		}

		System.out.println("See Ya!");
	}
}
