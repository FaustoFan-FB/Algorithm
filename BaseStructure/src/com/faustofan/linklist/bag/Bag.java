package com.faustofan.linklist.bag;

import java.util.Iterator;

/**
 * @author: fausto
 * @date: 2021/6/9 21:59
 * @description: 只能添加元素
 */
public class Bag <Item> implements Iterable<Item>{
	private Node first; //链表的首结点
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void add(Item item){
		//和Stack的push()方法完全相同
		Node oldFirst = first; //复制头指针
		first = new Node(); //使新节点成为头节点
		first.item = item; //初始化头节点数据域
		first.next = oldFirst; //初始化头节点指针域,指向老节点,形成链表
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements  Iterator<Item>{
		private Node current = first; //指向头结点的指针
		public boolean hasNext(){
			return current != null;
		}
		public Item next(){
			Item item = current.item;
			current = current.next; //指针指向下一个结点
			return item;
		}
	}
	
}
