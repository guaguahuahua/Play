package com.interview;

public class ReverseString {

	/**
	 * 实现字符串的反转
	 * @param str	String
	 */
	private static void reverseString(String str){
		if(str==null){
			return ;
		}
		//创建存放临时对象的
		StringBuilder sb=new StringBuilder();
		//依次的从尾巴至头部将字符填写进去
		for(int i=str.length()-1; i>-1; i--){
			sb.append(str.charAt(i));
		}
		//第一次逆转
		System.out.println(sb.toString());
		//第二次逆转
		String res=reverseAWord(sb.toString());
		System.out.println(res);
	}
	
	/**
	 * 对单词实现反转
	 * @return	String
	 */
	private static String reverseAWord(String str){
		String []words=str.split("\\s+");
		StringBuilder all=new StringBuilder();
		//遍历每一个单词，将其反转
		for(int i=0; i<words.length; i++){
			StringBuilder sb=new StringBuilder(words[i]);
			all.append(sb.reverse().toString()+" ");
		}
		return all.toString();
	}
	
	/**
	 * 使用字符数组的方式实现
	 * @param str
	 */
	private static void reverseString_2(String str){
		char []c=str.toCharArray();
		int left=0, right=c.length-1;
		while(left<right){
			char temp=c[left];
			c[left]=c[right];
			c[right]=temp;
			left++;
			right--;
		}
//		//
//		for(char K:c){
//			System.out.print(K);
//		}
		reverseAWord(c);
	}
	/**
	 * 使用字符数组的方式，对单个单词进行逆转
	 * @param c
	 */
	private static void reverseAWord(char []c){
		String all="";
		String word="";
		for(int i=0; i<c.length; i++){
			if(c[i]!=' '){
				word=c[i]+word;
			}else{
				all=all+word+" ";
				word="";
			}
		}
		//如果word不为空，那么说明执行的时候还有剩余的字符
		if(word!=""){
			all=all+word;
		}
		System.out.println(all);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="i love programming";
		ReverseString.reverseString_2(str);
	}

}
