package com.bridgelabz.oops;

public class Queue1<T> {
	
private Node1<T> front,rear;
private int size;
public Queue1()
{
	front=null;
	rear=null;
	size=0;
	}
public boolean isQueueEmpty() {
	return front==null;
	
}
public int getSize()
{
	return size;
	}
public void insert(T data)
{
	Node1<T> node=new Node1<>(data,null);
	if(rear==null){
		front=node;
		rear=node;
}
	else
	{
		rear.setNext(node);
		rear=rear.getNext();
	}
	size++;
	}
public T remove()
{
	if(isQueueEmpty())
	
		System.out.println("Underflow");
		Node1<T> curr=front;
		front = curr.getNext();        
        if (front == null){
            rear =null;
			size-- ; 
			
 
        } 
        return curr.getData();
}
	public void display()
	{
		if(isQueueEmpty())
		{
			System.out.println("quary is empty");
			return ;
		}
	
	else
	{
		Node1<T> tNode=front;
		while(tNode!=null){
			System.out.print(tNode.getData()+" ");
            tNode=tNode.getNext();
	}
	}

}
	}
