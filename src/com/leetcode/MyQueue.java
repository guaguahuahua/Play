package com.leetcode;

import java.util.Stack;

/**
 * ʹ�ö�ջ����˶Զ��е�ʵ��
 * @author 22847
 *
 */
public class MyQueue {
	Stack<Integer> s1;//��ջs1����������е�����Ԫ��
	Stack<Integer> s2;//��ջs2�������Ҫ���ӵ�Ԫ�أ�����һ�������˳��ӣ�s1��s2���þͻᷢ���ı�
	
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
     * ���ӱȽϸ��ӣ���Ϊ���ӵ�ʱ������Ҫ��s1������Ԫ�س�ջ��s2�У���ͷԪ�س�ջ��Ȼ��
     * �ٽ�ʣ���Ԫ�ش�s2��ջ��ջ��s1��
     */
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
    	int result=s2.pop();//���ͷԪ��
    	while(!s2.isEmpty()){
    		s1.push(s2.pop());
    	}
    	return result;
    }
    
    /**
     * �鿴��ͷԪ��ʵ��Ҳ�Ǻ�֮ǰ�����Ƶģ�����Ҫ�����ǽ�s1�е�Ԫ�س�ջ��s2�У�Ȼ�������ͷԪ�غ��ٽ�
     * s2�е�Ԫ�س�ջ��s1
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
		System.out.println("��ǰ��ͷ�ǣ�"+top);
		
		que.pop();
		int top1=que.peek();
		System.out.println("��ǰ��ͷ�ǣ�"+top1);
		que.pop();
		int top2=que.peek();
		System.out.println("��ǰ��ͷ�ǣ�"+top2);
		
		que.pop();
		int top3=que.peek();
		System.out.println("��ǰ��ͷ�ǣ�"+top3);
		que.pop();
		System.out.println("�������ڵ�״���ǣ�"+que.empty());
	}

}
