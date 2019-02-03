package list;

public class ListNode {
	int data;
	ListNode next;

	ListNode(){

	}

	ListNode(int d){
		data = d;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + "]";
	}


}
