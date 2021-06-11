package com.faustofan.algo.impl;

import com.faustofan.algo.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: fausto
 * @date: 2021/6/10 20:44
 * @description:
 */
public class QuickFind implements UF {
	private int[] id; //分量id(以触点作为索引)
	private int count; //分量数量
	
	public QuickFind(int N){
		count = N;
		id = new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
	}
	
	@Override
	public int count() {
		return count;
	}
	
	@Override
	public int find(int p) {
		return id[p];
	}
	
	@Override
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID == qID) return;
		for(int i=0;i<id.length;i++){
			if(id[i] == pID) id[i] = qID;
		}
		count--;
	}
}

class QuickFind_Test{
	public static void main(String[] args) {
		int N = StdIn.readInt(); //读取触点数量
		UF uf = new QuickFind(N); //初始化N个分量
		
		while (!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt(); //读取整数对
			
			if (uf.connected(p,q)) continue; //若已经连通则忽略
			uf.union(p,q); //归并分量
			StdOut.println(p + " " + q); //打印连接
		}
		StdOut.println(uf.count() + "components");
	}
}
