package com.leetcode;

import java.util.Arrays;

public class ArrayPartition {
	
    public static int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
//    	for(int i=0;i<nums.length;i++){
//    		System.out.print(nums[i]+"\t");
//    		
//    	}
    	int sum=0;
    	for(int i=0;i<nums.length;i+=2){
    		sum+=nums[i];
    	}
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,7,1,8};
		int res=arrayPairSum(nums);
		System.out.print(res+"\t");
	}

}
