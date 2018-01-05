package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现堆栈操作，思路：由于堆栈是后进先出，而队列是先进先出，为了改变这个局面，
 * 所以使用两个队列，每次保证一个队列是空的，从而使得插入的元素总是放置在空队列中，然后将已有的元素出队列转移到
 * 新插入元素的队列中，从而使得刚插入的元素可以随时出队，这是修改了插入操作，
 * @author 22847
 *
 */
public class MyStack {
	private Deque<Integer> q1;
	private Deque<Integer> q2;
	boolean flag1=true;
	boolean flag2=false;
    /** Initialize your data structure here. */
    public MyStack() {
        q1=new ArrayDeque<Integer>();
        q2=new ArrayDeque<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x){
        
    	if(flag1 && q1.isEmpty()){
        	q1.add(x);
        	flag1=false;//下次往队列2添加，
        	flag2=true;
        }else if(flag2 && q2.isEmpty()){
        	q2.add(x);
        	flag1=true;//下次往队列1添加，
        	flag2=false;
        }
    	//移动元素
        if(flag2 && q1.size()==1){//如果是刚刚插入的元素队列，那么转移未插入元素的队列
        	while(!q2.isEmpty()){//将q2中的元素全部转移到q1中去
        		q1.add(q2.poll());
        	}
        }else if(flag1 && q2.size()==1){
        	while(!q1.isEmpty()){
        		q2.add(q1.poll());
        	}
        }
    }
/*    public void push(int x){
        
    	if(q1.isEmpty()){//这样做不可以的原因是因为是不能区分先后顺序，所以添加两个标记位是必须的
        	q1.add(x);
        }else{
        	q2.add(x);
        }
    	//移动元素
        if(q1.size()==1){//如果是刚刚插入的元素队列，那么转移未插入元素的队列
        	while(!q2.isEmpty()){//将q2中的元素全部转移到q1中去
        		q1.add(q2.poll());
        	}
        }else{
        	while(!q1.isEmpty()){
        		q2.add(q1.poll());
        	}
        }
    }*/
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(q1.isEmpty()){//出队列，总是让不空的队列出队
    		return q2.poll();
    	}else{
    		return q1.poll();
    	}        
    }
    
    /** Get the top element. */
    public int top() {
    	if(q1.isEmpty()){
    		return q2.peek();
    	}else{
    		return q1.peek();
    	}        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
		
    	if(q1.isEmpty() && q2.isEmpty()){
    		return true;
    	}else{
    		return false;
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack obj=new MyStack();
		obj.push(1);
		obj.push(2);
//		obj.push(3);
//		obj.push(4);
		int top=obj.top();
		System.out.println("top::"+top);
		int pop=obj.pop();
		System.out.println("pop:"+pop);
		int top2=obj.top();
		System.out.println("top::"+top2);
		boolean empty=obj.empty();
		System.out.println("is empty:"+empty);
	}

}
