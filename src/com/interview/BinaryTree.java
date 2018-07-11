package com.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.interview.structure.Node;
/**
 * 这块是对排序二叉树的复习
 * @author 22847
 *
 */
public class BinaryTree {

	private Node root;
	public BinaryTree(){
		root=null;
	}
	
	public void insert(int data){
		Node node=new Node(data);
		if(root==null){
			root=node;
		}else{
			//如果现在跟节点存在，那么需要将新的节点插入到合适的位置
			Node p, cur=root;
			//插入到右子树
			if(cur.data<=data){
				p=cur;
				cur=cur.right;
				while(cur!=null){
					if(cur.data<=data){
						p=cur;
						cur=cur.right;
					}else{
						p=cur;
						cur=cur.left;
					}					
				}
				//将节点插入
				if(p.data<=data){
					p.right=node;
				}else{
					p.left=node;
				}		
			//插入到左子树	
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
				if(p.data<=data){
					p.right=node;
				}else{
					p.left=node;
				}
			}
		}
	}
	
	/**
	 * 创建二叉树
	 * @param array int[]
	 * 				节点的数据集
	 */
	public void buildTree(int []array){
		for(int i=0; i<array.length; i++){
			insert(array[i]);
		}
		System.out.println("binarytree finish building");
	}
	
	/**
	 * 先序遍历
	 * @param root Node
	 * 				二叉树的根节点
	 */
	public void OLR(Node root){
		if(root!=null){
			System.out.print(root.data+"\t");
			OLR(root.left);
			OLR(root.right);
		}
	}
	
	/**
	 * 层序遍历二叉树
	 * @param root Node
	 * 				二叉树的根节点
	 */
	public void layerTraverse(Node root){
		//使用队列实现层序遍历
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.addLast(root);
		while(!queue.isEmpty()){
			Node temp=queue.removeFirst(); //poll
			System.out.print(temp.data+"\t");
			//因为没有判断节点的左右子树是否为空，所以一开始总是出错
			if(temp.left!=null){
				queue.addLast(temp.left);; //offer
			}
			if(temp.right!=null){
				queue.addLast(temp.right); //offer
			}			
		}
	}
	
	/**
	 * 求二叉树的深度
	 * @param root Node
	 * 				根节点
	 * @return int
	 * 				二叉树的深度
	 */
	public int deepthOfTree(Node root){
		if(root==null){
			return 0;
		}
		int left=deepthOfTree(root.left);
		int right=deepthOfTree(root.right);
		//这块加1是为了防止最后的返回值是0，假设是叶节点，那么如果没有加1的
		//情形下最后的返回值是0，只有加1才会返回值是1
		return left > right ? left+1 : right+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={2,8,7,4,9,3,1,6,7,5};
		BinaryTree tree=new BinaryTree();
		tree.buildTree(array);
		tree.OLR(tree.root);
		System.out.println();
		tree.layerTraverse(tree.root);
		System.out.println();
		//二叉树的深度
		int left=tree.deepthOfTree(tree.root.left);
		int right=tree.deepthOfTree(tree.root.right);
		System.out.println(left+right);		
	}

}
