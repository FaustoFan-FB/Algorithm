package com.faustofan.linklist.stack;

import java.util.Iterator;

/**
 * @author: fausto
 * @date: 2021/6/9 22:25
 * @description:
 */
public class Stack<Item> implements Iterable<Item> {
	private Node first; // 栈顶结点&&头节点
	private int N; //结点(元素)数量
	
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
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{
		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
}





















