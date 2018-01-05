package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinStack {
	List<Integer> stack; 
	int min=Integer.MAX_VALUE;//这个用来存放最小的数，每次入栈的时候都需要更新该数据
	
    /** initialize your data structure here. */
    public MinStack() {
        stack=new ArrayList<Integer>();
    }
    
    public void push(int x) {
    	stack.add(x);
    	min=min>x ? x : min;//更新最小值
    }
    
    public void pop() {
    	if(stack.get(stack.size()-1)==min){
        	min=Integer.MAX_VALUE;
	        for(int i=0;i<stack.size()-1;i++){//这块是不能遍历所有的元素的，否则就无法得到当前的最小元素
	        	if(min>stack.get(i)){
	        		min=stack.get(i);
	        	}
	        }
    	}
//        if(stack.get(stack.size()-1)!=min){//如果移除的不是最小元素
//        	min=min;
//        }else{//如果移除了最小元素，那么重新寻找最小元素
//        	min=Integer.MAX_VALUE;
//	        for(int i=0;i<stack.size()-1;i++){//这块是不能遍历所有的元素的，否则就无法得到当前的最小元素
//	        	if(min>stack.get(i)){
//	        		min=stack.get(i);
//	        	}
//	        }
//        }
        stack.remove(stack.size()-1);//出栈只需要将最后一个位置的元素移除即可
    }
    
    public int top() {
    	return stack.get(stack.size()-1);//取得最后一个元素，即栈顶元素        
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
		System.out.println("当前栈顶元素："+top);
		int min=mstack.getMin();
		System.out.println("最小元素："+min);
				
		mstack.pop();
		int top1=mstack.top();
		System.out.println("当前栈顶元素："+top1);
		int min1=mstack.getMin();
		System.out.println("最小元素："+min1);
		
		mstack.pop();
		int top2=mstack.top();
		System.out.println("当前栈顶元素："+top2);
		int min2=mstack.getMin();
		System.out.println("最小元素："+min2);
	}

}
