package com.interview;

import java.util.ArrayList;
import java.util.List;

import com.interview.structure.Node;

public class PreAndInBuildBiTree {

	private Node root;
	public PreAndInBuildBiTree(){
		root=null;
	}
	
	/**
	 * �������
	 * @param root Node
	 * 				���ڵ�
	 */
	public void postOrder(Node root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	/**
	 * ʹ������������������������
	 * @param preOrder int[]
	 * 					�����������
	 * @param start1	int
	 * 					������ʼλ��
	 * @param end1		int
	 * 					��������λ��
	 * @param inOrder	int[]
	 * 					�����������
	 * @param start2	int
	 * 					���������ʼλ��
	 * @param end2		int
	 * 					�����������λ��
	 * @return			Node
	 * 					�������ĸ��ڵ�
	 */
	public Node initTree(int []preOrder, int start1, int end1, int []inOrder, int start2, int end2){
		
		if(start1>end1 || start2>end2){
			return null;
		}
		//���ڵ���ǰ������ĵ�һ��Ԫ��
		int rootData=preOrder[start1];
		Node head=new Node(rootData);
		//�����������Ѱ�Ҹ��ڵ������
		int rootIndex=findIndexInArray(inOrder, rootData, start2, end2);
		//�������ĳ���
		int offset=rootIndex-start2-1;
		//�ݹ�Ľ���������
		Node left=initTree(preOrder, start1+1, start1+1+offset, inOrder, start2, start2+offset);
		//�ݹ�Ľ���������
		Node right=initTree(preOrder, start1+offset+2, end1, inOrder, rootIndex+1, end2);
		//���Ӹ��ڵ����������
		head.left=left;
		head.right=right;
		return head;
	}
	
	/**
	 * ��������Ѱ��x������
	 * @param a int[]
	 * 			������������
	 * @param x int
	 * 			Ҫ���ҵ�Ԫ��
	 * @param begin int
	 * 			���ҿ�ʼ������
	 * @param end	int
	 * 			���ҽ�������
	 * @return int
	 * 			���յ��ҵ���x������ֵ���û�ҵ�������-1
	 */
	public int findIndexInArray(int []a, int x, int begin, int end){
		for(int i=begin; i<=end; i++){
			if(a[i]==x){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * ���ض������о�����Զ�������ڵ�ľ���ֵ
	 * �������ڵ���Զ���������Ľڵ�
	 * �������ڵ���Զ���������Ľڵ�
	 * �������ǵľ���ĺ�
	 * ���ַ��������У���Ϊ�ڱ����Ĺ����лὫ�ڵ��ظ�����ӽ�
	 * ������̬������ȥ
	 * @param root	Node
	 * 				���ڵ�
	 * @return		int
	 * 				�����ڵ�����ľ���ֵ
	 */
	
	static int left=0;
	static int right=0;
	public static int maxDistanceOfBinaryTree(Node root, List<Node> left, List<Node>right){
		Node p=root, q=root;
		if(root!=null){
			while(p.left!=null){
				p=p.left;
				left.add(p);
				maxDistanceOfBinaryTree(p, left, right);
			}
			while(q.right!=null){
				q=q.right;
				right.add(root);
				maxDistanceOfBinaryTree(q, left, right);
			}
		}		
		//�������������ĳ��ȵĺ�
		return right.size()-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreAndInBuildBiTree tree=new PreAndInBuildBiTree();
		int []preOrder={1,2,4,8,9,5,10,3,6,7};
		int []inOrder ={8,4,9,2,10,5,1,6,3,7};
		Node head=tree.initTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
		tree.postOrder(head);
		System.out.println();
		List<Node>left=new ArrayList<Node>();
		List<Node>right=new ArrayList<Node>();
		int res=tree.maxDistanceOfBinaryTree(head, left, right);
		System.out.println("�������о������������ڵ�ľ���Ϊ��"+res);
	}

}
