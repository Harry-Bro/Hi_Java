package datastructure.queue.ex1;

import java.util.NoSuchElementException;

class Queue<T> {
	
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void enQueue(T item) {
		Node<T> t = new Node<>(item);
		
		if(last != null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public T deQueue() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		
		return data;
	}
	
}

public class Test {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		q.enQueue(1);
		System.out.println(q.deQueue());

	}
	
}
