package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.xjtu.play.BiTree;
import com.xjtu.structure.Node;



public class BinaryTreeInorderTraverse {

	/**
	 * 使用中序遍历
	 * @param root
	 * @return
	 */
    public static List<Integer> inorderTraversal1(Node root) {
        List<Integer> result=new ArrayList<Integer>();
        LDRTraverse(root, result);
    	return result;
    }
    public static void LDRTraverse(Node node, List<Integer> result){
    	if(node!=null){
    		LDRTraverse(node.left, result);
    		result.add(node.value);
    		LDRTraverse(node.right, result);
    	}
    }
    
    
    /**
     * 社区的代码，因为我的写的代码调用的外部方法不是别，没有一点办法
     * 调用addAll()方法的原因是每次递归的时候都会去创建一个list所以递归程序会有很多的返回的list作为
     * 中间结果值，所以底层返回的list结果值，就需要用addAll方法来添加，而不是add方法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(Node root) {
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
		Node root=new Node();
		root.value=1;
		BiTree tree=new BiTree();
		Node r1=tree.insertLeftNode(root, 2);
		Node r2=tree.insertRightNode(root,3);
		
		tree.insertLeftNode(r1, 4);
		tree.insertRightNode(r1, 5);
		tree.insertRightNode(r2,6);
		List <Integer>result=inorderTraversal(root);
		for(int K:result){
			System.out.print(K+", ");
		}
	}

}
