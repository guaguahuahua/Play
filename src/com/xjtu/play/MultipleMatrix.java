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
	 * 矩阵乘法的实现
	 * @param a
	 * @param b
	 */
	public static void multiple(int [][]a,int [][]b){
		int [][]array=new int[a.length][b[0].length];//根据输入矩阵获得输出矩阵的行数列数
		for(int row=0;row<a.length;row++){

			for(int col=0;col<a[row].length;col++){
				//元素相乘
				int tmp=0;
				for(int i=0;i<a[row].length;i++){//行列相乘并求和
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
	 * 矩阵求和,要求是同型矩阵
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
