package com.linkedlist;

public class SingleLinkedList<E> {

	private Node<E> head;

	private Node<E> last;

	private static class Node<E> {
		private E data;

		private Node<E> next;

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

	private void addLast(E element) {
		if (createHead(element)) {
			last = head;
		} else {
			Node<E> newNode = new Node<>(element);
			last.next = newNode;
			last = newNode;
		}
	}

	public void add(E element) {
		addLast(element);
	}

	public void addFirst(E element) {
		if (!createHead(element)) {
			Node<E> oldHead = head;
			Node<E> newNode = new Node<>(element);
			newNode.next = oldHead;
			head = newNode;
		}
	}

	private boolean isNotNull(Node<E> node) {
		return node != null;
	}

	public void reverse() {
		Node<E> current = head;
		Node<E> prev = null;
		Node<E> next = null;
		while (isNotNull(current)) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public boolean remove(E element) {
		boolean result = false;

		if (!isNotNull(head)) {
			return result;
		}

		if (head.data.equals(element)) {
			head = head.next;
			result = true;
		} 
		else {
			
			Node<E> current = head.next;
			Node<E> prev = head;
			Node<E> next = null;
			
			while (isNotNull(current)) {
				if (current.data.equals(element)) {
                    next = current.next;
                    current.next = null;
                    prev.next = next;
                    result = true;
                    break;
				}
				else
				{
					prev = current;
					current = current.next;
				}
			}
		}

		return result;
	}

	public void clear()
	{
		head = null;
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
		SingleLinkedList<Integer> sl = new SingleLinkedList<>();

		sl.addFirst(1);
		sl.addFirst(2);
		sl.addFirst(3);
		System.out.println(sl);

		sl.reverse();

		System.out.println(sl);
		
		sl.clear();
		
		System.out.println(sl);
		
		sl.add(1);
		sl.add(2);
		sl.add(3);
		sl.add(4);
		sl.add(5);
		sl.add(6);
		
		System.out.println(sl);
		
		sl.remove(1);
		
		System.out.println(sl);
		
	}
}
