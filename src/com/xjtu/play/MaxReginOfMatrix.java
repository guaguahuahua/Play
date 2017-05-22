package com.xjtu.play;

public class MaxReginOfMatrix {
	
	public static int max(int x,int y){
		return x>y ? x : y;
	}
	/**
	 * 合并两个有序数组为一个有序数组
	 * @param a
	 * @param b
	 */
	public static void merge(int []a,int []b){
		int []c=new int[a.length+b.length];
		int ai=0,bi=0;
		int i=0;
		while(ai<a.length && bi<b.length){//循环遍历将元素放在合并后的新数组中
			if(a[ai]<b[bi]){
				c[i++]=a[ai++];
			}else{
				c[i++]=b[bi++];
			}
		}
		//将合并剩下的元素写入到新数组中
		while(ai<a.length){
			c[i++]=a[ai++];
		}
		while(bi<b.length){
			c[i++]=b[bi++];
		}
		//test para
		for(int K:c){
			System.out.print(K+"\t");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={2,3,5,7,8};
		int []b={1,4,6,9,10};
		merge(a,b);
	}

}
