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
	private ListNode front;
	private ListNode back;
	private int size;
	
	public LinkedList() {
		this.front = new ListNode(null, null, this.back);
		this.back = new ListNode(null, this.front, null);
		this.size = 0;
	}
	
	
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
		return new LinkedListIterator(index);
	}

	@Override
	public int size() {
		return size;
	}
	private class LinkedListIterator implements ListIterator<E> {
		
		public LinkedListIterator() {
			
		}
		
		public LinkedListIterator(int index) {
			
		}
		
		@Override
		public void add(E arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
