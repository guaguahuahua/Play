package com.xjtu.play;

import com.xjtu.structure.BiTreeNode;

public class BiTreeSearchTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiTreeNode root=new BiTreeNode();
		root.value=6;
		BiTreeSearch bs=new BiTreeSearch();
		int []array={2,5,8,3};
		BiTreeNode[]node=new BiTreeNode[4];
		//初始化节点
		for(int i=0;i<array.length;i++){
			node[i]=new BiTreeNode();
			node[i].value=array[i];
			node[i].left=null;
			node[i].right=null;
		}
		//插入节点
		for(int i=0;i<array.length;i++){
			bs.insert(root, node[i]);
		}
		//节点查找
		int value=3;
		int r=bs.search(root, value);
		System.out.println("查找结果："+r);
		//节点的遍历
		System.out.println("节点的遍历:");
		bs.DLR(root);
	}

}
