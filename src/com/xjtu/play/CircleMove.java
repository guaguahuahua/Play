package com.xjtu.play;

public class CircleMove {

	/**
	 * 判断循环移位是否能够实现
	 * @param args
	 */
	public static void main(String []args){
		String m="abcd";
		String t="cdaa";
		boolean r=circleMove(m,t);
		System.out.println(r);
	}
	/**
	 * 通过将母串循环移位来判断是否可以生成子串，如果可以生成则返回true，否则返回false
	 * 算法来自于编程之美：因为循环移位的时候如果移位的数目达到了串的本身的长度，那么也就说移位之后就是本身
	 * 所以可以将每次移位的结果保留下来，最后会组成一个2倍长度的母串，如果再这个结果中包含了子串，那么说明
	 * 子串可以通过母串循环移位得到，否则不行。
	 * @param m 母串
	 * @param t 子串
	 */
	public static boolean circleMove(String m,String t){
		m=m+m;
		if(m.contains(t)){
			return true;
		}
		return false;
	}
}
