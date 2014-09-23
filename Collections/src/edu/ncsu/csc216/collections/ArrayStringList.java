package edu.ncsu.csc216.collections;
import java.util.AbstractList;

public class ArrayStringList extends java.util.AbstractList<String> {
	private String[] list;
	private int size;
	
	/**
	 * Default constructor of ArrayStringList class
	 */
	public ArrayStringList() {
		list = new String[10];
		size = 0;
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, String contents) {
		if(!list[index].isEmpty()) {
			for(int i = size; i > index; i--) {
				try{
					list[i] = list[i+1];
				} catch(IndexOutOfBoundsException e) {
					size = size * 2;
					list[i] = list[i+1];
				}
				
			}
		}
		list[index] = contents;
	}

	/**
	 * Returns the contents of an element at a location in the list
	 * @param int index the location of the element in the list
	 * @return s the contents of the element at the specified index
	 */
	@Override
	public String get(int index) {
		String s = "";
		try{
		 s = list[index];
		}catch(NullPointerException e) {
			s ="";
		}
		return s;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#remove(int)
	 */
	@Override
	public String remove(int arg0) {
		// TODO Auto-generated method stub
		return super.remove(arg0);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractList#set(int, java.lang.Object)
	 */
	@Override
	public String set(int arg0, String arg1) {
		// TODO Auto-generated method stub
		return super.set(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return size;
	}

}
