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
	 * һ���ݹ����ϰ
	 * @param n
	 */
	public static void recursion(int n){
		if(n==0){//����
			return ;
		}
		for(int i=0;i<n;i++){
			System.out.print(n+" ");
		}
		System.out.print("\n");
		recursion(n-1);
	}
	/**
	 * ������ļ��㣬ͨ���ݹ�ķ�ʽ��ɣ���Ϊ�ٺ��ʵ������¶��ǿ���
	 * һ���������ֳ�Ϊ�����������͵���ʽ��
	 * @param n
	 * @param k
	 * @return
	 */
	public static int combination(int n,int k){
		//�ݹ����
		if(k==0){
			return 1;
		}
		if(n==k){
			return 1;
		}
		return combination(n-1,k-1)+combination(n-1,k);
	}
}
