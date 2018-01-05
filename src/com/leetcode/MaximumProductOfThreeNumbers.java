package com.leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
	
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        int last=nums[length-1]*nums[length-2]*nums[length-3];
        int head=nums[0]*nums[1]*nums[length-1]; //�����������������Ҿ���ֵ�ܴ��ʱ���ʺ��������        
    	return last > head ? last : head; //�����������Ԫ����Ϊ���յĽ��
    }
	
	public static void main(String []args){
		int []nums={-10,-3,-2,-1,0,4,8,9};
		int res=maximumProduct(nums);
		System.out.print(res+"\t");
	}

}
