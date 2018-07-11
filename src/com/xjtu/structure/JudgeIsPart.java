package com.xjtu.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * �ж϶�����B�Ƿ�ΪA��һ������
 * @author 22847
 *
 */
public class JudgeIsPart {
	
	public static boolean isPart(Node root1, Node root2){
		//����и����ǿյģ�ֱ�ӷ���false
		if(root1==null || root2==null){
			return false;
		}
		Node r=new Node();
		preOrder(root1, root2, r);
		//�������1��û���ҵ���2�ĸ��ڵ㣬��ô�϶�������
		if(r==null){
			return false;
		}
		//ʹ����������ķ�ʽ��øýڵ��LOR����
		List<Integer> l1=new ArrayList<Integer>();
		List<Integer> l2=new ArrayList<Integer>();
		inOrder(r, l1);
		inOrder(root2, l2);
		//���εıȶ��������Ԫ�أ���l2�ĳ���Ϊ׼
		for(int i=0; i<l2.size(); i++){
			if(l1.get(i)!=l2.get(i)){
				return false;
			}
		}
		return true;
	}	
	
	/**
	 * ʹ����������ķ�ʽѰ�ң�����ҵ�һ�������ĸ��ڵ�ͱȽϵĸ��ڵ���ͬ����ô���ظýڵ�
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static Node preOrder(Node root1, Node root2, Node r){
		//�ݹ����
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
	 * ��ô�ĳ���ڵ㿪ʼ�������������
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
