package com.faustofan.algo;

/**
 * @author: fausto
 * @date: 2021/6/10 20:26
 * @description:
 */
public interface UF {

	int count();
	
	default  boolean connected(int p , int q){
		return find(p) == find(q);
	}
	
	int find(int p);
	
	void union(int p,int q);
	
}
