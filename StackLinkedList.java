package com.bridgelabz.oops;

import java.util.NoSuchElementException;

public class StackLinkedList<T> {
private Node1<T> top;
	
	/*
	 * size is of the type integer and is 
	 * declared private to achieve encapsulation 
	 */
	private int size;
	
	/**
	 * Constructor to initialize the instance variables of 
	 * class StackLinkedList
	 */
	public StackLinkedList(){
		top=null;
		size=0;
	}
	
	/**
	 * Function to check if the stack is empty or not
	 * 
	 * @return true if empty else false
	 */
	public boolean isEmpty(){
		return top==null;
	}
	
	
	/**
	 * Function to get the size of the stack
	 * 
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Function to push the specified element in the stack
	 * 
	 * @param data the element to be pushed into the stack
	 */
	public void push(T data){
		Node1<T> tnode=new Node1<T>(data,null);
		if(top==null)
			top=tnode;
		else{
			
			//Function call to set the link present in Node class 
			//of com.bridgelabz.datastructureprograms
			 tnode.setNext(top);
	         top = tnode;
		}
		size++;
	}
	
	/**
	 * Function to pop the element from stack
	 * 
	 * @return the deleted element 
	 */
	public T pop(){
		if(isEmpty()){
			System.out.println("No elements");
			return null;
		}
		Node1<T> tnode=top;
		
		//Function call to get the link present in Node class 
		//of com.bridgelabz.datastructureprograms
		top=tnode.getNext();
		
		size--;
		
		//Function call to get the data present in Node class 
		//of com.bridgelabz.datastructureprograms
		return tnode.getData();
	}
	
	/**
	 * Function to fetch the top element of the stack 
	 * 
	 * @return the element at the top
 	 */
	public T peek(){
		if (isEmpty() )
			throw new NoSuchElementException("Underflow Exception") ;
		return top.getData();
} 
	void printStack(StackLinkedList<Object> s)
	{
		if(s.isEmpty())
		{
			return;
		}
		Object item=s.pop();
		System.out.println(item);
		printStack(s);
	}

}
