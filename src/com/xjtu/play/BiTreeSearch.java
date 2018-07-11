package com.xjtu.play;

import com.xjtu.structure.Node;

public class BiTreeSearch {
	/**
	 * ����һ������������ڵ�,�Ӹ��ڵ�����Ѱ�Һ��ʵ�λ�ã�
	 * 
	 * @param root �������ڵ㣬�Ӹ���㿪ʼ����
	 * @param node
	 */
	public static int insert(Node root,Node node){
		Node tmp=root;//��¼root�ڵ���ϸ��ڵ�λ�ã���Ҫ���ڸ�������
		while(root!=null){
			tmp=root;
			if(root.value==node.value){ //�����ýڵ�ʵ���Ѿ������ˣ�����Ҫ����
				return 1;
			}else if(root.value>node.value){//����ڵ�С�ڵ�ǰ�ڵ�
				root=root.left;
			}else{							//����ڵ���ڵ�ǰ�ڵ�
				root=root.right;
			}
		}
		//�ڵ�Ĳ���
		if(tmp.value<node.value){//����ڵ���ڵ�ǰ�ڵ�
			tmp.right=node;
		}else{
			tmp.left=node;
		}
		//�������
		return 0;
	}
	/**
	 * �������������Ѱ��ĳ��ֵ�Ƿ����
	 * @param value ��Ҫ��ѯ��ֵ
	 * @param root �����������ĸ��ڵ�
	 * @return �ҵ�����1�����򷵻�0
	 */
	public static int search(Node root,int value){
		
		while(root!=null){
			
			if(root.value==value){
				return 1;
			}else if(root.value<value){//������ҵ�ֵ���ڵ�ǰ�ڵ㣬��ôֱ���жϵ�ǰ�ڵ��ҷ�֧
				root=root.right;
			}else{					   //������ҵ�ֵС�ڵ�ǰ�ڵ㣬��ô�жϵ�ǰ�ڵ�����֧
				root=root.left;
			}
		}
		return 0;
	}
	/**
	 *ʹ��DLR������ʽ
	 * @param root
	 */
	public static void DLR(Node root){
		if(root!=null){
			System.out.println("result��"+root.value);
			DLR(root.left);
			DLR(root.right);
		}
	}
}
