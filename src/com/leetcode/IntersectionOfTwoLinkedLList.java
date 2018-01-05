package com.leetcode;

import com.xjtu.structure.ListNode;

public class IntersectionOfTwoLinkedLList {
	/**
	 * ���������н�������������Ҫ���ҵ���������Ľ���
	 * ˼·����Ϊ���������н��������Խ���������ӵ�һ��Ҳ����˵
	 * ���ǻṹ�ɸ����л��ĵ��������廭ͼ��⣬����Ҫ���ľ����ҵ��������
	 * ��ʼλ�����Է�Ϊ�����ߣ���һ������������ϲ���ת��Ϊ�����ṹ
	 * �ڶ�������Ѱ�һ�����ʼλ�á�
	 * @param headA
	 * @param headB
	 * @return
	 */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//���ȱ������������ж����ǵ����һ���ڵ��Ƿ���ȣ�����ȣ�ƴ��������������ȣ�����null
    	ListNode head1=headA,head2=headB;
    	if(head1==null || head2==null){
    		return null;
    	}
    	while(head1.next!=null){
    		head1=head1.next;
    	}
    	while(head2.next!=null){
    		head2=head2.next;
    	}
    	if(head1!=head2){//���˵��û�н���
    		return null;
    	}else{
    		head1.next=headB;
    	}
    	//���ڻ��ṹ�ģ��ҵ�������
    	ListNode fast=headA,slow=headA;
    	if(headA==null || headA.next==null){
    		return null;
    	}
    	while(fast!=null && fast.next!=null){
    		fast=fast.next.next;
    		slow=slow.next;
    		if(fast==slow){
    			break;
    		}
    	}
		slow=headA;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
		return fast;
    }
    /***
     * ����Ƿ���ڻ�
     * @param head
     * @return
     */
	public static ListNode detectCycle(ListNode head){
		
		ListNode fast=head,slow=head;
		if(head==null || head.next==null){
			return null;
		}
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast){
				break;
			}
		}
		if(slow==fast){
			slow=head;
			while(slow!=fast){
				fast=fast.next;
				slow=slow.next;
			}
			return fast;
		}else{
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1=new ListNode(1);
		ListNode a2=new ListNode(1);
		ListNode c1=new ListNode(6);
		ListNode c2=new ListNode(1);
		ListNode c3=new ListNode(1);
		ListNode b1=new ListNode(1);
		ListNode b2=new ListNode(1);
		ListNode b3=new ListNode(1);
		a1.next=a2;
		a2.next=c1;
		c1.next=c2;
		c2.next=c3;
		b1.next=b2;
		b2.next=b3;
		b3.next=c1;
		c1.next=c2;
		c2.next=c3;
		ListNode result=getIntersectionNode(a1, b1);
		System.out.println("�жϽ���ǣ�"+result.val);
		
	}

}
