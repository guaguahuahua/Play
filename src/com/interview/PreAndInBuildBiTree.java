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
	 * 后序遍历
	 * @param root Node
	 * 				根节点
	 */
	public void postOrder(Node root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	/**
	 * 使用先序和中序遍历构建二叉树
	 * @param preOrder int[]
	 * 					先序遍历序列
	 * @param start1	int
	 * 					索引开始位置
	 * @param end1		int
	 * 					索引结束位置
	 * @param inOrder	int[]
	 * 					中序遍历序列
	 * @param start2	int
	 * 					中序遍历开始位置
	 * @param end2		int
	 * 					中序遍历结束位置
	 * @return			Node
	 * 					二叉树的根节点
	 */
	public Node initTree(int []preOrder, int start1, int end1, int []inOrder, int start2, int end2){
		
		if(start1>end1 || start2>end2){
			return null;
		}
		//根节点是前序遍历的第一个元素
		int rootData=preOrder[start1];
		Node head=new Node(rootData);
		//在中序遍历中寻找根节点的索引
		int rootIndex=findIndexInArray(inOrder, rootData, start2, end2);
		//左子树的长度
		int offset=rootIndex-start2-1;
		//递归的建立左子树
		Node left=initTree(preOrder, start1+1, start1+1+offset, inOrder, start2, start2+offset);
		//递归的建立右子树
		Node right=initTree(preOrder, start1+offset+2, end1, inOrder, rootIndex+1, end2);
		//连接根节点和左右子树
		head.left=left;
		head.right=right;
		return head;
	}
	
	/**
	 * 在数组中寻找x的索引
	 * @param a int[]
	 * 			被搜索的数组
	 * @param x int
	 * 			要查找的元素
	 * @param begin int
	 * 			查找开始的索引
	 * @param end	int
	 * 			查找结束索引
	 * @return int
	 * 			最终的找到的x的索引值如果没找到，返回-1
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
	 * 返回二叉树中距离最远的两个节点的距离值
	 * 求距离根节点最远的左子树的节点
	 * 求距离根节点最远的右子树的节点
	 * 返回它们的距离的和
	 * 这种方法不可行，因为在遍历的过程中会将节点重复的添加进
	 * 两个动态数组中去
	 * @param root	Node
	 * 				根节点
	 * @return		int
	 * 				两个节点的最大的距离值
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
		//返回两个子树的长度的和
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
		System.out.println("二叉树中距离最大的两个节点的距离为："+res);
	}

}
