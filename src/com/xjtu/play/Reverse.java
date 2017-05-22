package com.xjtu.play;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []pre={1,2,3,4,5,6,7};
		int []post=new int[pre.length];
//		reverse(pre,post);
		reverse(pre);
	}
	/**
	 * 不修改原数组的情况下进行逆置
	 * @param pre
	 * @param post
	 */
	public static void reverse_1(int []pre,int []post){
		for(int i=0,j=pre.length-1;i<pre.length;i++,j--){
			post[i]=pre[j];
		}
		//test para;
		for(int K:post){
			System.out.print(K+"\t");
		}
	}
	/**
	 * 可以修改原来的数组，注意，循环的结束位置应该是数组的中间点，而不是遍历整个数组。
	 * @param pre
	 */
	public static void reverse(int []pre){
		for(int i=0;i<=pre.length/2;i++){
			int tmp=pre[i];
			pre[i]=pre[pre.length-1-i];
			pre[pre.length-1-i]=tmp;
		}
		//test para
		for(int K:pre){
			System.out.print(K+"\t");
		}
	}
}
