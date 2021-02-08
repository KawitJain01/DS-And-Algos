package com.linkedlist;

public class DoubleLinkedList<E> {

	private Node<E> head;
	
	private Node<E> last;
	
	private int length;
	
	private static class Node<E> {
		private E data;

		private Node<E> next;
		private Node<E> prev;

		Node(E data) {
			this.data = data;
		}
	}
	
	private boolean createHead(E element) {
		if (head == null) {
			head = new Node<>(element);
			return true;
		}
		return false;
	}
	
	public void add(E element)
	{
		addLast(element);
		length++;
	}
	
	private void addLast(E element)
	{
		if (createHead(element)) {
			last = head;
		} else {
			Node<E> newNode = new Node<>(element);
			newNode.prev = last;
			newNode.next = null;
			last.next = newNode;
			last = newNode;
		}
	}
	
	public void addFirst(E element)
	{
		if (!createHead(element)) {
			Node<E> oldHead = head;
			Node<E> newNode = new Node<>(element);
			newNode.next = oldHead;
			head.prev = newNode;
			head = newNode;
			length++;
		}
	}
	
	private boolean isNotNull(Node<E> node) {
		return node != null;
	}
	
	public void clear() {
		head = null;
		length = 0;
	}
	
	public boolean remove(E element)
	{
		boolean result = false;

		if (!isNotNull(head)) {
			return result;
		}

		if (head.data.equals(element)) {
			head = head.next;
			head.prev = null;
			length--;
			result = true;
		} else {

			Node<E> current = head.next;
			Node<E> prev = current.prev;
			Node<E> next = null;

			while (isNotNull(current)) {
				if (current.data.equals(element)) {
					next = current.next;
					current.next = null;
					current.prev = null;
					if (next != null) {
						next.prev = prev;
					}
					prev.next = next;
					result = true;
					length--;
					break;
				} else {
					prev = current;
					current = current.next;
				}
			}
		}

		return result;
	}
	
	public E getElementFromLast(int elementNo) {
		return elementNo > length ? null : get( length - elementNo );
	}

	public E getElementFromFirst(int elementNo) {
		return get( elementNo - 1 );
	}

	private E get(int no) {
		if (head == null) {
			return null;
		}

		Node<E> current = head;

		for (int i = 1; i <= no; i++) {
			current = current.next;
		}
		return current != null ? current.data : null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> current = head;
		while (isNotNull(current)) {
			sb.append(current.data);
			current = current.next;
			if (isNotNull(current))
				sb.append("->");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();
		
		dl.add(1);
		dl.add(2);
		dl.add(3);
		
		System.out.println(dl);
		
		System.out.println(dl.getElementFromFirst(2));
		
		System.out.println(dl.getElementFromLast(3));
		
		dl.remove(2);
		
		dl.remove(3);
		
		System.out.println(dl);
		
		dl.clear();
		
		dl.addFirst(1);
		dl.addFirst(2);
		dl.addFirst(3);
		
		System.out.println(dl);
		
		dl.remove(2);
		
		System.out.println(dl);
	}
}
