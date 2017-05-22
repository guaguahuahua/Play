package com.xjtu.play;

public class Fabonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=35;
		long s2=System.currentTimeMillis();
		int r=fabonacci_directly(num);
		long e2=System.currentTimeMillis();
		System.out.println(r);
		System.out.println("直接法："+(e2-s2));
		
		long s1=System.currentTimeMillis();
		int r1=fabonacci(num);
		long e1=System.currentTimeMillis();
		System.out.println(r1);
		System.out.println("间接法："+(e1-s1));
		
		String str="3";
		switch(str){
		case "34":System.out.println("switch support String ");break;
		default:System.out.println("that's good !");
		}
	}
	/**
	 * 直接法求的fabonacci数列中的特定项,明显的可以看出，这样做会开辟大量的空间，相比于递归法，资源消耗比较多
	 * @param num
	 * @return
	 */
	public static int fabonacci_directly(int num){
		
		int []array=new int[num+1];
		array[0]=0;
		array[1]=1;
		
		for(int i=2;i<=num;i++){
			array[i]=array[i-1]+array[i-2];
		}
		return array[num];
	}
	
	public static int fabonacci(int num){
		
		if(num==0){
			return 0;
		}
		if(num==1){
			return 1;
		}
		return fabonacci(num-1)+fabonacci(num-2);
	}
}
