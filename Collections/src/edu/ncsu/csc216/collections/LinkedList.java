package edu.ncsu.csc216.collections;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
/**
 * A class to create a linked list of data.
 * @author Logan
 *
 * @param <E>
 */
public class LinkedList<E> extends AbstractSequentialList<E> {
	/** 
	 * An inner class that creates a ListNode in order to store data within the LinkedList. 
	 * @author Logan
	 *
	 */
	private class ListNode {
			/** The data held within the ListNode. */
			public E data;
			/** The reference to the previous ListNode in the LinkedList. */
			public ListNode prev;
			/** The reference to the next ListNode in the LinkedList. */
			public ListNode next;
			/**
			 * A constructor for ListNode that stores a piece of data and sets all references to null.
			 * @param data the data being stored in the ListNode.
			 */
			public ListNode(E data) {
				this(data, null, null);
			}
			/**
			 * A constructor for ListNode that stores data and sets the references to the next
			 * ListNodes in the LinkedList.
			 * @param data the data being stored in the ListNode.
			 * @param prev the previous ListNode object in the LinkedList.
			 * @param next the next ListNode object in the LinkedList.
			 */
			public ListNode(E data, ListNode prev, ListNode next) {
				this.data = data;
				this.prev = prev;
				this.next = next;
			}
	}
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
