package com.leetcode;

import java.util.Stack;

public class NextGreatElement {

//    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
//        int []result=new int[findNums.length];
//    	Stack<Integer> stack=new Stack<Integer>();
//        int j=0;//��������nums
//        for(int i=0;i<findNums.length;i++){
//        	
//        	while(j<nums.length){
//        		
//        		if(findNums[i]==nums[j]){//�����������ȣ���ôֱ���Һ�����������
//        			int index=j;
//        			while(index<nums.length){
//        				if(nums[index]>findNums[i]){
//        					break;
//        				}
//        				index++;
//        			}
//        			result[i]=nums[index];//�����ܻ���������
//        			
//        		}else{//��������������
//        			stack.push(findNums[i]);//�������ֱ����ջ
//        			break;
//        		}
//        		j++;
//        	}
//        	
//        }
//    	return null;
//    }
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int []result=new int[findNums.length];
    	for(int i=0;i<findNums.length;i++){
    		for(int j=0;j<nums.length;j++){
    			if(findNums[i]==nums[j]){
    				int index=j;
    				boolean flag=true;
    				while(index<nums.length){
    					if(nums[index]>findNums[i]){
    						flag=false;
    						break;
    					}
    					index++;
    				}
    				if(!flag){
    					result[i]=nums[index];
    					flag=true;
    				}else{
    					result[i]=-1;
    				}
    			}
    		}
    	}
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums1 = {4,1,2};
//		int []nums2 = {1,3,4,2};//Output: [-1,3,-1]
		
		int []nums1 = {2,4};
		int []nums2 = {1,2,3,4};//Output: [-1,3,-1]
		int []res=nextGreaterElement(nums1,nums2);
		for(int K:res){
			System.out.print(K+",");
		}
		System.out.println();
	}

}
