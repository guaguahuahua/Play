package com.xjtu.play;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="bbc abcdab abcdabcdabde";
		String t="abcdabd";
		int []next=new int[t.length()];
		int r=KMPIndex(s,0,t,getNext(t,next));
		System.out.println(r);
	}
	/**
	 * 
	 * @param s 主串
	 * @param start 开始位置
	 * @param next
	 * @return  返回子串在主串中的位置
	 */
	static int KMPIndex(String s,int start,String t,int []next){
		int i=start,j=0,v;
		while(i<s.length() && j<t.length()){
			if(j==-1 || s.charAt(i)==t.charAt(j)){//j=-1是可以next[j]中得到的
				j++;
				i++;
			}else{
				j=next[j];
			}
		}
		if(j==t.length()){
			v=i-t.length();
		}else{
			v=-1;
		}
		return v;
	}
	/**
	 * 
	 * @param t 模式子串t
	 * @param next 存放共有元素的数组
	 */
	static int[] getNext(String t,int next[]){
		
		int j=1,k=0;
		next[0]=-1;
		next[1]=0;
		while(j<t.length()-1){
			if(t.charAt(j)==t.charAt(k)){
				next[j+1]=k+1;
				j++;
				k++;
			}else if(k==0){
				next[j+1]=0;
				j++;
			}else{
				k=next[k];
			}
		}
		return next;
	}
}
