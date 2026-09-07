/*
 * See ArrayList documentation here:
 * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
 */

/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E[] internalArray;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[]) new Object[100];
	}

	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity) {
		this.internalArray = (E[]) new Object[initialCapacity];
	}

	/* Return the number of active slots in the array list */
	public int size() {
		return objectCount;
		// doesn't accoutn for null objects intetional 
		// int count = 0;
		// for (int i = 0; i < internalArray.length; i++) {
		// 	if (internalArray[i] != null) {
		// 		count++;
		// 	}
		// }
		// return count;
	}

	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		return objectCount == 0;
		// same as above
		// for (int i = 0; i < internalArray.length; i++) {
		// 	if (internalArray[i] != null) {
		// 		return false;
		// 	}
		// }
		// return true;
	}

	/* Get the index-th object in the list. */
	public E get(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return internalArray[index];
	}

	/* Replace the object at index with obj. returns object that was replaced. */
	public E set(int index, E obj) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		E temp = internalArray[index];
		internalArray[index] = obj;
		return temp;
	}

	/*
	 * Returns true if this list contains an element equal to obj; otherwise returns false.
	 */
	public boolean contains(E obj) {
		for (int i = 0; i < internalArray.length; i++) {
			if (internalArray[i] != null && internalArray[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	/* Insert an object at index */
	@SuppressWarnings("unchecked")
	public void add(int index, E obj) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		if (internalArray.length == this.size()) {
			E[] newArray = (E[]) new Object[internalArray.length * 2];
			for (int i = 0; i < internalArray.length; i++) {
				newArray[i] = internalArray[i];
			}
			internalArray = newArray;
		}
		for (int i = 0; i < internalArray.length; i++) {
			if (i == index) {
				for (int j = this.size(); j > i; j--) {
					internalArray[j] = internalArray[j - 1];
				}
				internalArray[index] = obj;
				objectCount++;
			}
		}
	}

	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")
	public boolean add(E obj) {
		this.add(this.size(), obj);
		return true;
	}

	/* Remove the object at index and shift. Returns removed object. */
	public E remove(int index) {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		for (int i = 0; i < internalArray.length; i++) {
			if (i == index) {
				E output = internalArray[i];
				for (int j = i; j < internalArray.length - 1; j++) {
					internalArray[j] = internalArray[j + 1];
				}
				objectCount--;
				return output;
			}
		}
		return null;
	}

	/*
	 * Removes the first occurrence of the specified element from this list, if it is present. If
	 * the list does not contain the element, it is unchanged. More formally, removes the element
	 * with the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))) (if such an
	 * element exists). Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 */
	public boolean remove(E obj) {
		if (this.contains(obj)) {
			for (int i = 0; i < internalArray.length; i++) {
				if (internalArray[i].equals(obj)) {
					this.remove(i);
					return true;
				}
			}
		}
		return false;
	}


	/*
	 * For testing; your string should output as "[X, X, X, X, ...]" where X, X, X, X, ... are the
	 * elements in the ArrayList. If the array is empty, it should return "[]". If there is one
	 * element, "[X]", etc. Elements are separated by a comma and a space.
	 */
	public String toString() {
		if (this.isEmpty()) {
			return "[]";
		}
		String output = "[";
		for (int i = 0; i < this.size() - 1; i++) {
			output += internalArray[i] + ", ";
		}
		output += internalArray[this.size() - 1] + "]";
		return output;
	}

}
