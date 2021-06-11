package com.faustofan.lineartable.stack.limit_learn;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: fausto
 * @date: 2021/6/8 22:32
 * @description:
 */
public class FixedCapacityStack <Item>{
	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		a[N++]=item;
	}
	
	public Item pop(){
		return a[--N];
	}
}

class FixedCapacityStackTest{
	public static void main(String[] args) {
		FixedCapacityStackOfStrings stack;
		stack = new FixedCapacityStackOfStrings(100);
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if ((!item.equals("-"))){
				stack.push(item);
			}else if(!stack.isEmpty()){
				StdOut.print(stack.pop()+"");
			}
		}
		StdOut.println("("+stack.size()+" left on stack");
	}
}
