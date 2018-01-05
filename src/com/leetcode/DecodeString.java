package com.leetcode;

import java.util.Stack;

public class DecodeString {
	
	/**
	 * 对当前的字符串进行解码，其中方括号内的是要输出的字符，而方括号之前的是该字符重复
	 * 次数,看一下第二个测试用例之后就能理解当前的程序是有问题的，所以要做的就是使用两个
	 * 栈，其中一个用来存数字，一个用来存字符。。
	 * @param s
	 * @return
	 */
    public static String decodeString1(String s) {
        String result="";
    	int i=0;
    	int times=0;
    	int j=0;//']'地方，最终结束的位置
    	boolean flag=false;
        while(i<s.length()){
        	
        	if(s.charAt(i)>='0' && s.charAt(i)<='9'){//字符重复的次数出现了
        		String repeat="";//字符重复次数
        		times=s.charAt(i)-'0';
        		
        		j=i;
        		while(j<s.length()){
        			if(s.charAt(j)==']'){
        				break;
        			}
        			j++;
        		}
        		repeat=s.substring(i+2,j);
        		System.out.println("repeat:"+repeat);
        		while(times>0){
        			result=result+repeat;
        			times--;
        		}
        		flag=true;
        	}    		
        	if(flag){
        		i=j+1;
        		flag=false;
        	}else{
        		i++;
        	}
        }
    	return result;
    }
    /***
     * 由于上面的代码无法实现第二个测试用例，所以，将代码重写， 主要是
     * 改变结构，添加两个栈，使得可以通过第二个测试用例
     * @param s
     * @return
     */
    public static String decodeString(String s) {
    	Stack<Integer> nums=new Stack<Integer>();
    	Stack <String>string=new Stack<String>();
    	String str=s;
    	int index=0;
    	
L1:    	while(index<str.length()){
    		String num="";
    		while(str.charAt(index)<='9' && str.charAt(index)>='0'){
    			num=num+str.charAt(index);
    			index++;
    		}
    		nums.push(Integer.parseInt(num));//将次数剥离出来
    		index++;//跳过第一个方括号
    		String repeat="";
    		while(index<str.length()-1){//去掉最后一个方括号
    			repeat=repeat+str.charAt(index);
    			index++;
    		}
    		string.push(repeat);
    		
        	String temp;
        	while(!string.isEmpty()){
        		String top=string.peek();
        		if(top.charAt(top.length()-1)==']'){//也就是说最后还有嵌入的方括号在内
        			str=string.pop();
        			String tmp="";
        			index=1;
        			while(str.charAt(index)!='['){//这块主要是将方括号之前的元素提取出来然后入栈
        				tmp+=str.charAt(index-1);
        				index++;
        			}
        			string.push(tmp);
        			index--;
        			continue L1;
        		}else{
        			index=str.length();
        			break;
        		}
        	}
    	}
    	//test para 
//    	while(!nums.isEmpty()){
//    		System.out.println(nums.pop());
//    	}
//    	while(!string.isEmpty()){
//    		System.out.println(string.pop());
//    	}
    	String result="";
    	while(!string.isEmpty() && !nums.isEmpty()){
    		int end=nums.pop();
    		String re=string.pop();
    		
    		for(int i=0;i<end;i++){
    			result=result+re;
    		}
    	}
    	System.out.println(result);
    	
    	
    	
    	return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "3[a]2[bc]";// return "aaabcbc".
		String s = "3[a2[c]]";// return "accaccacc"
		String result=decodeString(s);
		System.out.println(result);
//		System.out.println(s.charAt(3)==']');
	}

}
