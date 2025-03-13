//import java.util.*;
//
//public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
//	private Comparator<T> comparator;
//	
//	public SortedDoubleLinkedList(Comparator<T> comparator)
//	{
//		super();
//		
//		this.comparator = comparator;
//	}
//	
//	public void add(T data)
//	{
//		Node newNode = new Node(data);
//		if (size == 0)
//			head = tail = newNode;
//		else if (comparator.compare(data, head.data) <= 0)
//		{
//			newNode.next = head;
//			head.prev = newNode;
//			head = newNode;
//		}
//		else if(comparator.compare(data, head.data) >= 0)
//		{
//			newNode.prev = tail;
//			tail.next = newNode;
//			tail = newNode;
//		}
//		else
//		{
//			Node current = head;
//			while(current != null && comparator.compare(data, current.data) > 0)
//			{
//				current = current.next;
//			}
//			newNode.prev = current.prev;
//			newNode.next = current;
//            current.prev.next = newNode;
//            current.prev = newNode;
//		}
//		size++;
//	}
//	
//	@Override
//    public void addToFront(T data) {
//        throw new UnsupportedOperationException("Invalid operation for sorted list");
//    }
//
//    @Override
//    public void addToEnd(T data) {
//        throw new UnsupportedOperationException("Invalid operation for sorted list");
//    }
//}

import java.util.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> {
    private Node head, tail;
    private int size;
    private Comparator<T> comparator;

    private class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
        }
    }

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
        this.size = 0;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) { // Empty list
            head = tail = newNode;
        } else if (comparator.compare(data, head.data) <= 0) { // Insert at the front
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (comparator.compare(data, tail.data) >= 0) { // Insert at the end
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else { // Insert in the middle
            Node current = head;
            while (current != null && comparator.compare(data, current.data) > 0) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    public int getSize() {
        return size;
    }

    public T retrieveFirstElement() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null; // List became empty
        size--;
        return data;
    }

    public T retrieveLastElement() {
        if (tail == null) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null; // List became empty
        size--;
        return data;
    }

    public ListIterator<T> iterator() {
        return new SortedListIterator();
    }

    private class SortedListIterator implements ListIterator<T> {
        private Node current = head;
        private Node lastReturned = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastReturned = current;
            current = current.next;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            return (current != null && current.prev != null) || (current == null && tail != null);
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (current == null) { // Iterator is past the end
                current = tail;
            } else {
                current = current.prev;
            }
            lastReturned = current;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();
        }
    }

    public void remove(T targetData, Comparator<T> comparator) {
        Node current = head;
        while (current != null) {
            if (comparator.compare(current.data, targetData) == 0) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public ArrayList<String> toArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            arrayList.add((String) current.data);
            current = current.next;
        }
        return arrayList;
    }
    
   public void addToEnd(T data) {
       throw new UnsupportedOperationException("Invalid operation for sorted list");
   }
   
   public void addToFront(T data) {
      throw new UnsupportedOperationException("Invalid operation for sorted list");
   }
}
