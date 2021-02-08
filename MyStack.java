package com.ds.stack;

import java.util.EmptyStackException;

public class MyStack<E> {

	private E[] data;
	
	private int top;
	
	private int size;
	
	public MyStack(int size)
	{
		this.size = size;
		data = (E[])new Object[size];
	}
	
	public void push(E element)
	{
		if(top == size )
		{
			throw new StackOverFlowException();
		}
	    data[top++] = element;	
	}
	
	public E pop()
	{
		isStackEmpty();
		return data[--top];
	}

	private void isStackEmpty() {
		if(top == 0)
		{
			throw new EmptyStackException();
		}
	}
	
	public E top()
	{
		return data[top - 1];
	}
	
	private static class StackOverFlowException extends RuntimeException
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = -1466284117267566955L;
		
	}
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>(3);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.top);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
