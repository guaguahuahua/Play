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
	 * 判读括号是否匹配，如果不匹配，
	 * @param str
	 * @return
	 */
	public static boolean isMatch(String str){
		
		Stack <Character>result=new Stack<Character>();
		for(int i=0;i<str.length();i++){
			if(result.isEmpty()){//如果当前的堆栈是空的，直接插入元素
				result.push(str.charAt(i));
			}else{//如果当前的堆栈不为空，判断栈顶元素，如果栈顶元素和当前的元素是一对，那么出栈，否者进栈
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
