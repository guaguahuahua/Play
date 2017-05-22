package com.xjtu.play;

import java.util.Arrays;

/**
 * 求最小的间距
 * @author 22847
 *
 */
public class MinGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={5,3,2,7,0};
		minGap(nums);
	}
	/**
	 * 问题是一维情形时，直接通过遍历，可以找到合适的
	 * @param nums
	 */
	public static void minGap_direct(int []nums){
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				int gap=Math.abs(nums[i]-nums[j]);
				if(gap<min){
					min=gap;
				}
			}
		}
		System.out.println("min="+min);
	}
	/**
	 * 使用了排序法，也就是先进行了排序使用时间复杂度为o(n*Log2(n)),之后再遍历一次数组，时间复杂度O(n)可以得出总的时间复杂度为o(n*(log2(n)+1))，
	 * 相比于直接法，是有一定的优势的。
	 * @param nums
	 */
	public static void minGap(int []nums){
		Arrays.sort(nums);
		//输出结果看看
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<nums.length;i++){
			if((nums[i]-nums[i-1])<min){
				min=nums[i]-nums[i-1];
			}
		}
		System.out.println("min="+min);
	}
}
