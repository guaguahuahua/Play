package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.xjtu.play.BiTree;
import com.xjtu.structure.BiTreeNode;



public class BinaryTreeInorderTraverse {

	/**
	 * ʹ���������
	 * @param root
	 * @return
	 */
    public static List<Integer> inorderTraversal1(BiTreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        LDRTraverse(root, result);
    	return result;
    }
    public static void LDRTraverse(BiTreeNode node, List<Integer> result){
    	if(node!=null){
    		LDRTraverse(node.left, result);
    		result.add(node.value);
    		LDRTraverse(node.right, result);
    	}
    }
    
    
    /**
     * �����Ĵ��룬��Ϊ�ҵ�д�Ĵ�����õ��ⲿ�������Ǳ�û��һ��취
     * ����addAll()������ԭ����ÿ�εݹ��ʱ�򶼻�ȥ����һ��list���Եݹ������кܶ�ķ��ص�list��Ϊ
     * �м���ֵ�����Եײ㷵�ص�list���ֵ������Ҫ��addAll��������ӣ�������add����
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(BiTreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        List<Integer> r=new ArrayList<Integer>();
        r.addAll(inorderTraversal(root.left));
        r.add(root.value);
        r.addAll(inorderTraversal(root.right));
    	return r;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiTreeNode root=new BiTreeNode();
		root.value=1;
		BiTree tree=new BiTree();
		BiTreeNode r1=tree.insertLeftNode(root, 2);
		BiTreeNode r2=tree.insertRightNode(root,3);
		
		tree.insertLeftNode(r1, 4);
		tree.insertRightNode(r1, 5);
		tree.insertRightNode(r2,6);
		List <Integer>result=inorderTraversal(root);
		for(int K:result){
			System.out.print(K+", ");
		}
	}

}
