class CircularLinkedList {
	Node head;
	Node tail;

	class Node {
		Node next;
		int data;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void insertEnd(int d) {
		Node n = new Node(d);
		if(head == null) {
			head = n;
			tail = n;
			n.next = head;
		} else {
			tail.next = n;
			n.next = head;
			tail = n;
		}	
	}
	
	void insertStart(int d) {
		Node n = new Node(d);
		if(head == null) {
			head = n;
			tail = n;
			n.next = head;
		} else {
			n.next = head;
			head = n;
			tail.next = head;
		}
	}
	
	void insertAt(int position, int d) {
		Node n = new Node(d);
		if(head == null && position == 1) {
			head = n;
			tail = n;
			n.next = head;
		} else if(position == 1) {
			n.next = head;
			head = n;
			tail.next = head;
		} else {	
			int count = 1;
			Node current = head;
			while(current != tail && count != position-1) {
				current = current.next;
				count += 1;	
			}

			if(current != tail && count == position-1) {
				n.next = current.next;
				current.next = n;
			} else if(current == tail && count == position-1) {
				current.next = n;
				n.next = head;
				tail = n;
			} else {
				System.out.println("Cannot Add");	
			}
		}
	}

	void insertBefore(int value, int d) {
		Node n = new Node(d);
		if(head == null) {
			System.out.println("Cannot Add");
		} else if(head.data == value) {
			n.next = head;
			head = n;
			tail.next = head;
		} else {
			Node current = head;
			while(current.next.data != value) {
				current = current.next;	
			}
			n.next = current.next;
			current.next = n;
		}
	}

	void deleteStart() {
		if(head == null) {
			System.out.println("Cannot Delete");
		} else {
			Node current = head;
			head = current.next;
			tail.next = head;
		}	
	}
	
	void deleteEnd() {
		if(head == null) {
			System.out.println("Cannot Delete");
		} else {
			Node current = head;
			while(current.next != tail) {
				current = current.next;
			}
			current.next = head;
			tail = current;
			tail.next = head;		
		}
	}
	
	void deleteAt(int position) {
		if(head == null) {
			System.out.println("Cannot Delete");
		} else {
			int count = 1;
			Node current = head;
			while(current.next != head && count < position-1) {
				current = current.next;
				count += 1;
			}
			if(position == 1) {
				deleteStart();
			} else if(count == position-1) {
				if(current.next != tail) {
					current.next = current.next.next;
				} else if(current.next == tail) {
					deleteEnd();
				}
			} else {
				System.out.println("Cannot Delete");
			}
		}	
	}
	
	void deleteValue(int value) {
		if(head == null) {
			System.out.println("Cannot Delete");
		} else {
			Node current = head;
			if(current == head && current.data == value) {
				deleteStart();
			} else {
				while(current.next.data != value && current != tail) {
					current = current.next;
				}
				if(current.next != tail && current.next.data == value) {
					current.next = current.next.next;
				} else if(current.next == tail && current.next.data == tail.data) {
					deleteEnd();
				} else {
					System.out.println("Cannot Delete");	
				}
			}	
		}
	}

	void display() {
		if(head == null) {
			System.out.println("List is Empty!");
		} else {
			Node current = head;
			while(current.next != head) {
				System.out.print(current.data + " ");
				current = current.next;
			}

			System.out.print(current.data);
		}
	}
  
}
