package com.xjtu.play;

import org.junit.Test;

import com.xjtu.structure.Node;

public class BiTreeSearchTest {

	@Test
	public void testInsert() {
		Node root=new Node();
		root.value=6;
		BiTreeSearch bs=new BiTreeSearch();
		int []array={2,5,8,3};
		Node[]node=new Node[4];
		//初始化节点
		for(int i=0;i<array.length;i++){
			node[i]=new Node();
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
