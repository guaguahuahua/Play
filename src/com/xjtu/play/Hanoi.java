package com.xjtu.play;

public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		towers(4,'A','C','B');
	}
	/**
	 * @param n 这块的n表示盘子的编号，编号越大，那么它个头越大，放置的位置也就越靠近底下
	 * @param fromPeg	当前柱子
	 * @param toPeg		目标柱子
	 * @param auxPeg	临时堆放的柱子
	 */
	static void towers(int n, char fromPeg, char toPeg, char auxPeg){
		//递归出口
		if(n==1){
			System.out.println("move disk 1"+" from peg "+fromPeg+" to peg "+toPeg);
			return ;
		}
		//将n-1个盘子从fromPeg借助toPeg转移至auxPeg，将当前柱子上面n-1个盘移动到临时堆放的柱子
		towers(n-1,fromPeg,auxPeg,toPeg);
		//下面的这个输出可以视为移动底下最大的那个盘子的动作，将底下那个盘子放置到目的柱子上
		System.out.println("move disk "+n+" from peg "+fromPeg+" to peg "+toPeg);
		//将n-1个盘子借助auxPeg移动至toPeg，现在临时柱子上面有n-1个盘子，要做的是将n-1号盘子放置到目标柱子，所以现在将上面的n-2个盘子
		//临时移到初始柱子上去，
		towers(n-1,auxPeg,fromPeg,toPeg);
	}
}
