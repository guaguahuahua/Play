package com.interview;

import com.xjtu.structure.Node;

/**
 * ��������ͺ����������ؽ�������
 * @author 22847
 *
 */
public class ReconstructBinaryTree {

	/**
	 * ��������������Ի�ø��ڵ�
	 * @param pre
	 * @param in
	 * @return
	 */
    public static Node reconstructBinaryTree(int [] pre,int [] in) {
    	return backtrack(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    public static Node backtrack(int []pre, int start1, int end1, int []in, int start2 ,int end2){
    	Node root=null;
    	Node left = null;
    	Node right = null;	
    	if(start1<end1 && start2<end2){    
	    	//�������Ǵ�����������������ҵ����ڵ�
	    	root=new Node(pre[start1]);
	    	//Ѱ������������и��ڵ��λ��
	    	int index=findIndex(in, pre[start1], start2, end2);
	    	int len=start1+(index-start2);
	
        	//�ݹ��ȡ������
        	left=backtrack(pre, start1+1, len, in, start2, index-1);
        	//�ݹ��ȡ������
        	right=backtrack(pre, len+1, end1, in, index+1, end2);	
    	}    	
    	root.left=left;
    	root.right=right;
    	return root;
    }
    
    
    
    /**
     * ���Ҹ��ڵ������λ��
     * @param nums
     * @param ele
     * @return
     */
    public static int findIndex(int []nums, int ele, int start, int end){
    	for(int i=start; i<=end; i++){
    		if(nums[i]==ele){
    			return i;
    		}
    	}
    	return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []preorder={1,2,4,7,3,5,6,8};
		int []inorder={4,7,2,1,5,3,8,6};
		reconstructBinaryTree(preorder, inorder);
	}

}
