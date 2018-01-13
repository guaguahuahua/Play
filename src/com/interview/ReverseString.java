package com.interview;

public class ReverseString {

	/**
	 * ʵ���ַ����ķ�ת
	 * @param str	String
	 */
	private static void reverseString(String str){
		if(str==null){
			return ;
		}
		//���������ʱ�����
		StringBuilder sb=new StringBuilder();
		//���εĴ�β����ͷ�����ַ���д��ȥ
		for(int i=str.length()-1; i>-1; i--){
			sb.append(str.charAt(i));
		}
		//��һ����ת
		System.out.println(sb.toString());
		//�ڶ�����ת
		String res=reverseAWord(sb.toString());
		System.out.println(res);
	}
	
	/**
	 * �Ե���ʵ�ַ�ת
	 * @return	String
	 */
	private static String reverseAWord(String str){
		String []words=str.split("\\s+");
		StringBuilder all=new StringBuilder();
		//����ÿһ�����ʣ����䷴ת
		for(int i=0; i<words.length; i++){
			StringBuilder sb=new StringBuilder(words[i]);
			all.append(sb.reverse().toString()+" ");
		}
		return all.toString();
	}
	
	/**
	 * ʹ���ַ�����ķ�ʽʵ��
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
	 * ʹ���ַ�����ķ�ʽ���Ե������ʽ�����ת
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
		//���word��Ϊ�գ���ô˵��ִ�е�ʱ����ʣ����ַ�
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
