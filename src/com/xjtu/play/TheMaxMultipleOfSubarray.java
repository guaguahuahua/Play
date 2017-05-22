package com.xjtu.play;

public class TheMaxMultipleOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={2,4,6};
		maxMultiple(nums);
	}
	/**
	 * 主要是给定一个长度为n的整型数组，然后计算出这个数组中长度为（n-1）的子数组中最大的乘积
	 * 主要是用了两个数组，其中一个两个数组分别存放了从左边到右边，右边到左边的所有元素的乘积，有点类似于fabonacci，只不过变成了乘法的形式
	 * 这样对任意的一个位置，只要到left，right数组中去找到该位置两侧的元素乘起来即可，因为左右两侧的元素已经是求过了累计乘积
	 * left right元素的数学表达式可以写出来
	 * @param nums
	 * @return
	 */
	public static int maxMultiple(int []nums){
		
		int length=nums.length;
		int []left=new int[length];
		int []right=new int[length];
		left[0]=nums[0];
		right[length-1]=nums[length-1];
		
		for(int i=1;i<nums.length;i++){
			left[i]=nums[i]*left[i-1];
			right[length-i-1]=nums[length-i-1]*right[length-i];
		}
		int max=0;//用来存放最大值
		for(int i=0;i<length;i++){
			if(i==0){
				max=right[i+1]>max ? right[i+1]: max;
			}else if(i==length-1){
				max=left[i-1]>max ? left[i-1] : max;
			}else{
				max=left[i-1]*right[i+1]>max ? left[i-1]*right[i+1]:max;
			}
		}
		
/*		for(int K:left){
			System.out.print(K+"\t");
		}
		System.out.println("right");
		for(int K:right){
			System.out.print(K+"\t");
		}*/
		System.out.println("max:"+max);
		return max;
	}
}
