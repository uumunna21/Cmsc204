//import java.util.*;
//
//public class BasicDoubleLinkedList<T> implements Iterable<T>{
//	protected Node head, tail;
//	protected int size;
//	
//	protected class Node{
//		T data;
//		Node next, prev;
//		
//		Node(T data)
//		{
//			this.data = data;
//			next = prev = null;
//		}
//	}
//	
//	public BasicDoubleLinkedList() {
//		head = tail = null;
//		size = 0;
//	}
//	
//	public void addToFront(T data)
//	{
//		Node newNode = new Node(data);
//		if (size == 0)
//		{
//			head = tail = newNode;
//		}
//		else {
//			newNode.next = head;
//			head.prev = newNode;
//			head = newNode;
//		}
//		size++;
//	}
//	
//	public void addToEnd(T data) {
//		Node newNode = new Node(data);
//		if(size == 0)
//		{
//			head = tail = newNode;
//		}
//		else {
//			newNode.prev = tail;
//			tail.next = newNode;
//			tail = newNode;
//		}
//		size++;
//		
//	}
//	
//	public T getFirst()
//	{
//		if(size == 0) 
//			return null;
//		return head.data;
//	}
//	
//	public T getLast()
//	{
//		if(size == 0)
//			return null;
//		return tail.data;
//	}
//	
//	public int getSize()
//	{
//		return size;
//	}
//	
//	public BasicDoubleLinkedList<T>.Node remove(T targetData, java.util.Comparator<T> comparator) {
//	    Node current = head;
//
//	    // Traverse the list to find the node that matches targetData
//	    while (current != null) {
//	        if (comparator.compare(current.data, targetData) == 0) { // Match found
//	            if (current == head) { // Removing the head
//	                head = head.next;
//	                if (head != null) {
//	                    head.prev = null;
//	                } else { // If list becomes empty
//	                    tail = null;
//	                }
//	            } else if (current == tail) { // Removing the tail
//	                tail = tail.prev;
//	                tail.next = null;
//	            } else { // Removing a middle node
//	                current.prev.next = current.next;
//	                current.next.prev = current.prev;
//	            }
//	            size--; // Decrease size
//	            return current; // Return the removed node
//	        }
//	        current = current.next;
//	    }
//	    return null; // Target not found
//	}
//
//	
//	public T retrieveFirstElement()
//	{
//		if(size == 0)
//			return null;
//		T data = head.data;
//		head = head.next;
//		if(head != null)
//			head.prev = null;
//		else
//			tail = null;
//		size--;
//		return data;
//	}
//	
//	public T retrieveLastElement()
//	{
//		if(size == 0)
//			return null;
//		T data = tail.data;
//		tail = tail.prev;
//		if(tail != null)
//			tail.next = null;
//		else
//			head = null;
//		size--;
//		return data;
//	}
//	
//	public ArrayList<T> toArrayList()
//	{
//		ArrayList<T> list = new ArrayList<>();
//		Node current = head;
//		while(current != null)
//		{
//			list.add(current.data);
//			current = current.next;
//		}
//		return list;
//	}
//	
//	
//	@Override
//	public ListIterator<T> iterator() {
//		return new DoubleLinkedListIterator();
//	}
//	
//	private class DoubleLinkedListIterator implements ListIterator<T> {
//      private Node current;
//      private boolean forward;
//
//      public DoubleLinkedListIterator() {
//          this.current = null; // Before first element
//          this.forward = true;
//      }
//
//      @Override
//      public boolean hasNext() {
//          return (current == null && head != null) || (current != null && current.next != null);
//      }
//
//      @Override
//      public T next() {
//          if (!hasNext()) throw new NoSuchElementException();
//          if (current == null) { 
//              current = head;
//          } else {
//              current = current.next;
//          }
//          forward = true;
//          return current.data;
//      }
//
//      @Override
//      public boolean hasPrevious() {
//          return (current != null && current.prev != null) || (current == null && tail != null);
//      }
//
//      @Override
//      public T previous() {
//          if (!hasPrevious()) throw new NoSuchElementException();
//          if (current == null) { 
//              current = tail;
//          } else {
//              current = current.prev;
//          }
//          forward = false;
//          return current.data;
//      }
//
//      @Override
//      public void remove() {
//          throw new UnsupportedOperationException();
//      }
//
//      @Override
//      public void set(T e) {
//          throw new UnsupportedOperationException();
//      }
//
//      @Override
//      public void add(T e) {
//          throw new UnsupportedOperationException();
//      }
//
//		@Override
//		public int nextIndex() {
//			throw new UnsupportedOperationException();
//		}
//
//		@Override
//		public int previousIndex() {
//			throw new UnsupportedOperationException();
//		}
//  }
//	
//}

import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
    protected Node head, tail;
    protected int size;

    protected class Node {
        T data;
        Node prev, next;

        Node(T data) {
            this.data = data;
            prev = next = null;
        }
    }

    public BasicDoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addToFront(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        tail.next = head; // ✅ Make it circular
        head.prev = tail; // ✅ Maintain correct backward reference
        size++;
    }

    public void addToEnd(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head; // ✅ Make it circular
        head.prev = tail; // ✅ Maintain correct backward reference
        size++;
    }

    public T getFirst() {
        return (head == null) ? null : head.data;
    }

    public T getLast() {
        return (tail == null) ? null : tail.data;
    }

    public T retrieveFirstElement() {
        if (size == 0) return null;
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = tail;
        else tail = null;
        tail.next = head; // ✅ Maintain circular list
        size--;
        return data;
    }

    public T retrieveLastElement() {
        if (size == 0) return null;
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) tail.next = head;
        else head = null;
        head.prev = tail; // ✅ Maintain circular list
        size--;
        return data;
    }
    
    public BasicDoubleLinkedList<T>.Node remove(T targetData, java.util.Comparator<T> comparator) {
	    Node current = head;

	    // Traverse the list to find the node that matches targetData
	    while (current != null) {
	        if (comparator.compare(current.data, targetData) == 0) { // Match found
	            if (current == head) { // Removing the head
	                head = head.next;
	                if (head != null) {
	                    head.prev = null;
	                } else { // If list becomes empty
	                    tail = null;
	                }
	            } else if (current == tail) { // Removing the tail
	                tail = tail.prev;
	                tail.next = null;
	            } else { // Removing a middle node
	                current.prev.next = current.next;
	                current.next.prev = current.prev;
	            }
	            size--; // Decrease size
	            return current; // Return the removed node
	        }
	        current = current.next;
	    }
	    return null; // Target not found
	}

    public ArrayList<T> toArrayList() {
        ArrayList<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
            if (current == head) break; // Stop at circular point
        }
        return list;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements ListIterator<T> {
        private Node current;
        private boolean forward;

        public DoubleLinkedListIterator() {
            this.current = null; // Before first element
            this.forward = true;
        }

        @Override
        public boolean hasNext() {
            return (current == null && head != null) || (current != null && current.next != head);
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            if (current == null) { 
                current = head;
            } else {
                current = current.next;
            }
            forward = true;
            return current.data;
        }

        @Override
        public boolean hasPrevious() {
            //return (current != null && current.prev != tail) || (current == null && tail != null);
        	return (current != head && current.prev != null);
        }

        @Override
        public T previous() {
        	T data = null;
        	
            if (!hasPrevious()) throw new NoSuchElementException();
            if (current == null) { 
                current = head;
            } else {
                this.current = this.current;
            }
            forward = false;
            data = current.data;
            current = current.prev;
            return data;
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

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
    }

    public int getSize() {
        return size;
    }
}



