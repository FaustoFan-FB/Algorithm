package com.faustofan.lineartable.stack.limit_learn;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * @author: fausto
 * @date: 2021/6/8 21:39
 * @description: 一种表示定容字符串栈的抽象数据类型
 */
public class FixedCapacityStackOfStrings {
	private String[] a; //stack entries
	private int N;      //size
	
	/**
	 * @param cap: the capacity of stack
	 * @return: null
	 * @author: fausto
	 * @date: 2021/6/8 21:46
	 * @description: init the String stack
	 */

	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	
	public boolean isEmpty(){ return N==0; }
	
	public int size(){ return N; }
	
	public void push(String item){
		a[N++] = item;
	}
	
	public String pop(){
		return a[--N];
	}
	
	
}

class FixedCapacityStackOfStringsTest{
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
