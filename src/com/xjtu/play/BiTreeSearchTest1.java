package com.xjtu.play;

import com.xjtu.structure.Node;

public class BiTreeSearchTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node();
		root.value=6;
		BiTreeSearch bs=new BiTreeSearch();
		int []array={2,5,8,3};
		Node[]node=new Node[4];
		//��ʼ���ڵ�
		for(int i=0;i<array.length;i++){
			node[i]=new Node();
			node[i].value=array[i];
			node[i].left=null;
			node[i].right=null;
		}
		//����ڵ�
		for(int i=0;i<array.length;i++){
			bs.insert(root, node[i]);
		}
		//�ڵ����
		int value=3;
		int r=bs.search(root, value);
		System.out.println("���ҽ����"+r);
		//�ڵ�ı���
		System.out.println("�ڵ�ı���:");
		bs.DLR(root);
	}

}
