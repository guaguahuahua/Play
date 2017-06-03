package com.xjtu.play;

public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=54;
//		recursion(n);
		int r=combination(5,3);
		System.out.println("result:"+r);
	}
	/**
	 * 一个递归的练习
	 * @param n
	 */
	public static void recursion(int n){
		if(n==0){//出口
			return ;
		}
		for(int i=0;i<n;i++){
			System.out.print(n+" ");
		}
		System.out.print("\n");
		recursion(n-1);
	}
	/**
	 * 组合数的计算，通过递归的方式完成，因为再合适的条件下都是可以
	 * 一个组合数拆分成为两个组合数求和的形式。
	 * @param n
	 * @param k
	 * @return
	 */
	public static int combination(int n,int k){
		//递归出口
		if(k==0){
			return 1;
		}
		if(n==k){
			return 1;
		}
		return combination(n-1,k-1)+combination(n-1,k);
	}
}
