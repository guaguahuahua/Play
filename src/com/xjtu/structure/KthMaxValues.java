package com.xjtu.structure;

import java.util.ArrayList;
import java.util.List;

/***
 * 寻找二叉排序树中的第k大元素
 * @author 22847
 *
 */
public class KthMaxValues {

	/**
	 * 获得二叉排序树的中序遍历序列，取倒数第k个元素即可
	 * @param root
	 * @return
	 */
	public static int KthMaxValue(Node root, int k){
		
		List<Integer> list=new ArrayList<Integer>();
		backtrack(root, list);
		if(k>list.size()){
			System.out.println("参数k越界!");
			return -1;
		}
		return list.get(list.size()-k);
	}
	
	public static void backtrack(Node root, List<Integer> list){
		if(root!=null){
			backtrack(root.left, list);
			list.add(root.value);
			backtrack(root.right, list);
		}
	}
	
	private static int count=0;
	
	public static int KthMaxValue_1(Node root, int k){
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root=new Node(5);
		Node n1=new Node(3);
		Node n2=new Node(7);
		Node n3=new Node(2);
		Node n4=new Node(4);
		Node n5=new Node(6);
		Node n6=new Node(8);
		
		root.left=n1;
		root.right=n2;
		n1.left=n3;
		n1.right=n4;
		n2.left=n5;
		n2.right=n6;
		int k=6;
		
		int res=KthMaxValue(root, k);
		System.out.println(res);
	}

}
