package com.xjtu.play;

import java.util.concurrent.SynchronousQueue;

public class MultipleMatrix {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a={{1,2,3},{0,4,5},{0,0,6}};
		int [][]b={{2,3,4},{0,5,6},{0,0,7}};
//		multiple(a,b);
		plus(a,b);
	}
	/**
	 * ����˷���ʵ��
	 * @param a
	 * @param b
	 */
	public static void multiple(int [][]a,int [][]b){
		int [][]array=new int[a.length][b[0].length];//�����������������������������
		for(int row=0;row<a.length;row++){

			for(int col=0;col<a[row].length;col++){
				//Ԫ�����
				int tmp=0;
				for(int i=0;i<a[row].length;i++){//������˲����
					tmp+=a[row][i]*b[i][col];
				}
				array[row][col]=tmp;
			}
		}
		//test para
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length;j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}
	/**
	 * �������,Ҫ����ͬ�;���
	 * @param a
	 * @param b
	 */
	public static void plus(int [][]a,int [][]b){
		int [][]array=new int[a.length][a[0].length];
		for(int row=0;row<a.length;row++){
			for(int col=0;col<a[row].length;col++){
				array[row][col]=a[row][col]+b[row][col];
			}
		}
		//test para
		for(int i=0;i<array.length;i++){
			
			for(int j=0;j<array[i].length;j++){
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
