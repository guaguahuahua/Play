package com.leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
	
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        int last=nums[length-1]*nums[length-2]*nums[length-3];
        int head=nums[0]*nums[1]*nums[length-1]; //当出现两个负数并且绝对值很大的时候，适合这种情况        
    	return last > head ? last : head; //返回最后三个元素作为最终的结果
    }
	
	public static void main(String []args){
		int []nums={-10,-3,-2,-1,0,4,8,9};
		int res=maximumProduct(nums);
		System.out.print(res+"\t");
	}

}
