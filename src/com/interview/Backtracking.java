package com.interview;

public class Backtracking {

	/**
	 * ʹ�õݹ�ķ�ʽ��������
	 * @param n int �˵�����
	 * @return int
	 */
	private static int calculateAge(int n){
		//�ݹ�ĳ���
		if(n==1){
			//���һ���˵�����Ϊ10
			return 10;
		}
		return calculateAge(n-1)+2;
	}
	
	/**
	 * ����׳�
	 * @param n int 
	 * 				�׳˴����￪ʼ����
	 * @return int
	 * 				���ս׳˼�����
	 */
	private static int calculateFac(int n){
		//�ݹ�ĳ���
		if(n<0){
			return -1;
		}
		if(n==0){
			//�����1�Ľ׳ˣ�ֱ�ӷ���1
			return 1;
		}
		//����ǰֵ�Ľ׳˵��ڵ�ǰֵ����һ�����Ľ׳�
		return n*calculateFac(n-1);
	}
	
	/**
	 * ��ŵ�����⣬��A����n�����ӣ�����B�����ƶ���C����
	 * �������ߣ�
	 * ��һ�����������n-1�������ƶ���B
	 * �ڶ�������A������������ƶ���C
	 * ����������B������ʣ��������ƶ���D
	 * @param n int  
	 * 			��Ҫ�ƶ������ӵ�����
	 * @param A char
	 * 			����A
	 * @param B char
	 * 			����B
	 * @param C	char
	 * 			����C
	 */
	private static void hanoi(int n, char A, char B, char C){
		//�ݹ�ĳ���
		if(n==1){
			//���ֻ��Ҫ�ƶ�1�����ӣ���ôҪ���ľ��ǽ��������Ӵ�A�ƶ���C
			move(A, C);
			return ;
			//�����������1����ô���Ƚ�����С���ӽ���C�����ƶ���B���ӣ�
			//Ȼ���ƶ��������������ƶ���C����
			//����ٽ�B�����������е������ƶ���C������
		}else{
			hanoi(n-1, A, C, B);
			move(A, C);
			hanoi(n-1, B, A, C);
		}

	}
	
	/**
	 * �ƶ�����Ĵ�ӡ 
	 * @param A char 
	 * 			ĳ����	
	 * @param B char
	 * 			ĳ����
	 */
	private static void move(char A, char B){
		System.out.println(A+"--->"+B);
	}
	
	/**
	 * ��������ķ���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
//		int n=5;
//		int res=calculateAge(n);
//		System.out.println("���յ������ǣ�"+res);
		//����׳�
//		int res1=calculateFac(-1);
//		System.out.println(res1);
		//��ŵ��
		char a='A';
		char b='B';
		char c='C';
		hanoi(10, a, b, c);
	}

}
