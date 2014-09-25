package edu.ncsu.csc216.collections;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author SarahHeckman
 *
 */
public class ArrayStringListTest {

	private ArrayStringList list;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayStringList();
	}

	/**
	 * Tests that a ArrayStringList is constructed correctly. A ArrayStringList
	 * of any generic type should be not null and empty, which implies a size of
	 * 0. Test method for
	 * {@link edu.ncsu.csc216.collections.ArrayStringList#ArrayStringList()}.
	 */
	@Test
	public void testArrayStringList() {
		assertEquals(0, list.size());

	}

	/**
	 * Tests adding elements to an empty ArrayStringList. Then tests adding
	 * elements to the front, middle, and back of a ArrayStringList. The size
	 * and contents should be checked after each insertion. Additionally, the
	 * bounds of the list should be checked and null elements should not be
	 * added to the list. Finally, test that the ArrayList with an initial
	 * capacity of 10 grows when an 11th element is added. Test method for
	 * {@link edu.ncsu.csc216.collections.ArrayStringList#add(int, java.lang.Object)}
	 * .
	 */
	@Test
	public void testAdd() {
		// Attempt to add an element to index 1 in an empty list.
		// Check that the element was not added.
		try {
			list.add(1, "apple");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Add element to empty list
		list.add(0, "apple");
		assertEquals(1, list.size());
		assertEquals("apple", list.get(0));

		// Add element to the front of a list
		list.add(0, "banana");
		assertEquals(2, list.size());
		assertEquals("banana", list.get(0));

		// Add element to the middle of a list
		list.add(1, "cherry");
		assertEquals(3, list.size());
		assertEquals("cherry", list.get(1));

		// Add element to the back of a list
		list.add("tomato");
		assertEquals(4, list.size());
		assertEquals("tomato", list.get(3));

		// Attempt to add a null element. Check that the element
		// was not added.
		try {
			list.add(null);
		} catch (NullPointerException e) {
			assertEquals(4, list.size());

		}

		// Attempt to add at index -1. Check that the element was not
		// added.
		try {
			list.add(-1, "Corn");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Attempt to add at index 5 (since there are 4 elements in the list).
		// Check that the element was not added.
		try {
			list.add(5, "Corn");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Test adding an 11th element to an ArrayList with an initial
		// capacity of 10.
		ArrayStringList list2 = new ArrayStringList();
		for (int i = 0; i < 10; i++) {
			list2.add("");
		}
		try {
			list2.add(11, "Corn");
		} catch (IndexOutOfBoundsException e) {
			assertEquals(20, list2.size());
		}
		
		try {
			list.add(3, "Corn");
			assertEquals("tomato", list.get(5));
		} catch (IndexOutOfBoundsException e ){
			
		}
		

		

	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and
	 * back of an ArrayList. Removing the last element should leave an empty
	 * list. The bounds are checked for the appropriate exceptions. Test method
	 * for {@link edu.ncsu.csc216.collections.ArrayStringList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		// Attempt to remove an element from an empty list
		try {
			list.remove(1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Add 4 elements to the list and test that the contents are correct.
		// Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// a negative index. Make sure the list is unchanged.
		try {
			list.remove(-1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Test that IndexOutOfBoundsException is thrown when remove() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			list.remove(4);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Remove middle element. Test that the removed element is correct and
		// that the remaining list is correct after the removal.
		String s1 = list.remove(1);
		assertEquals(s1, "banana");
		assertEquals(3, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("apple", list.get(1));
		assertEquals("kiwi", list.get(2));

		// Remove first element
		String s2 = list.remove(0);
		assertEquals(s2, "orange");
		assertEquals(2, list.size());
		assertEquals("apple", list.get(0));
		assertEquals("kiwi", list.get(1));

		// Remove last element
		String s3 = list.remove(1);
		assertEquals(s3, "kiwi");
		assertEquals(1, list.size());
		assertEquals("apple", list.get(0));

		// Remove only element
		String s4 = list.remove(0);
		assertEquals(s4, "apple");
		assertEquals(0, list.size());
	}

	/**
	 * Tests setting an element in an empty list, the bounds of the list when
	 * using the set() method, and setting an element at the front, middle, and
	 * back of the list. The set() method is also passed null. Test method for
	 * {@link edu.ncsu.csc216.collections.ArrayStringList#set(int, java.lang.Object)}
	 * .
	 */
	@Test
	public void testSetIntE() {
		// Attempt to set a value in an empty list
		try {
			list.set(0, "Strawberry");

		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}

		// Add 4 elements to the list and test that the contents are correct.
		// Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));

		// Test that IndexOutOfBoundsException is thrown when set() is passed
		// a negative index. Make sure the list is unchanged.
		try {
			list.set(-1, "Strawberry");

		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Test that IndexOutOfBoundsException is thrown when set() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			list.set(4, "Strawberry");

		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// Set middle element. Test that the element is modified correctly,
		// set() returns the
		// right value, and that the rest of the list is correct.
		String s1 = list.set(1, "strawberry");
		assertEquals(s1, "banana");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));

		// Set first element
		String s2 = list.set(0, "strawberry");
		assertEquals(s2, "orange");
		assertEquals(4, list.size());
		assertEquals("strawberry", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));

		// Set last element
		String s3 = list.set(3, "strawberry");
		assertEquals(s3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("strawberry", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("strawberry", list.get(3));

		// Attempt to set an element to null. Check that the element
		// was not modified.
		try {
			list.set(2, null);
		} catch (NullPointerException e) {
			assertEquals("apple", list.get(2));
		}

	}

	/**
	 * Main get() functionality is tested in the other test methods. This method
	 * will focus on testing the exceptions associated with bounds. Test method
	 * for {@link edu.ncsu.csc216.collections.ArrayStringList#get(int)}.
	 */
	@Test
	public void testGet() {
		// Add 4 elements to the list and test that the contents are correct.
		// Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));

		// Test that IndexOutOfBoundsException is thrown when get() is passed
		// a negative index. Make sure the list is unchanged.

		try {
			list.get(-1);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("orange", list.get(0));
			assertEquals("banana", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("kiwi", list.get(3));
		}

		// Test that IndexOutOfBoundsException is thrown when get() is passed
		// an index > size() - 1. Make sure the list is unchanged.
		try {
			list.get(4);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
			assertEquals("orange", list.get(0));
			assertEquals("banana", list.get(1));
			assertEquals("apple", list.get(2));
			assertEquals("kiwi", list.get(3));
		}
	}

}
