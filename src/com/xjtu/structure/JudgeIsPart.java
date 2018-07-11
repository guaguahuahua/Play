package com.xjtu.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断二叉树B是否为A的一个部分
 * @author 22847
 *
 */
public class JudgeIsPart {
	
	public static boolean isPart(Node root1, Node root2){
		//如果有个树是空的，直接返回false
		if(root1==null || root2==null){
			return false;
		}
		Node r=new Node();
		preOrder(root1, root2, r);
		//如果在树1中没有找到树2的根节点，那么肯定不存在
		if(r==null){
			return false;
		}
		//使用中序遍历的方式获得该节点的LOR序列
		List<Integer> l1=new ArrayList<Integer>();
		List<Integer> l2=new ArrayList<Integer>();
		inOrder(r, l1);
		inOrder(root2, l2);
		//依次的比对中序遍历元素，以l2的长度为准
		for(int i=0; i<l2.size(); i++){
			if(l1.get(i)!=l2.get(i)){
				return false;
			}
		}
		return true;
	}	
	
	/**
	 * 使用先序遍历的方式寻找，如果找到一个子树的根节点和比较的根节点相同，那么返回该节点
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static Node preOrder(Node root1, Node root2, Node r){
		//递归出口
		if(root1!=null){
			if(root1.value==root2.value){
//				r=root1;
				return r;
			}else{
				preOrder(root1.left, root2, r);
				preOrder(root1.right, root2, r);
			}
		}
		return r;
	} 
	
	/**
	 * 获得从某个节点开始的中序遍历序列
	 * @param node
	 * @param list
	 */
	public static void inOrder(Node node, List<Integer> list){
		if(node!=null){
			list.add(node.value);
			inOrder(node.left, list);
			inOrder(node.right, list);			
		}
	}
	
	public static void preOrder(Node root){
		if(root!=null){
			System.out.print(root.value+"\t");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public static void main(String []args){
		Node root1=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		Node n5=new Node(6);
		Node n6=new Node(7);
		Node n7=new Node(8);
		root1.left=n1;
		root1.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		
		Node root2=new Node(3);
		Node n21=new Node(6);
		Node n22=new Node(7);
		root2.left=n21;
		root2.right=n22;
		
//		preOrder(root2);
		
		
		boolean res=isPart(root1, root2);
		System.out.println(res);
	}
	
}
