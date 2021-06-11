package com.faustofan.lineartable.stack;

import java.util.Iterator;

/**
 * @author: fausto
 * @date: 2021/6/9 20:54
 * @description:
 */
public class ResizingArrayStack <Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1]; //初始化栈且该栈容量为1
	private int N = 0;  //栈内元素数量
	
	public boolean isEmpty(){ return N==0; }
	public int size(){ return N; }
	
	private void resize(int max){
		//将栈移动到一个大小为max的新数组
		Item[] temp= (Item[]) new Object[max];
		for(int i=0;i<N;i++){
			temp[i]=a[i];
		}
		a=temp;
	}
	
	public void push(Item item){
		if(N==a.length){
			//若栈满则将栈扩容
			resize(2*a.length);
		}
		a[N++]=item;
	}
	
	public Item pop(){
		Item item=a[--N];
		a[N]=null; //避免对象游离,使其成为空引用触发gc
		if(N>0 && N==a.length/4){
			//若栈有近3/4空间未使用,则将栈减容
			resize(a.length/2);
		}
		return item;
	}
	
	/**
	 * @return: null
	 * @author: fausto
	 * @date: 2021/6/9 21:17
	 * @description: 实现迭代
	 */
	public Iterator<Item> iterator(){
		 return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		//支持后进先出的迭代
		private int i = N;
		@Override
		public boolean hasNext(){
			//i指针指向栈顶元素上一个位置
			return i>0;
		}
		@Override
		public Item next(){
			return a[--i];
		}
		
		public void remove(){}
	}
}

























