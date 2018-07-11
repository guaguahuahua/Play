package com.interview;

import com.interview.structure.Node;

/**
 * 二叉排序树的实现
 * @author 22847
 *
 */
public class SortedBinaryTree {
	
	private Node root;
	public SortedBinaryTree(){
		this.root=null;
	}
	
	/**
	 * 在二叉排序树上面插入一个节点
	 * 一开始老是出现问题，原因在于我将排序二叉树的根节点作为了一个游标不断的在移动
	 * 导致根节点不断的在发生变化，这是为什么出现问题的原因
	 * @param node Node
	 * 				新插入节点
	 */
	public void insert(int data){
		//如果根节点为空
		if(root==null){
			Node node=new Node(data);
			root=node;
		}else{
			//如果根节点不为空，那么寻找位置将新的数据插入
			//这个节点主要是为了记录位置
			Node p,cur=root;
			if(cur.data<=data){
				//获得右子树
				p=cur;
				cur=cur.right;
				//右子树不为空的情况下
				while(cur!=null){
					if(cur.data<=data){
						p=cur;
						cur=cur.right;
					}else{
						p=cur;
						cur=cur.left;
					}
				}
				//将新节点插入，现在p是插入节点的父节点
				Node insert=new Node(data);
				if(p.data<=data){
					p.right=(insert);
				}else{
					p.left=(insert);
				}
			}else{
				p=cur;
				cur=cur.left;
				while(cur!=null){
					if(cur.data<=data){
						p=cur;
						cur=cur.right;
					}else{
						p=cur;
						cur=cur.left;
					}				
				}
				//将新节点插入，现在p是插入节点的父节点
				Node insert=new Node(data);
				if(p.data<=data){
					p.right=(insert);
				}else{
					p.left =(insert);
				}
			}
		}

	}
	
	/**
	 * 使用给定的数组初始化二叉树
	 * @param array
	 */
	public void buildTree(int []array){
		for(int i=0; i<array.length; i++){
			insert(array[i]);
		}
		System.out.println("建树完毕");
	}
	
	/**
	 * 前序遍历排序二叉树
	 * @param tree SortedBinaryTree
	 * 					排序二叉树
	 */
	public void OLR(Node root){
		if(root!=null){
			System.out.print(root.data+"\t");
			OLR(root.left);
			OLR(root.right);
		}
	}
	
	/**
	 * 中序遍历
	 * @param root Node
	 * 				根节点
	 */
	public void LOR(Node root){
		if(root!=null){
			LOR(root.left);
			System.out.print(root.data+"\t");
			LOR(root.right);
		}
	}
	
	/**
	 * 后序遍历
	 * @param root Node
	 * 				根节点
	 */
	public void LRO(Node root){
		if(root!=null){
			LRO(root.left);
			LRO(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
		SortedBinaryTree biTree=new SortedBinaryTree();
		biTree.buildTree(array);
		biTree.LOR(biTree.root);
		System.out.println();
		biTree.OLR(biTree.root);
		System.out.println();
		biTree.LRO(biTree.root);
		System.out.println();
	}
}
