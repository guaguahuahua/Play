package com.leetcode;

import java.util.Stack;

/**
 * 使用堆栈完成了对队列的实现
 * @author 22847
 *
 */
public class MyQueue {
	Stack<Integer> s1;//堆栈s1用来存放所有的输入元素
	Stack<Integer> s2;//堆栈s2用来存放要出队的元素，但是一旦发生了出队，s1和s2作用就会发生改变
	
    /** Initialize your data structure here. */
    public MyQueue() {
    	s1=new Stack<Integer>();
    	s2=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    /**
     * 出队比较复杂，因为出队的时候首先要将s1中所有元素出栈到s2中，将头元素出栈，然后
     * 再将剩余的元素从s2出栈入栈到s1，
     */
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
    	int result=s2.pop();//获得头元素
    	while(!s2.isEmpty()){
    		s1.push(s2.pop());
    	}
    	return result;
    }
    
    /**
     * 查看队头元素实现也是和之前是相似的，首先要做的是将s1中的元素出栈到s2中，然后读出队头元素后，再将
     * s2中的元素出栈回s1
     */
    /** Get the front element. */
    public int peek() {
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
    	int top=s2.peek();
    	while(!s2.isEmpty()){
    		s1.push(s2.pop());
    	}
    	return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return s1.isEmpty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue que=new MyQueue();
		que.push(1);
		que.push(2);
		que.push(3);
		que.push(4);
		int top=que.peek();
		System.out.println("当前队头是："+top);
		
		que.pop();
		int top1=que.peek();
		System.out.println("当前队头是："+top1);
		que.pop();
		int top2=que.peek();
		System.out.println("当前队头是："+top2);
		
		que.pop();
		int top3=que.peek();
		System.out.println("当前队头是："+top3);
		que.pop();
		System.out.println("队列现在的状况是："+que.empty());
	}

}
