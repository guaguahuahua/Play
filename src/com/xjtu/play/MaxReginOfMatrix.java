package com.xjtu.play;

public class MaxReginOfMatrix {
	
	public static int max(int x,int y){
		return x>y ? x : y;
	}
	/**
	 * �ϲ�������������Ϊһ����������
	 * @param a
	 * @param b
	 */
	public static void merge(int []a,int []b){
		int []c=new int[a.length+b.length];
		int ai=0,bi=0;
		int i=0;
		while(ai<a.length && bi<b.length){//ѭ��������Ԫ�ط��ںϲ������������
			if(a[ai]<b[bi]){
				c[i++]=a[ai++];
			}else{
				c[i++]=b[bi++];
			}
		}
		//���ϲ�ʣ�µ�Ԫ��д�뵽��������
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
