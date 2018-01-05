package com.leetcode;

import java.util.Stack;

public class DecodeString {
	
	/**
	 * �Ե�ǰ���ַ������н��룬���з������ڵ���Ҫ������ַ�����������֮ǰ���Ǹ��ַ��ظ�
	 * ����,��һ�µڶ�����������֮�������⵱ǰ�ĳ�����������ģ�����Ҫ���ľ���ʹ������
	 * ջ������һ�����������֣�һ���������ַ�����
	 * @param s
	 * @return
	 */
    public static String decodeString1(String s) {
        String result="";
    	int i=0;
    	int times=0;
    	int j=0;//']'�ط������ս�����λ��
    	boolean flag=false;
        while(i<s.length()){
        	
        	if(s.charAt(i)>='0' && s.charAt(i)<='9'){//�ַ��ظ��Ĵ���������
        		String repeat="";//�ַ��ظ�����
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
     * ��������Ĵ����޷�ʵ�ֵڶ����������������ԣ���������д�� ��Ҫ��
     * �ı�ṹ���������ջ��ʹ�ÿ���ͨ���ڶ�����������
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
    		nums.push(Integer.parseInt(num));//�������������
    		index++;//������һ��������
    		String repeat="";
    		while(index<str.length()-1){//ȥ�����һ��������
    			repeat=repeat+str.charAt(index);
    			index++;
    		}
    		string.push(repeat);
    		
        	String temp;
        	while(!string.isEmpty()){
        		String top=string.peek();
        		if(top.charAt(top.length()-1)==']'){//Ҳ����˵�����Ƕ��ķ���������
        			str=string.pop();
        			String tmp="";
        			index=1;
        			while(str.charAt(index)!='['){//�����Ҫ�ǽ�������֮ǰ��Ԫ����ȡ����Ȼ����ջ
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
