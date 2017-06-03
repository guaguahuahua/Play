package com.xjtu.play;

public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		towers(4,'A','C','B');
	}
	/**
	 * @param n ����n��ʾ���ӵı�ţ����Խ����ô����ͷԽ�󣬷��õ�λ��Ҳ��Խ��������
	 * @param fromPeg	��ǰ����
	 * @param toPeg		Ŀ������
	 * @param auxPeg	��ʱ�ѷŵ�����
	 */
	static void towers(int n, char fromPeg, char toPeg, char auxPeg){
		//�ݹ����
		if(n==1){
			System.out.println("move disk 1"+" from peg "+fromPeg+" to peg "+toPeg);
			return ;
		}
		//��n-1�����Ӵ�fromPeg����toPegת����auxPeg������ǰ��������n-1�����ƶ�����ʱ�ѷŵ�����
		towers(n-1,fromPeg,auxPeg,toPeg);
		//�����������������Ϊ�ƶ����������Ǹ����ӵĶ������������Ǹ����ӷ��õ�Ŀ��������
		System.out.println("move disk "+n+" from peg "+fromPeg+" to peg "+toPeg);
		//��n-1�����ӽ���auxPeg�ƶ���toPeg��������ʱ����������n-1�����ӣ�Ҫ�����ǽ�n-1�����ӷ��õ�Ŀ�����ӣ��������ڽ������n-2������
		//��ʱ�Ƶ���ʼ������ȥ��
		towers(n-1,auxPeg,fromPeg,toPeg);
	}
}
