package com.faustofan.linklist.queue;

import java.util.Iterator;

/**
 * @author: fausto
 * @date: 2021/6/10 12:27
 * @description:
 */
public class Queue<Item> implements Iterable<Item>{
	private Node first; //最早添加的结点
	private Node last; //最晚添加的结点
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		N++;
	}
	
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		N--;
		return item;
	}
	
	public Iterator iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext(){
			return current != null;
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}















