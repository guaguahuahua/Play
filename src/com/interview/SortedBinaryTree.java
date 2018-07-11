package com.interview;

import com.interview.structure.Node;

/**
 * ������������ʵ��
 * @author 22847
 *
 */
public class SortedBinaryTree {
	
	private Node root;
	public SortedBinaryTree(){
		this.root=null;
	}
	
	/**
	 * �ڶ����������������һ���ڵ�
	 * һ��ʼ���ǳ������⣬ԭ�������ҽ�����������ĸ��ڵ���Ϊ��һ���α겻�ϵ����ƶ�
	 * ���¸��ڵ㲻�ϵ��ڷ����仯������Ϊʲô���������ԭ��
	 * @param node Node
	 * 				�²���ڵ�
	 */
	public void insert(int data){
		//������ڵ�Ϊ��
		if(root==null){
			Node node=new Node(data);
			root=node;
		}else{
			//������ڵ㲻Ϊ�գ���ôѰ��λ�ý��µ����ݲ���
			//����ڵ���Ҫ��Ϊ�˼�¼λ��
			Node p,cur=root;
			if(cur.data<=data){
				//���������
				p=cur;
				cur=cur.right;
				//��������Ϊ�յ������
				while(cur!=null){
					if(cur.data<=data){
						p=cur;
						cur=cur.right;
					}else{
						p=cur;
						cur=cur.left;
					}
				}
				//���½ڵ���룬����p�ǲ���ڵ�ĸ��ڵ�
				Node insert=new Node(data);
				if(p.data<=data){
					p.right=(insert);
				}else{
					p.left=(insert);
				}
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
				//���½ڵ���룬����p�ǲ���ڵ�ĸ��ڵ�
				Node insert=new Node(data);
				if(p.data<=data){
					p.right=(insert);
				}else{
					p.left =(insert);
				}
			}
		}

	}
	
	/**
	 * ʹ�ø����������ʼ��������
	 * @param array
	 */
	public void buildTree(int []array){
		for(int i=0; i<array.length; i++){
			insert(array[i]);
		}
		System.out.println("�������");
	}
	
	/**
	 * ǰ��������������
	 * @param tree SortedBinaryTree
	 * 					���������
	 */
	public void OLR(Node root){
		if(root!=null){
			System.out.print(root.data+"\t");
			OLR(root.left);
			OLR(root.right);
		}
	}
	
	/**
	 * �������
	 * @param root Node
	 * 				���ڵ�
	 */
	public void LOR(Node root){
		if(root!=null){
			LOR(root.left);
			System.out.print(root.data+"\t");
			LOR(root.right);
		}
	}
	
	/**
	 * �������
	 * @param root Node
	 * 				���ڵ�
	 */
	public void LRO(Node root){
		if(root!=null){
			LRO(root.left);
			LRO(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
		SortedBinaryTree biTree=new SortedBinaryTree();
		biTree.buildTree(array);
		biTree.LOR(biTree.root);
		System.out.println();
		biTree.OLR(biTree.root);
		System.out.println();
		biTree.LRO(biTree.root);
		System.out.println();
	}
}
