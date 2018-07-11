package com.interview;

public class Backtracking {

	/**
	 * 使用递归的方式计算年龄
	 * @param n int 人的数量
	 * @return int
	 */
	private static int calculateAge(int n){
		//递归的出口
		if(n==1){
			//最后一个人的年龄为10
			return 10;
		}
		return calculateAge(n-1)+2;
	}
	
	/**
	 * 计算阶乘
	 * @param n int 
	 * 				阶乘从哪里开始计算
	 * @return int
	 * 				最终阶乘计算结果
	 */
	private static int calculateFac(int n){
		//递归的出口
		if(n<0){
			return -1;
		}
		if(n==0){
			//如果是1的阶乘，直接返回1
			return 1;
		}
		//否则当前值的阶乘等于当前值和上一个数的阶乘
		return n*calculateFac(n-1);
	}
	
	/**
	 * 汉诺塔问题，将A柱的n个盘子，借助B柱子移动到C柱子
	 * 分三步走，
	 * 第一步，将上面的n-1个盘子移动到B
	 * 第二步，将A柱子最大盘子移动到C
	 * 第三步，将B柱子上剩余的盘子移动到D
	 * @param n int  
	 * 			需要移动的盘子的数量
	 * @param A char
	 * 			柱子A
	 * @param B char
	 * 			柱子B
	 * @param C	char
	 * 			柱子C
	 */
	private static void hanoi(int n, char A, char B, char C){
		//递归的出口
		if(n==1){
			//如果只需要移动1个盘子，那么要做的就是将最大的盘子从A移动到C
			move(A, C);
			return ;
			//如果数量超过1，那么首先将所有小盘子借助C柱子移动到B柱子，
			//然后移动底下最大的盘子移动到C柱子
			//最后再将B柱子上面所有的盘子移动到C柱子上
		}else{
			hanoi(n-1, A, C, B);
			move(A, C);
			hanoi(n-1, B, A, C);
		}

	}
	
	/**
	 * 移动步骤的打印 
	 * @param A char 
	 * 			某柱子	
	 * @param B char
	 * 			某柱子
	 */
	private static void move(char A, char B){
		System.out.println(A+"--->"+B);
	}
	
	/**
	 * 测试上面的方法
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//计算年龄
//		int n=5;
//		int res=calculateAge(n);
//		System.out.println("最终的年龄是："+res);
		//计算阶乘
//		int res1=calculateFac(-1);
//		System.out.println(res1);
		//汉诺塔
		char a='A';
		char b='B';
		char c='C';
		hanoi(10, a, b, c);
	}

}
