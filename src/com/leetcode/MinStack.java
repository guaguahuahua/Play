package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinStack {
	List<Integer> stack; 
	int min=Integer.MAX_VALUE;//������������С������ÿ����ջ��ʱ����Ҫ���¸�����
	
    /** initialize your data structure here. */
    public MinStack() {
        stack=new ArrayList<Integer>();
    }
    
    public void push(int x) {
    	stack.add(x);
    	min=min>x ? x : min;//������Сֵ
    }
    
    public void pop() {
    	if(stack.get(stack.size()-1)==min){
        	min=Integer.MAX_VALUE;
	        for(int i=0;i<stack.size()-1;i++){//����ǲ��ܱ������е�Ԫ�صģ�������޷��õ���ǰ����СԪ��
	        	if(min>stack.get(i)){
	        		min=stack.get(i);
	        	}
	        }
    	}
//        if(stack.get(stack.size()-1)!=min){//����Ƴ��Ĳ�����СԪ��
//        	min=min;
//        }else{//����Ƴ�����СԪ�أ���ô����Ѱ����СԪ��
//        	min=Integer.MAX_VALUE;
//	        for(int i=0;i<stack.size()-1;i++){//����ǲ��ܱ������е�Ԫ�صģ�������޷��õ���ǰ����СԪ��
//	        	if(min>stack.get(i)){
//	        		min=stack.get(i);
//	        	}
//	        }
//        }
        stack.remove(stack.size()-1);//��ջֻ��Ҫ�����һ��λ�õ�Ԫ���Ƴ�����
    }
    
    public int top() {
    	return stack.get(stack.size()-1);//ȡ�����һ��Ԫ�أ���ջ��Ԫ��        
    }
   
    public int getMin() {
		return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack mstack=new MinStack();
		mstack.push(-2);
		mstack.push(0);
		mstack.push(-3);
		mstack.push(5);
		mstack.push(6);
		mstack.push(-8);
		int top=mstack.top();
		System.out.println("��ǰջ��Ԫ�أ�"+top);
		int min=mstack.getMin();
		System.out.println("��СԪ�أ�"+min);
				
		mstack.pop();
		int top1=mstack.top();
		System.out.println("��ǰջ��Ԫ�أ�"+top1);
		int min1=mstack.getMin();
		System.out.println("��СԪ�أ�"+min1);
		
		mstack.pop();
		int top2=mstack.top();
		System.out.println("��ǰջ��Ԫ�أ�"+top2);
		int min2=mstack.getMin();
		System.out.println("��СԪ�أ�"+min2);
	}

}
