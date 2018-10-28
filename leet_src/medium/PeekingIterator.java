package leet.medium;

import java.util.ArrayList;
import java.util.List;

import norm.Iterator;

/**
 * No.284 Peeking Iterator
 * Given an Iterator class interface with methods: next() and hasNext(), 
 * design and implement a PeekingIterator that support the peek() 
 * operation -- it essentially peek() at the element that will be 
 * returned by the next call to next().
 * 
 */
public class PeekingIterator implements Iterator<Integer>{

    private List<Integer> list;
    private int index;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    list = new ArrayList<Integer>();
	    while(iterator.hasNext()) {
	        list.add(iterator.next());
	    }
	    index = -1;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    return list.get(index + 1);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    index ++;
	    return list.get(index);
	}

	@Override
	public boolean hasNext() {
	    return index != list.size() - 1;
	}

}
