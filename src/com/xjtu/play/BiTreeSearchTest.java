package com.xjtu.play;

import org.junit.Test;

import com.xjtu.structure.BiTreeNode;

public class BiTreeSearchTest {

	@Test
	public void testInsert() {
		BiTreeNode root=new BiTreeNode();
		root.value=6;
		BiTreeSearch bs=new BiTreeSearch();
		int []array={2,5,8,3};
		BiTreeNode[]node=new BiTreeNode[4];
		//��ʼ���ڵ�
		for(int i=0;i<array.length;i++){
			node[i]=new BiTreeNode();
			node[i].value=array[i];
			node[i].left=null;
			node[i].right=null;
		}
		
		for(int i=0;i<array.length;i++){
			bs.insert(root, node[i]);
		}
	}

	@Test
	public void testSearch() {
		BiTreeSearch bs=new BiTreeSearch();
	}

}
