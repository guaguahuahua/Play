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
	 * ���޸�ԭ���������½�������
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
	 * �����޸�ԭ�������飬ע�⣬ѭ���Ľ���λ��Ӧ����������м�㣬�����Ǳ����������顣
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
