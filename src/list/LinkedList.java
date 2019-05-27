package list;

public class LinkedList {
	ListNode head;

	public void pushInEnd(int newData) {
		ListNode newNode = new ListNode(newData);
		newNode.next = null;
		if(head==null)head = newNode;
		else
			getLastNode(head).next=newNode;
	}

	public ListNode getLastNode(ListNode node) {
		if(node.next == null)return node;
		else
			return getLastNode(node.next);

	}

	public int getLength() {
		return getCount(head);
	}

	private int getCount(ListNode node) {
		if(node==null) return 0;
		else return 1+getCount(node.next);
	}


	public int indexOf(int element) {
		return findElement(head,element,0);
	}


	private int findElement(ListNode node, int element, int index) {
		if(node==null)return -1;
		else if(node.data==element) return index;
		else if(node.next==null ) return -1;
		else return findElement(node.next,element,index+1);
	}


	public int printMiddle() {
		ListNode one = head;
		ListNode second = head;
		while(one!=null && one.next!=null) {
			one = one.next.next;
			second = second.next;
		}
		return second.data;
	}

	public void printList() {
		ListNode node = head;
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public void reverse() {
		head = reverseUtil(head);
		System.out.println("Hello");

	}

	private ListNode reverseUtil(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode newNode = reverseUtil(node.next);
		node.next.next = node;
		node.next = null;
		return newNode;
	}
}
