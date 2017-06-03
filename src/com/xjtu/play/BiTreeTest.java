package com.xjtu.play;

import com.xjtu.structure.BiTreeNode;

public class BiTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiTreeNode root=new BiTreeNode();
		root.left=null;
		root.right=null;
		root.value=100;
		BiTree tree=new BiTree();
		//���Ӳ������
		BiTreeNode r=tree.insertLeftNode(root, 90);
		System.out.print(r.left+", "+r.value+", "+r.right);
		System.out.println("�鿴���ڵ�����");
		System.out.println(root.left+","+root.value+", "+root.right);
		//�Һ��Ӳ������
		BiTreeNode r1=tree.insertRightNode(root, 80);
		System.out.println(r1.left+", "+r1.value+", "+r1.right);
		BiTreeNode r2=tree.insertLeftNode(r, 70);
		BiTreeNode r3=tree.insertRightNode(r, 60);
		BiTreeNode r4=tree.insertLeftNode(r1, 50);
		//�������
		System.out.println("�������");
		tree.preTraverse(root);
		System.out.println();
		//ɾ��������
//		tree.deleteLeftTree(root);
		BiTreeNode r5=tree.search(root, 50);
//		System.out.println(r5);
		System.out.println(r5.left+", "+r5.value+", "+r5.right);
		//�����������
		tree.LDRTraverse(root);
		//���Ժ������
		System.out.println();
		tree.LRDTraverse(root);
		//���Էǵݹ���ʽ����������
		System.out.println();
		System.out.println("�ǵݹ���ʽ����������");
		tree.NoRecursionTraverse(root);
		//����ʹ�ö�����ɶ������Ĳ������
		System.out.println();
		System.out.println("��ɶ������Ĳ������");
		tree.TraverseWithQueue(root);
		
		//����ͳ��Ԫ�ظ�������
		System.out.println();
		System.out.println("����ͳ��Ԫ�ظ����ķ���:");
		int r6=tree.countNum(root);
		System.out.println(r6);
		//����ͳ�ƶ������߶ȷ���
		System.out.println("����ͳ�ƶ������߶ȷ���");
		int r7=tree.countLayer(root);
		System.out.println(r7);
		
	}
}
