package com.xjtu.play;

public class MaxandMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int []nums={5,8,9,2,4};
		int []nums={1,1,1,1,9,1};
		maxAndMin(nums);
	}
	/**
	 * 方法一，直接求解，从数组头直到尾部，时间复杂度为o(2n)
	 * @param nums
	 */
	public static void maxAndMin_direct(int []nums){
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){///一次循环中判断了2次，分别和最大值和最小值进行比较，如果比最大值大或者比最小值小，那么就更新max，min
			if(nums[i]>max){
				max=nums[i];
			}
			if(nums[i]<min){
				min=nums[i];
			}
		}
		System.out.println("min="+min);
		System.out.println("max="+max);
	}
	
	public static void maxAndMin(int []nums){
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		if(nums.length>>1<<1==nums.length){//也就是数组包含了偶数个元素
			for(int i=0;i<nums.length;){
				if(nums[i]>nums[i+1]){///选出每组中的较大值
					if(nums[i]>max){//比较每组中的较大值较小值和max，min，判断是否要更新
						max=nums[i];
					}
					if(nums[i+1]<min){
						min=nums[i+1];
					}
				}else{
					if(nums[i+1]>max){
						max=nums[i+1];
					}
					if(nums[i]<min){
						min=nums[i+1];
					}
				}
				i+=2;
			}
		}else{//数组中有奇数个元素
			for(int i=0;i<nums.length-1;i+=2){
				if(nums[i]>nums[i+1]){///选出每组中的较大值
					if(nums[i]>max){//比较每组中的较大值较小值和max，min，判断是否要更新
						max=nums[i];
					}
					if(nums[i+1]<min){
						min=nums[i+1];
					}
				}else{
					if(nums[i+1]>max){
						max=nums[i+1];
					}
					if(nums[i]<min){
						min=nums[i+1];
					}
				}
			}
			//比较剩下的最后一个元素
			if(nums[nums.length-1]>max){
				max=nums[nums.length-1];
			}
			if(nums[nums.length-1]<min){
				min=nums[nums.length-1];
			}
		}
		System.out.println("min="+min);
		System.out.println("max="+max);
	}
}
