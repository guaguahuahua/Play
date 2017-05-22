package com.xjtu.play;

import java.util.Stack;

public class KuoHao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str="((()))";
		String str="{{([])()}}";
		boolean r=isMatch(str);
		System.out.println("isMatch: "+r);
	}
	/**
	 * �ж������Ƿ�ƥ�䣬�����ƥ�䣬
	 * @param str
	 * @return
	 */
	public static boolean isMatch(String str){
		
		Stack <Character>result=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			if(result.isEmpty()){//�����ǰ�Ķ�ջ�ǿյģ�ֱ�Ӳ���Ԫ��
				result.push(str.charAt(i));
			}else{//�����ǰ�Ķ�ջ��Ϊ�գ��ж�ջ��Ԫ�أ����ջ��Ԫ�غ͵�ǰ��Ԫ����һ�ԣ���ô��ջ�����߽�ջ
				char top=result.peek();
				if(top=='(' && str.charAt(i)==')'){
					result.pop();
				}else if(top=='[' && str.charAt(i)==']'){
					result.pop();
				}else if(top=='{' && str.charAt(i)=='}'){
					result.pop();
				}else{
					result.push(str.charAt(i));
				}
			}
		}
		return result.size()==0;
	}
}
