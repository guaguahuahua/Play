package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ʹ�ö���ʵ�ֶ�ջ������˼·�����ڶ�ջ�Ǻ���ȳ������������Ƚ��ȳ���Ϊ�˸ı�������棬
 * ����ʹ���������У�ÿ�α�֤һ�������ǿյģ��Ӷ�ʹ�ò����Ԫ�����Ƿ����ڿն����У�Ȼ�����е�Ԫ�س�����ת�Ƶ�
 * �²���Ԫ�صĶ����У��Ӷ�ʹ�øղ����Ԫ�ؿ�����ʱ���ӣ������޸��˲��������
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
        	flag1=false;//�´�������2��ӣ�
        	flag2=true;
        }else if(flag2 && q2.isEmpty()){
        	q2.add(x);
        	flag1=true;//�´�������1��ӣ�
        	flag2=false;
        }
    	//�ƶ�Ԫ��
        if(flag2 && q1.size()==1){//����Ǹող����Ԫ�ض��У���ôת��δ����Ԫ�صĶ���
        	while(!q2.isEmpty()){//��q2�е�Ԫ��ȫ��ת�Ƶ�q1��ȥ
        		q1.add(q2.poll());
        	}
        }else if(flag1 && q2.size()==1){
        	while(!q1.isEmpty()){
        		q2.add(q1.poll());
        	}
        }
    }
/*    public void push(int x){
        
    	if(q1.isEmpty()){//�����������Ե�ԭ������Ϊ�ǲ��������Ⱥ�˳����������������λ�Ǳ����
        	q1.add(x);
        }else{
        	q2.add(x);
        }
    	//�ƶ�Ԫ��
        if(q1.size()==1){//����Ǹող����Ԫ�ض��У���ôת��δ����Ԫ�صĶ���
        	while(!q2.isEmpty()){//��q2�е�Ԫ��ȫ��ת�Ƶ�q1��ȥ
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
    	if(q1.isEmpty()){//�����У������ò��յĶ��г���
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
