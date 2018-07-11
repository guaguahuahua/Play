package com.xjtu.play;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

import com.xjtu.structure.Node;

public class BiTree {

	/**
	 * 在当前节点上面插入一个左孩子
	 * @param curr  当前节点
	 * @param value 插入节点的值
	 * @return 返回插入节点的引用
	 */
	public static Node insertLeftNode(Node curr, int value){
		if(curr==null){//如果当前节点为空或者是不存在，那么返回为空
			return null;
		}
		Node lnode=new Node();//新建一个二叉链节点，
		lnode.value=value; //给插入节点赋值
		lnode.right=null; //让插入节点的右节点置空
		lnode.left=curr.left; //让插入节点的左节点指向当前节点的左节点
		curr.left=lnode; //让当前节点指向插入的新节点
		return lnode;
	}
	/**
	 * 在当前节点上插入一个右孩子
	 * @param curr
	 * @param value
	 * @return
	 */
	public static Node insertRightNode(Node curr,int value){
		if(curr==null){
			return null;
		}
		Node rnode=new Node();
		rnode.value=value;
		rnode.left=null;
		rnode.right=curr.right;
		curr.right=rnode;
		return rnode;
	}
	/**
	 * 删除当前节点的左子树，里面包括了递归的删除
	 * @param curr
	 */
	public static void deleteLeftTree(Node curr){
		if(curr!=null && curr.left!=null){
			destroy(curr.left);
		}		
	}
	
	/**
	 * 删除节点，递归的删除，
	 * @param curr
	 */
	public static void destroy(Node curr){
		if(curr!=null && curr.left!=null){
			destroy(curr.left);
		}
		if(curr!=null && curr.right!=null){
			destroy(curr.right);
		}
	}
	/**
	 * 使用先序遍历完成对二叉树的输出。
	 * @param curr
	 */
	public void preTraverse(Node curr){
		if(curr!=null){
			show(curr);
			preTraverse(curr.left);
			preTraverse(curr.right);
		}
	}
	/**
	 * 输出函数，将遍历的当前节点的值进行输出
	 * @param curr
	 */
	public static void show(Node curr){
		System.out.print(curr.value+"   ");
	}
	/**
	 * 在二叉链结构中寻找合适的元素
	 * @param curr 根节点
	 * @param goal 要搜索的元素
	 * @return 
	 */
	public static Node search(Node curr, int goal){
		if(curr==null){
			return null;
		}
		if(curr.value==goal){
			return curr;
		}
		if(curr.left!=null){
			Node left=search(curr.left, goal);
			if(left!=null){
				return left;
			}
		}
		if(curr.right!=null){
			Node right=search(curr.right, goal);
			if(right!=null){
				return right;
			}
		}
		return null;
	}
	/**
	 * 中序遍历整个二叉链
	 * @param curr
	 */
	public static void LDRTraverse(Node curr){
		if(curr!=null && curr.left!=null){//当前节点不为空，并且左子树不为空
			LDRTraverse(curr.left);
		}
		show(curr);
		if(curr.right!=null){
			LDRTraverse(curr.right);
		}
	}
	/**
	 * 实现后序遍历
	 * @param curr
	 */
	public static void LRDTraverse(Node curr){
		if(curr!=null && curr.left!=null){
			LRDTraverse(curr.left);
		}
		if(curr!=null && curr.right!=null){
			LRDTraverse(curr.right);
		}
		show(curr);
	}
	/**
	 *使用非递归方式完成二叉树的遍历,使用到了堆栈，其实用队列也是可以的 
	 * @param curr
	 */
	public static void NoRecursionTraverse(Node curr){
		Stack<Node> stack=new Stack<Node>();
		stack.push(curr);
		while(!stack.isEmpty()){//如果栈不为空
			Node top=stack.pop();
			show(top);     //将栈顶元素输出
			if(top.right!=null){//如果有左孩子
				stack.push(top.right);//先将栈顶元素的左孩子入栈，后将栈顶元素的右孩子入栈
			}
			if(top.left!=null){//如果有右孩子
				stack.push(top.left);
			}
		}
	}
	/**
	 * 使用队列完成二叉树的非递归遍历
	 * @param curr
	 */
	public static void TraverseWithQueue(Node curr){
		Queue<Node>queue=new ArrayDeque<Node>();
		queue.add(curr);
		
		while(!queue.isEmpty()){//如果队列不是空的
			Node head=queue.poll();//队头元素出队
			show(head);
			if(head.left!=null){//出队元素有左孩子，那么将左孩子添加进队列
				queue.add(head.left);
			}
			if(head.right!=null){//如果出队元素有右孩子，那么将右孩子添加进队列
				queue.add(head.right);
			}
		}		
	}
	/***
	 * 统计二叉树中元素的个数
	 * @param curr 根节点
	 * @param n 用来计数的变量
	 */ 
	public static int n=0;
	public static int countNum(Node curr){
		if(curr!=null){//如果当前元素不为空，那么计数器加1
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
	 * 统计二叉树的层数
	 * @param curr
	 */
	public static int l=0,r=0;
	public static int countLayer(Node curr){
		if(curr!=null){//当前节点不为空，
			if(curr.left!=null){//统计左子树的高度
				l++;
				countLayer(curr.left);
			}
			if(curr.right!=null){//统计右子树的高度
				r++;
				countLayer(curr.right);
			}
		}
		return l>r ? l : r ;//返回子树中高度较大的作为二叉树的高度
	}
}
