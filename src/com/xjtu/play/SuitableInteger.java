package com.xjtu.play;

public class SuitableInteger {

	/**
	 * 给定一个正整数n，返回一个最小的正整数 m使得n*m的最终结果中只含有0或者1
	 * 其中m是从1开始一直累加，所以下面的_wrong方法是题意理解有误
	 * @param num
	 * @return
	 */
	public static int suitableInteger_wrong(int num){
		
		int pre=Integer.MAX_VALUE;
		for(int m=num;m>1;m--){
			int tmp=num*m;
			String t=tmp+"";
			boolean flag=true;
			for(int i=0;i<t.length();i++){
				if(t.charAt(i)=='1' || t.charAt(i)=='0'){
					continue;
				}else{
					flag=false;
					break;
				}
			}
			if(flag){
				pre=m>pre?pre:m;
			}else{
				continue;
			}
		}
		System.out.println(pre);
		return pre;
	}
	
	/**
	 * 算法缺点，当给出的n比较大的时候，那么就会溢出，因为使用了乘法运算，所以在两位数阶段就会发生溢出
	 * 还有，使用了字符串的转化，效率会降低
	 * @param num
	 * @return
	 */
	public static int suitableInteger_String(int num){
		
		for(int m=2;;m++){
			boolean flag=true;
			String t=num*m+"";
			for(int i=0;i<t.length();i++){
				if(!(t.charAt(i)=='1' || t.charAt(i)=='0')){
					flag=false;
					break;
				}else{
					continue;
				}
			}
			if(flag){
				return m;
			}else{
				continue;
			}
		}
	}
	
	public static int suitableInteger(int num){
		
		for(int m=2;;m++){
			long tmp=m*num;
			boolean flag=true;
			while(tmp!=0){//判断乘积是不是由01构成
				long locate=tmp % 10;
				if(!(locate==1 || locate==0)){//如果得到的该位既不是0也不是1，那么直接退出，不用判断后面的位了
					flag=false;
					break;
				}
				tmp/=10;
			}
			if(flag){
				return m;
			}else{
				continue;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=9;
		int r=suitableInteger(n);
		System.out.println(r);
	}
}
