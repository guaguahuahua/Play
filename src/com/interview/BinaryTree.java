package com.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.interview.structure.Node;
/**
 * ����Ƕ�����������ĸ�ϰ
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
			//������ڸ��ڵ���ڣ���ô��Ҫ���µĽڵ���뵽���ʵ�λ��
			Node p, cur=root;
			//���뵽������
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
				//���ڵ����
				if(p.data<=data){
					p.right=node;
				}else{
					p.left=node;
				}		
			//���뵽������	
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
	 * ����������
	 * @param array int[]
	 * 				�ڵ�����ݼ�
	 */
	public void buildTree(int []array){
		for(int i=0; i<array.length; i++){
			insert(array[i]);
		}
		System.out.println("binarytree finish building");
	}
	
	/**
	 * �������
	 * @param root Node
	 * 				�������ĸ��ڵ�
	 */
	public void OLR(Node root){
		if(root!=null){
			System.out.print(root.data+"\t");
			OLR(root.left);
			OLR(root.right);
		}
	}
	
	/**
	 * �������������
	 * @param root Node
	 * 				�������ĸ��ڵ�
	 */
	public void layerTraverse(Node root){
		//ʹ�ö���ʵ�ֲ������
		LinkedList<Node> queue=new LinkedList<Node>();
		queue.addLast(root);
		while(!queue.isEmpty()){
			Node temp=queue.removeFirst(); //poll
			System.out.print(temp.data+"\t");
			//��Ϊû���жϽڵ�����������Ƿ�Ϊ�գ�����һ��ʼ���ǳ���
			if(temp.left!=null){
				queue.addLast(temp.left);; //offer
			}
			if(temp.right!=null){
				queue.addLast(temp.right); //offer
			}			
		}
	}
	
	/**
	 * ������������
	 * @param root Node
	 * 				���ڵ�
	 * @return int
	 * 				�����������
	 */
	public int deepthOfTree(Node root){
		if(root==null){
			return 0;
		}
		int left=deepthOfTree(root.left);
		int right=deepthOfTree(root.right);
		//����1��Ϊ�˷�ֹ���ķ���ֵ��0��������Ҷ�ڵ㣬��ô���û�м�1��
		//���������ķ���ֵ��0��ֻ�м�1�Ż᷵��ֵ��1
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
		//�����������
		int left=tree.deepthOfTree(tree.root.left);
		int right=tree.deepthOfTree(tree.root.right);
		System.out.println(left+right);		
	}

}
