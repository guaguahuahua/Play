package com.xjtu.structure;

import java.util.LinkedList;

/**
 * 之字形打印二叉树
 * @author 22847
 *
 */
public class PrintBiTree {

	/**
	 * 使用层序遍历的方式实现
	 * @param root
	 */
	public static void printBiTree(Node root){
		
		if(root==null){
			return ;
		}
		boolean ltor=true;
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		//用来存放某层遍历索引
		int len=0;
		//用来存放整层的节点数
		int size=0;
		while(!queue.isEmpty()){
			size=queue.size();
			len=0;
			Node t;
			while(len<size){
				//如果从左向右打印
				if(ltor==true){
					t=queue.poll();
					if(t.left!=null){
						queue.add(t.left);
					}
					if(t.right!=null){
						queue.add(t.right);
					}
					System.out.print(t.value+"\t");
				//如果从右向左打印	
				}else{
					t=queue.pollLast();
					if(t.right!=null){
						queue.push(t.right);
					}
					if(t.left!=null){
						queue.push(t.left);
					}
					System.out.print(t.value+"\t");					
				}
				len++;
			}
			ltor=(ltor==true) ? false : true;
		}
		
	}
	
	/**
	 * 
	 * @param root
	 */
	public static void printBiTree_1(Node root){
		
		return ;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//			1
		//		 2    3
		//     4  5 6  7
		//  8 9 10 11
		
		Node root=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(3);
		Node n3=new Node(4);
		Node n4=new Node(5);
		Node n5=new Node(6);
		Node n6=new Node(7);
		Node n7=new Node(8);
		Node n8=new Node(9);
		Node n9=new Node(10);
		Node n10=new Node(11);
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		n3.left=n7;
		n3.right=n8;
		n4.left=n9;
		n4.right=n10;
//		layerTraverse(root);
		printBiTree(root);		
	}
	
	
	public static void layerTraverse(Node root){
		if(root==null){
			return ;
		}
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node t=queue.poll();
			if(t.left!=null){
				queue.add(t.left);
			}
			if(t.right!=null){
				queue.add(t.right);
			}
			System.out.print(t.value+"\t");
		}
		System.out.println();		
	}

}
