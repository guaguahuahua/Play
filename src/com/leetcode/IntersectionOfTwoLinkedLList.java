package com.leetcode;

import com.xjtu.structure.ListNode;

public class IntersectionOfTwoLinkedLList {
	/**
	 * 给定两个有交集的链表，现在要求找到两个链表的交点
	 * 思路：因为两个链表有交集，所以将两个链表接到一起，也就是说
	 * 它们会构成个带有环的单链表，具体画图理解，现在要做的就是找到这个环的
	 * 起始位置所以分为两步走，第一步将两个链表合并，转化为带环结构
	 * 第二步，将寻找环的起始位置。
	 * @param headA
	 * @param headB
	 * @return
	 */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//首先遍历两个链表，判断它们的最后一个节点是否相等，若相等，拼接两个链表，不相等，返回null
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
    	if(head1!=head2){//这块说明没有交集
    		return null;
    	}else{
    		head1.next=headB;
    	}
    	//存在环结构的，找到相遇点
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
     * 检测是否存在环
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
		System.out.println("判断结果是："+result.val);
		
	}

}
