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
		//左孩子插入测试
		BiTreeNode r=tree.insertLeftNode(root, 90);
		System.out.print(r.left+", "+r.value+", "+r.right);
		System.out.println("查看根节点的情况");
		System.out.println(root.left+","+root.value+", "+root.right);
		//右孩子插入测试
		BiTreeNode r1=tree.insertRightNode(root, 80);
		System.out.println(r1.left+", "+r1.value+", "+r1.right);
		BiTreeNode r2=tree.insertLeftNode(r, 70);
		BiTreeNode r3=tree.insertRightNode(r, 60);
		BiTreeNode r4=tree.insertLeftNode(r1, 50);
		//先序遍历
		System.out.println("先序遍历");
		tree.preTraverse(root);
		System.out.println();
		//删除左子树
//		tree.deleteLeftTree(root);
		BiTreeNode r5=tree.search(root, 50);
//		System.out.println(r5);
		System.out.println(r5.left+", "+r5.value+", "+r5.right);
		//测试中序遍历
		tree.LDRTraverse(root);
		//测试后序遍历
		System.out.println();
		tree.LRDTraverse(root);
		//测试非递归形式遍历二叉树
		System.out.println();
		System.out.println("非递归形式遍历二叉树");
		tree.NoRecursionTraverse(root);
		//测试使用队列完成二叉树的层序遍历
		System.out.println();
		System.out.println("完成二叉树的层序遍历");
		tree.TraverseWithQueue(root);
		
		//测试统计元素个数方法
		System.out.println();
		System.out.println("测试统计元素个数的方法:");
		int r6=tree.countNum(root);
		System.out.println(r6);
		//测试统计二叉树高度方法
		System.out.println("测试统计二叉树高度方法");
		int r7=tree.countLayer(root);
		System.out.println(r7);
		
	}
}
