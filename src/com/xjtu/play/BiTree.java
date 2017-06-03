package com.xjtu.play;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import com.xjtu.structure.BiTreeNode;

public class BiTree {

	/**
	 * �ڵ�ǰ�ڵ��������һ������
	 * @param curr  ��ǰ�ڵ�
	 * @param value ����ڵ��ֵ
	 * @return ���ز���ڵ������
	 */
	public static BiTreeNode insertLeftNode(BiTreeNode curr, int value){
		if(curr==null){//�����ǰ�ڵ�Ϊ�ջ����ǲ����ڣ���ô����Ϊ��
			return null;
		}
		BiTreeNode lnode=new BiTreeNode();//�½�һ���������ڵ㣬
		lnode.value=value; //������ڵ㸳ֵ
		lnode.right=null; //�ò���ڵ���ҽڵ��ÿ�
		lnode.left=curr.left; //�ò���ڵ����ڵ�ָ��ǰ�ڵ����ڵ�
		curr.left=lnode; //�õ�ǰ�ڵ�ָ�������½ڵ�
		return lnode;
	}
	/**
	 * �ڵ�ǰ�ڵ��ϲ���һ���Һ���
	 * @param curr
	 * @param value
	 * @return
	 */
	public static BiTreeNode insertRightNode(BiTreeNode curr,int value){
		if(curr==null){
			return null;
		}
		BiTreeNode rnode=new BiTreeNode();
		rnode.value=value;
		rnode.left=null;
		rnode.right=curr.right;
		curr.right=rnode;
		return rnode;
	}
	/**
	 * ɾ����ǰ�ڵ������������������˵ݹ��ɾ��
	 * @param curr
	 */
	public static void deleteLeftTree(BiTreeNode curr){
		if(curr!=null && curr.left!=null){
			destroy(curr.left);
		}		
	}
	
	/**
	 * ɾ���ڵ㣬�ݹ��ɾ����
	 * @param curr
	 */
	public static void destroy(BiTreeNode curr){
		if(curr!=null && curr.left!=null){
			destroy(curr.left);
		}
		if(curr!=null && curr.right!=null){
			destroy(curr.right);
		}
	}
	/**
	 * ʹ�����������ɶԶ������������
	 * @param curr
	 */
	public void preTraverse(BiTreeNode curr){
		if(curr!=null){
			show(curr);
			preTraverse(curr.left);
			preTraverse(curr.right);
		}
	}
	/**
	 * ����������������ĵ�ǰ�ڵ��ֵ�������
	 * @param curr
	 */
	public static void show(BiTreeNode curr){
		System.out.print(curr.value+"   ");
	}
	/**
	 * �ڶ������ṹ��Ѱ�Һ��ʵ�Ԫ��
	 * @param curr ���ڵ�
	 * @param goal Ҫ������Ԫ��
	 * @return 
	 */
	public static BiTreeNode search(BiTreeNode curr, int goal){
		if(curr==null){
			return null;
		}
		if(curr.value==goal){
			return curr;
		}
		if(curr.left!=null){
			BiTreeNode left=search(curr.left, goal);
			if(left!=null){
				return left;
			}
		}
		if(curr.right!=null){
			BiTreeNode right=search(curr.right, goal);
			if(right!=null){
				return right;
			}
		}
		return null;
	}
	/**
	 * �����������������
	 * @param curr
	 */
	public static void LDRTraverse(BiTreeNode curr){
		if(curr!=null && curr.left!=null){//��ǰ�ڵ㲻Ϊ�գ�������������Ϊ��
			LDRTraverse(curr.left);
		}
		show(curr);
		if(curr.right!=null){
			LDRTraverse(curr.right);
		}
	}
	/**
	 * ʵ�ֺ������
	 * @param curr
	 */
	public static void LRDTraverse(BiTreeNode curr){
		if(curr!=null && curr.left!=null){
			LRDTraverse(curr.left);
		}
		if(curr!=null && curr.right!=null){
			LRDTraverse(curr.right);
		}
		show(curr);
	}
	/**
	 *ʹ�÷ǵݹ鷽ʽ��ɶ������ı���,ʹ�õ��˶�ջ����ʵ�ö���Ҳ�ǿ��Ե� 
	 * @param curr
	 */
	public static void NoRecursionTraverse(BiTreeNode curr){
		Stack<BiTreeNode> stack=new Stack<BiTreeNode>();
		stack.push(curr);
		while(!stack.isEmpty()){//���ջ��Ϊ��
			BiTreeNode top=stack.pop();
			show(top);     //��ջ��Ԫ�����
			if(top.right!=null){//���������
				stack.push(top.right);//�Ƚ�ջ��Ԫ�ص�������ջ����ջ��Ԫ�ص��Һ�����ջ
			}
			if(top.left!=null){//������Һ���
				stack.push(top.left);
			}
		}
	}
	/**
	 * ʹ�ö�����ɶ������ķǵݹ����
	 * @param curr
	 */
	public static void TraverseWithQueue(BiTreeNode curr){
		Queue<BiTreeNode>queue=new ArrayDeque<BiTreeNode>();
		queue.add(curr);
		
		while(!queue.isEmpty()){//������в��ǿյ�
			BiTreeNode head=queue.poll();//��ͷԪ�س���
			show(head);
			if(head.left!=null){//����Ԫ�������ӣ���ô���������ӽ�����
				queue.add(head.left);
			}
			if(head.right!=null){//�������Ԫ�����Һ��ӣ���ô���Һ������ӽ�����
				queue.add(head.right);
			}
		}		
	}
	/***
	 * ͳ�ƶ�������Ԫ�صĸ���
	 * @param curr ���ڵ�
	 * @param n ���������ı���
	 */ 
	public static int n=0;
	public static int countNum(BiTreeNode curr){
		if(curr!=null){//�����ǰԪ�ز�Ϊ�գ���ô��������1
			n=n+1;
		}
		if(curr!=null && curr.left!=null){
			countNum(curr.left);
		}
		if(curr!=null && curr.right!=null){
			countNum(curr.right);
		}
		return n;
	}
	/***
	 * ͳ�ƶ������Ĳ���
	 * @param curr
	 */
	public static int l=0,r=0;
	public static int countLayer(BiTreeNode curr){
		if(curr!=null){//��ǰ�ڵ㲻Ϊ�գ�
			if(curr.left!=null){//ͳ���������ĸ߶�
				l++;
				countLayer(curr.left);
			}
			if(curr.right!=null){//ͳ���������ĸ߶�
				r++;
				countLayer(curr.right);
			}
		}
		return l>r ? l : r ;//���������и߶Ƚϴ����Ϊ�������ĸ߶�
	}
}