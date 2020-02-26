import java.util.Scanner;

class DoublyList
{
	Node head;
	Node tail;
	class Node
	{
		Node next;
		Node prev;
		int data;
		Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
	}
	
	void insertEnd(int d)
	{
		Node n = new Node(d);
		if(head == null)
		{
			head = n;
			tail = n;
		}
		else
		{
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
	}
	
	void insertStart(int d)
	{
		Node n = new Node(d);
		if(head == null)
		{
			head = n;
			tail = n;
			
		}
		else
		{
			n.next = head;
			head.prev = n;
			head = n;
		}
	}

	void insertAt(int position, int d)
	{
		Node n = new Node(d);
		if(head == null && position != 1)
			System.out.println("Cannot Insert");
		else if(position == 1)
		{
			n.next = head;
			head = n;
			n.prev = head;
		}
		else
		{
			Node current = head;
			int count = 1;
			while(count < position-1 && current.next != null)
			{
				current = current.next;	
				count += 1;
			}
			if(count == position-1)
			{
				n.next = current.next;
				n.prev = current;
				current.next = n;
			}
			else
				System.out.println("Cannot Insert");
		}	
	}

	void deleteEnd()
	{
		if(tail == head)
			head = null;
		else
		{
			tail = tail.prev;
			tail.next = null;
		}
	}
	
	void deleteStart()
	{
		if(head == tail)
			head = null;
		else
		{
			head.next.prev = null;
			head = head.next;
		}
	}

	void deletePosition(int position)
	{
		if(head == null)
			System.out.println("Cannot Delete");
		else if(position == 1)
		{
			deleteStart();	
		}
		else
		{
			Node current = head;
			int count  = 1;
			while(count < position && current.next != null)
			{
				count += 1;
				current = current.next;	
			}
			if(count == position)
			{
				if(current != tail)
				{
					current.prev.next = current.next;
				}
				else
					deleteEnd();
			}
			else
				System.out.println("Cannot Delete");
		}
	}
		
	void deleteValue(int value)
	{
		if(head == null)
			System.out.println("Cannot Delete");
		else
		{
			Node current = head;
			int pos = 1;
			while(current.data != value && current.next != null)
			{
				pos += 1;
				current = current.next;
			}
			if(current.data == value)
				deletePosition(pos);
			else
				System.out.println("Cannot Delete");
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
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		DoublyList ls = new DoublyList();
		
		int n;

		System.out.println("Press 0 to Insert at End");
		System.out.println("Press 1 to Insert at Start");
		System.out.println("Press 2 to Delete end element of list");
		System.out.println("Press 3 to Delete start element of list");
		System.out.println("Press 4 to Insert at a position");
		System.out.println("Press 5 to Delete a Position");
		System.out.println("Press 6 Display List");
		System.out.println("Press -1 to EXIT");

		while((n = scan.nextInt()) != -1)
		{
			switch(n)
			{
				case 0:
					System.out.println("Please enter value");
					int a = scan.nextInt();
					ls.insertEnd(a);
					break;
				case 1:
					System.out.println("Please enter value");
					int b = scan.nextInt();
					ls.insertStart(b);
					break;
				case 2:
					ls.deleteEnd();
					break;	
				case 3:
					ls.deleteStart();
					break;
				case 4:
					System.out.println("Please enter position");
					int position1 = scan.nextInt();
					System.out.println("Please enter value");
					int value1 = scan.nextInt();
					ls.insertAt(position1, value1);
					break;
				case 5:
					System.out.println("Please enter position to be deleted");
					int position = scan.nextInt();
					ls.deletePosition(position);
					break;
				case 6:
					ls.display();
					break;
			}
			System.out.println("Press 0 to Insert at End");
			System.out.println("Press 1 to Insert at Start");
			System.out.println("Press 2 to Delete end element of list");
			System.out.println("Press 3 to Delete start element of list");
			System.out.println("Press 4 to Insert at a position");
			System.out.println("Press 5 to Delete a Position");
			System.out.println("Press 6 Display List");
			System.out.println("Press -1 to EXIT");
		}
		System.out.println("See Ya!");
	}
}
