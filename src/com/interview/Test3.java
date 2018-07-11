package com.interview;

public class Test3 {

	public static int maxSubArray(int []nums){
		//存放最大的子数组的和
		int max=Integer.MIN_VALUE;
		//临时和
		int sum=0;
		//遍历寻找最大子数组和
		for(int i=0; i<nums.length; i++){
			sum+=nums[i];
			//如果求和为负数，临时和置为0
			if(sum<0){
				sum=0;
			//否则更新最大子数组和的值	
			}else{
				if(sum>max){
					max=sum;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={2, -3, 4, 11, -5, 8, 3, -6};
		int []nums={-1,-1,-1};
		int res=maxSubArray(nums);
		System.out.println(res);
	}

}
