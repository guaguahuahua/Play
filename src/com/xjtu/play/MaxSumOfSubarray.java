package com.xjtu.play;

public class MaxSumOfSubarray {
	/**
	 * 求一个数组中，和最大的子数组
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={2,8,-5,9,10};
		int r=maxSubarray_2(nums);
		System.out.println(r);
	}
	/**
	 * 直接法，直接通过三重的for循环求解子数组
	 * @param nums
	 */
	public static void maxSubarray(int []nums){
		int sum=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				int count=0;			//每次求子数组和之前先将count清0
				for(int k=i;k<=j;k++){
					count+=nums[k];
				}
				sum=count>sum ? count : sum ;
			}
		}
		System.out.println(sum);
	}
	/**
	 * 对直接法的优化，在直接法中，第三个for循环都是从从最开始的位置遍历累加，所以是重复的，可以通过
	 * 使用上次的计算值，减少计算量，也就是只要在上次的值上面加上本次的值，即可实现从头至尾的累加过程
	 * @param nums
	 * @return
	 */
	public static int maxSubarray_1(int []nums){
		
		int sum=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++){
			int count=0;
			for(int j=i;j<nums.length;j++){//因为在这块每次主要是后移一个指针，所以上次的可以使用上次的值
				count+=nums[j];
				sum=count>sum ? count : sum;
			}
		}
		return sum;
	}
	/**
	 * 求两个数中的较大值
	 * @param x
	 * @param y
	 * @return
	 */
	public static int bigger(int x,int y){
		return x>y ? x : y ;
	}
	/**
	 * 使用动态规划的方式完成了求解和最大的子数组
	 * @param nums
	 * @return
	 */
	public static int maxSubarray_2(int []nums){
		int length=nums.length;
		int []start=new int[length];
		int []all=new int[length];
		start[length-1]=nums[length-1];
		all[length-1]=nums[length-1];
		
		for(int i=length-2;i>=0;i--){
			start[i]=bigger(nums[i],nums[i]+start[i+1]);
			all[i]=bigger(all[i+1],start[i]);
		}
		return all[0];
	}
}
