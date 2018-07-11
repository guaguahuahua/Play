package com.xjtu.play;

import com.xjtu.structure.Node;

public class BiTreeSearch {
	/**
	 * 插入一个排序二叉树节点,从根节点项下寻找合适的位置，
	 * 
	 * @param root 给定根节点，从根结点开始往下
	 * @param node
	 */
	public static int insert(Node root,Node node){
		Node tmp=root;//记录root节点的上个节点位置，主要用于辅助插入
		while(root!=null){
			tmp=root;
			if(root.value==node.value){ //表明该节点实际已经存在了，不需要插入
				return 1;
			}else if(root.value>node.value){//插入节点小于当前节点
				root=root.left;
			}else{							//插入节点大于当前节点
				root=root.right;
			}
		}
		//节点的插入
		if(tmp.value<node.value){//插入节点大于当前节点
			tmp.right=node;
		}else{
			tmp.left=node;
		}
		//插入结束
		return 0;
	}
	/**
	 * 在排序二叉树中寻找某个值是否存在
	 * @param value 需要查询的值
	 * @param root 二叉排序树的根节点
	 * @return 找到返回1，否则返回0
	 */
	public static int search(Node root,int value){
		
		while(root!=null){
			
			if(root.value==value){
				return 1;
			}else if(root.value<value){//如果查找的值大于当前节点，那么直接判断当前节点右分支
				root=root.right;
			}else{					   //如果查找的值小于当前节点，那么判断当前节点的左分支
				root=root.left;
			}
		}
		return 0;
	}
	/**
	 *使用DLR遍历方式
	 * @param root
	 */
	public static void DLR(Node root){
		if(root!=null){
			System.out.println("result："+root.value);
			DLR(root.left);
			DLR(root.right);
		}
	}
}
