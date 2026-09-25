// Implements a singly-linked list.


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	public SinglyLinkedList(E[] values) {
		ListNode node = new ListNode<E>(values[0]);
		head = node;
		tail = node;
		for (int i = 1; i < values.length; i++) {
			add(values[i]);
		}
		nodeCount = values.length;
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		if (nodeCount == 0) {
			return true;
		}
		return false;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		ListNode<E> node = head;
		for (int i = 0; i < nodeCount; i++) {
			if (node.getValue().equals(obj)) {
				return true;
			}
			node = node.getNext();

		}
		return false;
	}


	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		ListNode<E> node = head;
		for (int i = 0; i < nodeCount; i++) {
			if (node.getValue().equals(obj)) {
				return i;
			}
			node = node.getNext();
		}
		return -1;
	}

	// Adds obj to this collection. Returns true if successful;
	// otherwise returns false.
	public boolean add(E obj) {
		ListNode<E> node = new ListNode<E>(obj);
		tail.setNext(node);
		tail = node;
		nodeCount++;
		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(E obj) {
		ListNode<E> node = head;
		if (contains(obj)) {
			while (node != tail) {
				if (node.getValue().equals(obj)) {
					node.setValue(node.getNext().getValue());
					node.setNext(node.getNext().getNext());
					nodeCount--;
					return true;
				}
				node = node.getNext();
			}
		}
		return false;
	}

	// Returns the i-th element.
	public E get(int i) {
		ListNode<E> node = head;
		for (int j = 0; j < i; j++) {
			node = node.getNext();
		}
		return node.getValue();
	}

	// Replaces the i-th element with obj and returns the old value.
	public E set(int i, E obj) {
		ListNode<E> node = head;
		for (int j = 0; j < i; j++) {
			node = node.getNext();
		}
		E value = node.getValue();
		node.setValue(obj);
		return value;
	}


	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	public void add(int i, E obj) {
		if (i == 0) {
			ListNode<E> addedNode = new ListNode<E>(obj);
			addedNode.setNext(head);
			head = addedNode;
			nodeCount++;
			return;
		}
		ListNode<E> node = head;
		for (int j = 0; j < i - 1; j++) {
			node = node.getNext();
		}
		ListNode<E> addedNode = new ListNode<E>(obj);
		addedNode.setNext(node.getNext());
		node.setNext(addedNode);
		nodeCount++;
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public E remove(int i) {
		ListNode<E> node = head;
		if (i == 0) {
			head = head.getNext();
			nodeCount--;
			return node.getValue();
		}
		for (int j = 0; j < i - 1; j++) {
			node = node.getNext();
		}
		ListNode<E> removedNode = node.getNext();
		node.setNext(node.getNext().getNext());
		nodeCount--;
		return removedNode.getValue();

	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		String output = "[";
		ListNode<E> node = head;
		for (int i = 0; i < nodeCount - 1; i++) {
			output += node.getValue() + ", ";
			node = node.getNext();
		}
		output += tail.getValue() + "]";
		return output;

	}


}
